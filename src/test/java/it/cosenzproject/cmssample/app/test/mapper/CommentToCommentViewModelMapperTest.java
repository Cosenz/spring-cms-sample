package it.cosenzproject.cmssample.app.test.mapper;

import static org.junit.Assert.assertEquals;

import it.cosenzproject.cmssample.app.entity.Comment;
import it.cosenzproject.cmssample.app.mapper.CommentToCommentViewModelMapper;
import it.cosenzproject.cmssample.app.mapper.CommentToCommentViewModelMapperImpl;
import it.cosenzproject.cmssample.app.model.viewmodel.CommentViewModel;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentToCommentViewModelMapperTest {

    private CommentViewModel commentViewModel;

    @Before
    public void createCommentViewModel() {
        commentViewModel = new CommentViewModel();
        commentViewModel.setId(1);
        commentViewModel.setMessage("new comment");
        commentViewModel.setDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
    }

    @Test
    public void commentViewToComment() {
        CommentToCommentViewModelMapper mapper = new CommentToCommentViewModelMapperImpl();
        Comment comment = mapper.commentViewToComment(commentViewModel);
        assertEquals(commentViewModel.getMessage(), comment.getMessage());
    }
}
