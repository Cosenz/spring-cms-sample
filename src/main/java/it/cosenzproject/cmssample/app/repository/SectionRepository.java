package it.cosenzproject.cmssample.app.repository;

import org.springframework.stereotype.Repository;

import it.cosenzproject.cmssample.common.entity.Section;
import it.cosenzproject.cmssample.core.repository.CRUDRepository;

@Repository
public interface SectionRepository extends CRUDRepository<Section> {

	// List<Section> findByGroup(SectionGroup group);
}
