package it.cosenzproject.cmssample.app.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.cosenzproject.cmssample.app.model.viewmodel.CommentViewModel;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping(value = "/comment")
public interface CommentApi {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CommentViewModel> createComment(@Valid @RequestBody CommentViewModel comment);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<CommentViewModel>> getCommentsForProduct(Pageable pageable, @RequestParam("productId") Integer productId);

}
