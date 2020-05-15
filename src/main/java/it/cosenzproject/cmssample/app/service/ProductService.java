package it.cosenzproject.cmssample.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.cosenzproject.cmssample.app.entity.Product;

/**
 * Interface for business operation for Prduct
 * 
 * @author Cosenz
 *
 */
public interface ProductService {

	Product save(Product p);

	Page<Product> findProducts(Pageable pageable, String param);

	Page<Product> getProductByCaretogyId(Pageable pageable, Integer categoryId);

	Page<Product> getProductBySubCategoryId(Pageable pageable, Integer subcategoryId);

}
