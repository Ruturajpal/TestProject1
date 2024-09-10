package com.Test;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private PostService postService;

    public Post createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postService.createPost(post);
    }

    public Post updatePost(Long id, String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postService.updatePost(id, post);
    }

    public String deletePost(Long id) {
        postService.deletePost(id);
        return "Post deleted successfully";
    }
}
