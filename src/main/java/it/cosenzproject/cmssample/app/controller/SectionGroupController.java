package it.cosenzproject.cmssample.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.SectionGroupApi;
import it.cosenzproject.cmssample.app.service.SectionGroupService;
import it.cosenzproject.cmssample.common.entity.Section;
import it.cosenzproject.cmssample.common.entity.SectionGroup;
import it.cosenzproject.cmssample.core.api.CRUDRestController;

@RestController
public class SectionGroupController extends CRUDRestController<SectionGroup> implements SectionGroupApi {

	@Autowired
	private SectionGroupService sectionService;

	@Override
	public ResponseEntity<List<Section>> getSections(@PathVariable("idgroup") Integer idGroup) {
		return ResponseEntity.ok(this.sectionService.getSections(idGroup));
	}

}
