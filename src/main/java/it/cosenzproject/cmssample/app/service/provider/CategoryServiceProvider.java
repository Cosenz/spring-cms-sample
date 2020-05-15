package it.cosenzproject.cmssample.app.service.provider;

import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.entity.Category;
import it.cosenzproject.cmssample.app.service.CategoryService;
import it.cosenzproject.cmssample.core.service.CRUDServiceImp;

@Service(CategoryServiceProvider.BEAN_NAME)
public class CategoryServiceProvider extends CRUDServiceImp<Category> implements CategoryService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.CategoryServiceProvider";
}
