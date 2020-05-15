package it.cosenzproject.cmssample.app.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping(value = "/subcategory")
public interface SubCategoryApi {

}
