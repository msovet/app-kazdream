package kz.msovet.appkazdream.controller;

import kz.msovet.appkazdream.model.Category;
import kz.msovet.appkazdream.model.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

//@RestController
//@RequestMapping("category")
//public class CategoryController {
//    @GetMapping("{id}")
//    public Set<News> newsByCategory(@PathVariable("id") Category category) {
//        return category.getNews();
//    }
//}
