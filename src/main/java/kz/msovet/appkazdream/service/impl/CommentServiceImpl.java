package kz.msovet.appkazdream.service.impl;

import kz.msovet.appkazdream.dto.CommentPOJO;
import kz.msovet.appkazdream.model.Comment;
import kz.msovet.appkazdream.model.News;
import kz.msovet.appkazdream.repo.NewsRepo;
import kz.msovet.appkazdream.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of service {@link CommentService}
 */

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private NewsRepo newsRepo;
    @Override
    public void create(CommentPOJO commentPOJO) {
        Optional<News> news = newsRepo.findById(commentPOJO.getNewsId());
        Comment comment = new Comment();
        comment.setNews(news.get());
        comment.setText(commentPOJO.getText());
    }
}
