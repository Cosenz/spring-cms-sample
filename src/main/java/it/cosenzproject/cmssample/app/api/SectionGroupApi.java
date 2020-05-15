package it.cosenzproject.cmssample.app.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.cosenzproject.cmssample.common.entity.Section;

@RequestMapping(value = "/sectiongroup")
public interface SectionGroupApi {

	@RequestMapping(method = RequestMethod.GET, value = "/{idgroup}/section/")
	ResponseEntity<List<Section>> getSections(@PathVariable("idgroup") Integer idgroup);

}
