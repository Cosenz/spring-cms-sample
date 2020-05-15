package it.cosenzproject.cmssample.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.CommentApi;
import it.cosenzproject.cmssample.app.model.viewmodel.CommentViewModel;
import it.cosenzproject.cmssample.app.service.CommentService;

@RestController
public class CommentController implements CommentApi {

	@Autowired
	private CommentService service;

	@Override
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<CommentViewModel> createComment(@Valid @RequestBody CommentViewModel comment) {
		return ResponseEntity.ok(this.service.createComment(comment));
	}

	@Override
	public ResponseEntity<Page<CommentViewModel>> getCommentsForProduct(Pageable pageable, @RequestParam("productId") Integer productId) {
		return ResponseEntity.ok(this.service.getCommentsByProductId(pageable, productId));
	}

}
