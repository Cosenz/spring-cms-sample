package it.cosenzproject.cmssample.app.controller;

import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.LinkApi;
import it.cosenzproject.cmssample.common.entity.Link;
import it.cosenzproject.cmssample.core.api.CRUDRestController;

@RestController
public class LinkController extends CRUDRestController<Link> implements LinkApi {

}
