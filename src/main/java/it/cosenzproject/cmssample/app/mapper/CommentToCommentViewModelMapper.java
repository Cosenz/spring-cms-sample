package it.cosenzproject.cmssample.app.mapper;

import org.mapstruct.Mapper;

import it.cosenzproject.cmssample.app.entity.Comment;
import it.cosenzproject.cmssample.app.entity.User;
import it.cosenzproject.cmssample.app.model.viewmodel.CommentViewModel;
import it.cosenzproject.cmssample.app.model.viewmodel.UserViewModel;

@Mapper(componentModel = "spring")
public interface CommentToCommentViewModelMapper {

	Comment commentViewToComment(CommentViewModel viewModel);

	CommentViewModel commentoToCommentViewModel(Comment entity);

	UserViewModel usertoUserViewModel(User user);

}
