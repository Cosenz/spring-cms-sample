package it.cosenzproject.cmssample.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.ProductApi;
import it.cosenzproject.cmssample.app.entity.Product;
import it.cosenzproject.cmssample.app.service.ProductService;
import it.cosenzproject.cmssample.core.api.CRUDRestController;

@RestController
public class ProductController extends CRUDRestController<Product> implements ProductApi {

	@Autowired
	private ProductService service;

	@Override
	public ResponseEntity<Page<Product>> searchProducts(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults(
	    { @SortDefault(sort = "name", direction = Sort.Direction.DESC) }
	) Pageable pageable, @RequestParam("text") String text) {
		return ResponseEntity.ok(service.findProducts(pageable, text));
	}

	@Override
	public ResponseEntity<Page<Product>> getAllProductByCategory(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults(
	    { @SortDefault(sort = "name", direction = Sort.Direction.DESC) }
	) Pageable pageable, @RequestParam("categoryId") Integer categoryId) {
		return ResponseEntity.ok(this.service.getProductByCaretogyId(pageable, categoryId));
	}

	@Override
	public ResponseEntity<Page<Product>> getAllProductBySubCategory(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults(
	    { @SortDefault(sort = "name", direction = Sort.Direction.DESC) }
	) Pageable pageable, @RequestParam("subcategoryId") Integer subcategoryId) {
		return ResponseEntity.ok(this.service.getProductBySubCategoryId(pageable, subcategoryId));
	}

	@Override
	public ResponseEntity<Product> createOrUpdateProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.ok(service.save(product));
	}

}
