package fi.tuni.myblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyblogApplication implements CommandLineRunner {

    @Autowired
    PostsRepository postsRep;

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Hello");
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Janne", "HURHURHURHURHURHHRUH"));
        posts.add(new Post("Jormis", "GYGYGYGYGGYGGYGYGGGYG"));
        postsRep.saveAll(posts);
    }

}
