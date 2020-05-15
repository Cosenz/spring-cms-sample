package it.cosenzproject.cmssample.app.controller;

import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.CategoryApi;
import it.cosenzproject.cmssample.app.entity.Category;
import it.cosenzproject.cmssample.core.api.CRUDRestController;

@RestController
public class CategoryController extends CRUDRestController<Category> implements CategoryApi {

}
