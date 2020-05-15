package it.cosenzproject.cmssample.app.repository;

import org.springframework.stereotype.Repository;

import it.cosenzproject.cmssample.common.entity.SectionGroup;
import it.cosenzproject.cmssample.core.repository.CRUDRepository;

@Repository
public interface SectionGroupRepository extends CRUDRepository<SectionGroup> {

}
