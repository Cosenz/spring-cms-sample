package it.cosenzproject.cmssample.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.cosenzproject.cmssample.app.entity.Comment;
import it.cosenzproject.cmssample.core.repository.CRUDRepository;

@Repository
public interface CommentRepository extends CRUDRepository<Comment> {

	@Query("SELECT c FROM Comment c INNER JOIN c.product p Where p.id=:productId")
	Page<Comment> findByProduct(Pageable pageable, @Param("productId") Integer productId);
}
