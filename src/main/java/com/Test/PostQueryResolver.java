package com.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PostService postService;

    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    public Post getPostById(Long id) {
        return postService.getPostById(id).orElseThrow(() -> new ConfigDataResourceNotFoundException("Post not found"));
    }
}
