package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }

    @GetMapping("/hello/posts/save")
    public void helloPostsSave(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("author") String author){
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build()
        );
    }

    @GetMapping("/hello/posts/find")
    public void helloPostsFind(){
        List<Posts> postsList = postsRepository.findAll();

    }
}
