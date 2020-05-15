package it.cosenzproject.cmssample.app.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.cosenzproject.cmssample.app.entity.SubCategory;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping(value = "/category")
public interface MenuApi {

	@RequestMapping(method = RequestMethod.GET, value = "/{categoryId}/subcategories/")
	ResponseEntity<List<SubCategory>> getSubCategoriesByCategory(@PathVariable("categoryId") Integer categoryId);

	@RequestMapping(method = RequestMethod.GET, value = "/{categoryId}/subcategories/{id}")
	ResponseEntity<SubCategory> getSubCategory(@PathVariable("categoryId") Integer categoryId, @PathVariable("id") Integer id);

	@RequestMapping(method = RequestMethod.DELETE, value = "/{categoryId}/subcategories")
	ResponseEntity<Void> deleteSubCategory(@PathVariable("categoryId") Integer categoryId, @RequestParam("id") Integer id);
}
