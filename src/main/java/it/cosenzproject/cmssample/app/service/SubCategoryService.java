package it.cosenzproject.cmssample.app.service;

import java.util.List;

import it.cosenzproject.cmssample.app.entity.SubCategory;

/**
 * Interface for business operation for SubCategory
 * 
 * @author Cosenz
 *
 */
public interface SubCategoryService {

	List<SubCategory> getAllSubCategory(Integer categoryId);

	SubCategory getSubCategory(Integer categoryId, Integer subCategoryId);

	void deleteSubCategory(Integer categoryId, Integer id);
}
