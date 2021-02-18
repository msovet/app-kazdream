package kz.msovet.appkazdream.repo;

import kz.msovet.appkazdream.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Long> {

}
