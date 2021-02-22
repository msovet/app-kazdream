package kz.msovet.appkazdream.service;


import kz.msovet.appkazdream.model.Comment;
import kz.msovet.appkazdream.pojo.CommentPOJO;
import org.springframework.stereotype.Service;

/**
 * Service for {@link Comment}
 */

@Service
public interface CommentService {
    void create(CommentPOJO commentPOJO);
}
