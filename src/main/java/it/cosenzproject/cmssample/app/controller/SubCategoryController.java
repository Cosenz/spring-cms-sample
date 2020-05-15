package it.cosenzproject.cmssample.app.controller;

import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.SubCategoryApi;
import it.cosenzproject.cmssample.app.entity.SubCategory;
import it.cosenzproject.cmssample.core.api.CRUDRestController;

@RestController
public class SubCategoryController extends CRUDRestController<SubCategory> implements SubCategoryApi {

}
