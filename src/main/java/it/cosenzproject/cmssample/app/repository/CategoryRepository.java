package it.cosenzproject.cmssample.app.repository;

import org.springframework.stereotype.Repository;

import it.cosenzproject.cmssample.app.entity.Category;
import it.cosenzproject.cmssample.core.repository.CRUDRepository;

@Repository
public interface CategoryRepository extends CRUDRepository<Category> {

}
