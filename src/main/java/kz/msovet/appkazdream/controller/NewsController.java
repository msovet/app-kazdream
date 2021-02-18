package kz.msovet.appkazdream.controller;

import kz.msovet.appkazdream.model.News;
import kz.msovet.appkazdream.repo.NewsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {
    private final NewsRepo newsRepo;

    public NewsController(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

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
}
