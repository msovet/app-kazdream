package kz.msovet.appkazdream.service;


import kz.msovet.appkazdream.dto.CommentPOJO;
import org.springframework.stereotype.Service;

/**
 * Service for {@link kz.msovet.appkazdream.model.Comment}
 */

@Service
public interface CommentService {
    void create(CommentPOJO commentPOJO);
}
