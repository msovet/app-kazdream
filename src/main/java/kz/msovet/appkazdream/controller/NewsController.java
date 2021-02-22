package kz.msovet.appkazdream.controller;

import kz.msovet.appkazdream.model.Category;
import kz.msovet.appkazdream.model.Comment;
import kz.msovet.appkazdream.model.News;
import kz.msovet.appkazdream.pojo.CommentPOJO;
import kz.msovet.appkazdream.repo.NewsRepo;
import kz.msovet.appkazdream.service.impl.CommentServiceImpl;
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
    private CommentServiceImpl commentServiceImpl;

    @GetMapping
    public List<News> list() {
        return newsRepo.findAll();
    }

    @GetMapping("{id}")
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
    public void comments(@RequestBody CommentPOJO commentPOJO) {
        commentServiceImpl.create(commentPOJO);
    }

    @GetMapping("category/{id}")
    public Set<News> newsByCategory(@PathVariable("id") Category category) {
        return category.getNews();
    }
}
