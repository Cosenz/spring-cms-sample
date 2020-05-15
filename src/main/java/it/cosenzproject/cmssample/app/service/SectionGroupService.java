package it.cosenzproject.cmssample.app.service;

import java.util.List;

import it.cosenzproject.cmssample.common.entity.Section;

/**
 * Interface for business operation for SectionGroup
 * 
 * @author Cosenz
 *
 */
public interface SectionGroupService {

	List<Section> getSections(Integer idGroup);
}
