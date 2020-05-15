package it.cosenzproject.cmssample.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.cosenzproject.cmssample.app.model.viewmodel.CommentViewModel;

public interface CommentService {

	CommentViewModel createComment(CommentViewModel comment);

	Page<CommentViewModel> getCommentsByProductId(Pageable pageable, Integer productId);
}
