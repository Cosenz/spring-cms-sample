package it.cosenzproject.cmssample.app.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.cosenzproject.cmssample.app.entity.Product;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping(value = "/product")
public interface ProductApi {

	@RequestMapping(method = RequestMethod.POST, value = "/")
	ResponseEntity<Product> createOrUpdateProduct(@Valid @RequestBody Product product);

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<Page<Product>> searchProducts(Pageable pageable, @RequestParam("text") String text);

	@RequestMapping(method = RequestMethod.GET, value = "/category")
	ResponseEntity<Page<Product>> getAllProductByCategory(Pageable pageable, @RequestParam("categoryId") Integer categoryId);

	@RequestMapping(method = RequestMethod.GET, value = "/subcategory")
	ResponseEntity<Page<Product>> getAllProductBySubCategory(Pageable pageable, @RequestParam("subcategoryId") Integer subcategoryId);
}
