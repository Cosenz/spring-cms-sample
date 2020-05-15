package it.cosenzproject.cmssample.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.cosenzproject.cmssample.app.entity.SubCategory;
import it.cosenzproject.cmssample.core.repository.CRUDRepository;

@Repository
public interface SubCategoryRepository extends CRUDRepository<SubCategory> {

	List<SubCategory> findByCategoryId(Integer categoryId);

	Optional<SubCategory> findByIdAndCategoryId(Integer id, Integer categoryId);

	@Transactional
	@Modifying
	void deleteByIdAndCategoryId(@Param("id") Integer id, @Param("categoryId") Integer categoryId);
}
