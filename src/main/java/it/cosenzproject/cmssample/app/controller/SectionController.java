package it.cosenzproject.cmssample.app.controller;

import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.SectionApi;
import it.cosenzproject.cmssample.common.entity.Section;
import it.cosenzproject.cmssample.core.api.CRUDRestController;

@RestController
public class SectionController extends CRUDRestController<Section> implements SectionApi {

}
