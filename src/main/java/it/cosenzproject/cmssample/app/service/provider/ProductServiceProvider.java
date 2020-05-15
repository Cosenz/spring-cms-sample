package it.cosenzproject.cmssample.app.service.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.entity.Product;
import it.cosenzproject.cmssample.app.repository.ProductRepository;
import it.cosenzproject.cmssample.app.service.ProductService;
import it.cosenzproject.cmssample.common.util.Assert;
import it.cosenzproject.cmssample.core.service.CRUDServiceImp;

@Service(ProductServiceProvider.BEAN_NAME)
public class ProductServiceProvider extends CRUDServiceImp<Product> implements ProductService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.ProductServiceProvider";

	@Value("${uploadImageFolder}")
	private String basePathImage;

	@Value("${http.image.url}")
	private String httpImageUrl;

	@Autowired
	private ProductRepository repository;

	@Override
	public Page<Product> findProducts(Pageable pageable, String param) {
		Page<Product> productlist = this.repository.findByNameOrDescription(pageable, param, param);
		Assert.checkPage(productlist, "Non è stato trovato nessun prodotto con i criteri richiesti");
		return productlist;
	}

	@Override
	public Page<Product> getProductByCaretogyId(Pageable pageable, Integer categoryId) {
		return this.repository.findByCategory(pageable, categoryId);
	}

	@Override
	public Page<Product> getProductBySubCategoryId(Pageable pageable, Integer subcategoryId) {
		Page<Product> productCategories = this.repository.findBySubCategory(pageable, subcategoryId);
		Assert.checkPage(productCategories, "Non ci sono prodotti");
		return productCategories;
	}

	@Override
	public Product save(Product p) {
		Product newProduct = p;
		Product product = getOldProduct(p.getId());
		mapProperties(newProduct, product);
		uploadImage(newProduct, product);
		return repository.save(newProduct);
	}

	private void uploadImage(Product newProduct, Product product) {
		if (StringUtils.isNotBlank(newProduct.getUrlImage()) && product == null) {
			uploadImage(newProduct);
		}
	}

	private void mapProperties(Product newProduct, Product product) {
		if (product != null) {
			newProduct.setDescription(newProduct.getDescription() == null ? product.getDescription() : newProduct.getDescription());
			newProduct.setName(newProduct.getName() == null ? product.getName() : newProduct.getName());
			newProduct.setPrice(newProduct.getPrice() == null ? product.getPrice() : newProduct.getPrice());
			newProduct.setPackingSize(
			        StringUtils.isNotBlank(newProduct.getPackingSize()) ? newProduct.getPackingSize() : product.getPackingSize());
			newProduct.setPackingWeight(newProduct.getPackingWeight() != null ? newProduct.getPackingWeight() : product.getPackingWeight());
			newProduct.setUrlImage(newProduct.getUrlImage() != null ? newProduct.getUrlImage() : product.getUrlImage());
		}
	}

	private Product getOldProduct(Integer id) {
		if (id == null)
			return null;
		return getById(id);
	}

	private void uploadImage(Product newProduct) {
		try {
			String[] imageMetaData = newProduct.getUrlImage().split("(?=[a-z]*),");
			String[] typeImg = imageMetaData[0].split("data:image\\/");
			writeImage(newProduct, imageMetaData, typeImg[1].split(";")[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeImage(Product newProduct, String[] imageMetaData, String imageExt) throws IOException {
		byte[] imageByte = Base64.getDecoder().decode(imageMetaData[1]);
		String imageName = String.format("%s%d.%s", newProduct.getName(), System.currentTimeMillis(), imageExt);
		Path path = Paths.get(String.format("%s%s", basePathImage, imageName));
		Files.write(path, imageByte);
		newProduct.setUrlImage(String.format("%s%s", httpImageUrl, imageName));
	}

}
