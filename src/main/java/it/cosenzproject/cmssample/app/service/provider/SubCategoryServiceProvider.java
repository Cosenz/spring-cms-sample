package it.cosenzproject.cmssample.app.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.entity.SubCategory;
import it.cosenzproject.cmssample.app.repository.SubCategoryRepository;
import it.cosenzproject.cmssample.app.service.SubCategoryService;
import it.cosenzproject.cmssample.common.exception.ResourceNotFoundRuntimeException;
import it.cosenzproject.cmssample.core.service.CRUDServiceImp;

@Service(SubCategoryServiceProvider.BEAN_NAME)
public class SubCategoryServiceProvider extends CRUDServiceImp<SubCategory> implements SubCategoryService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.SubCategoryServiceProvider";

	@Autowired
	private SubCategoryRepository repository;

	@Override
	public List<SubCategory> getAllSubCategory(Integer categoryId) {
		return this.repository.findByCategoryId(categoryId);
	}

	@Override
	public SubCategory getSubCategory(Integer categoryId, Integer subCategoryId) {
		return this.repository.findByIdAndCategoryId(subCategoryId, categoryId)
		        .orElseThrow(() -> new ResourceNotFoundRuntimeException("SubCateogry non trovata nella category specificata"));
	}

	@Override
	public void deleteSubCategory(Integer categoryId, Integer id) {
		repository.deleteByIdAndCategoryId(id, categoryId);
	}
}
