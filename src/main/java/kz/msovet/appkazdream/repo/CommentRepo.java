package kz.msovet.appkazdream.repo;

import kz.msovet.appkazdream.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
