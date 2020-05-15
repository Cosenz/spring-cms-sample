package it.cosenzproject.cmssample.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.cosenzproject.cmssample.app.entity.Product;
import it.cosenzproject.cmssample.core.repository.CRUDRepository;

@Repository
public interface ProductRepository extends CRUDRepository<Product> {

	@Query("SELECT p FROM Product p WHERE p.name LIKE %:name% OR p.brand LIKE %:name% OR p.description LIKE %:description%")
	Page<Product> findByNameOrDescription(Pageable pageable, @Param("name") String name, @Param("description") String description);

	@Query("SELECT p FROM Product p INNER JOIN p.subcategories pc WHERE pc.id=:subcategoryId")
	Page<Product> findBySubCategory(Pageable pageable, @Param("subcategoryId") Integer categoryId);

	@Query("SELECT p FROM Product p INNER JOIN p.subcategories pc WHERE pc.categoryId=:categoryId")
	Page<Product> findByCategory(Pageable pageable, @Param("categoryId") Integer categoryId);
}
