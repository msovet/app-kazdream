package kz.msovet.appkazdream.controller;

import kz.msovet.appkazdream.model.Category;
import kz.msovet.appkazdream.model.Comment;
import kz.msovet.appkazdream.model.News;
import kz.msovet.appkazdream.repo.CommentRepo;
import kz.msovet.appkazdream.repo.NewsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsRepo newsRepo;

    @Autowired
    private CommentRepo commentRepo;

    @GetMapping
//    @JsonView(Views.IdName.class)
    public List<News> list() {
        return newsRepo.findAll();
    }

    @GetMapping("{id}")
//    @JsonView(Views.FullMessage.class)
    public News getOne(@PathVariable("id") News news) {
        return news;
    }

    @PostMapping
    public News create(@RequestBody News news) {
        news.setCreationDate(LocalDateTime.now());
        return newsRepo.save(news);
    }

    @PutMapping("{id}")
    public News update(
            @PathVariable("id") News newsFromDb,
            @RequestBody News news
    ) {
        BeanUtils.copyProperties(news, newsFromDb, "id");

        return newsRepo.save(newsFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") News news) {
        newsRepo.delete(news);
    }

    @GetMapping("{id}/comments")
    public List<Comment> comments(@PathVariable("id") News news) {
        return news.getComments();
    }

    @PostMapping("{id}/comments")
    public void comments(@PathVariable("id") News news,
                                @RequestBody Comment comment) {
        comment.setNews(news);
        commentRepo.save(comment);
    }

    @GetMapping("category/{id}")
    public Set<News> newsByCategory(@PathVariable("id") Category category) {
        return category.getNews();
    }
}
