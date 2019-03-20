package fi.tuni.myblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    PostsRepository posts;

    @RequestMapping(value = "api/posts", method = RequestMethod.GET)
    public Iterable<Post> getPosts() {
        return posts.findAll();
    }
}
