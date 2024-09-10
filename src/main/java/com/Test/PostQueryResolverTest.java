package com.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.example.demo.service.PostService;
import com.example.demo.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class PostQueryResolverTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostQueryResolver postQueryResolver;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPosts() {
        Post post1 = new Post(1L, "Title 1", "Content 1");
        Post post2 = new Post(2L, "Title 2", "Content 2");
        List<Post> posts = Arrays.asList(post1, post2);

        when(postService.getAllPosts()).thenReturn(posts);

        List<Post> result = postQueryResolver.getAllPosts();
        assertEquals(2, result.size());
        assertEquals("Title 1", result.get(0).getTitle());
    }
}
