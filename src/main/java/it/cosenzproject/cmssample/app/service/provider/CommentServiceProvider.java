package it.cosenzproject.cmssample.app.service.provider;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.entity.Comment;
import it.cosenzproject.cmssample.app.entity.Product;
import it.cosenzproject.cmssample.app.mapper.CommentToCommentViewModelMapper;
import it.cosenzproject.cmssample.app.model.viewmodel.CommentViewModel;
import it.cosenzproject.cmssample.app.repository.CommentRepository;
import it.cosenzproject.cmssample.app.service.CommentService;

@Service(CommentServiceProvider.BEAN_NAME)
public class CommentServiceProvider implements CommentService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.CommentServiceProvider";

	@Autowired
	private CommentToCommentViewModelMapper mapper;

	@Autowired
	private CommentRepository repository;

	@Override
	public CommentViewModel createComment(CommentViewModel comment) {
		if (comment == null || StringUtils.isBlank(comment.getMessage())) {
			throw new InvalidParameterException("comment nullo o test del messaggio non valorizzato");
		}
		comment.setDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		// START Map to DB
		Comment commentEntity = mapper.commentViewToComment(comment);
		commentEntity.setProduct(new Product());
		commentEntity.getProduct().setId(comment.getProductId());
		// END MAP

		commentEntity = repository.save(commentEntity);

		// START Map to View
		comment.setId(commentEntity.getId());
		// END
		return comment;
	}

	@Override
	public Page<CommentViewModel> getCommentsByProductId(Pageable pageable, Integer productId) {
		Page<Comment> comments = this.repository.findByProduct(pageable, productId);
		Page<CommentViewModel> commentsViewModel = comments.map(c -> {
			CommentViewModel cvm = mapper.commentoToCommentViewModel(c);
			cvm.setProductId(c.getProduct() != null ? c.getProduct().getId() : null);
			if (c.getUser() != null) {
				cvm.setUser(mapper.usertoUserViewModel(c.getUser()));
			}
			return cvm;
		});
		return commentsViewModel;
	}

}
