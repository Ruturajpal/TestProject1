package com.Test;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTests {

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Test
    public void testGetAllPosts() {
        List<Post> posts = Arrays.asList(new Post(1L, "Title 1", "Content 1"));
        Mockito.when(postRepository.findAll()).thenReturn(posts);

        List<Post> result = postService.getAllPosts();
        assertEquals(1, result.size());
    }

    @Test
    public void testCreatePost() {
        Post post = new Post();
        post.setTitle("New Title");
        post.setContent("New Content");

        Mockito.when(postRepository.save(post)).thenReturn(post);

        Post createdPost = postService.createPost(post);
        assertEquals("New Title", createdPost.getTitle());
    }
}

