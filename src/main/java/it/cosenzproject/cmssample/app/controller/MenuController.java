package it.cosenzproject.cmssample.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.MenuApi;
import it.cosenzproject.cmssample.app.entity.SubCategory;
import it.cosenzproject.cmssample.app.service.SubCategoryService;

@RestController
public class MenuController implements MenuApi {

	@Autowired
	private SubCategoryService subCategoryService;

	@Override
	public ResponseEntity<List<SubCategory>> getSubCategoriesByCategory(Integer categoryId) {
		return ResponseEntity.ok(this.subCategoryService.getAllSubCategory(categoryId));
	}

	@Override
	public ResponseEntity<SubCategory> getSubCategory(@PathVariable("categoryId") Integer categoryId, @PathVariable("id") Integer id) {
		return ResponseEntity.ok(this.subCategoryService.getSubCategory(categoryId, id));
	}

	@Override
	public ResponseEntity<Void> deleteSubCategory(@PathVariable("categoryId") Integer categoryId, @RequestParam("id") Integer id) {
		this.subCategoryService.deleteSubCategory(categoryId, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
