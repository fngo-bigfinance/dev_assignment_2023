package com.aiceltech.devassignment.repository;

import com.aiceltech.devassignment.repository.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {

    private final Map<Integer, Post> postMap;

    public PostRepository() {
        this.postMap = new HashMap<>();
    }

    public List<Post> list() {
        return postMap.values().stream().toList();
    }

    public Post get(Integer id) {
        return postMap.get(id);
    }

    public void create(Post post) {
        if (postMap.containsKey(post.getId())) {
            throw new RuntimeException("Post exist. id = " + post.getId());
        }
        postMap.put(post.getId(), post);
    }

    public void update(Post post) {
        if (!postMap.containsKey(post.getId())) {
            throw new RuntimeException("Post not exist. id = " + post.getId());
        }
        postMap.compute(post.getId(), (k, v) -> post);
    }

    public void delete(Integer id) {
        if (!postMap.containsKey(id)) {
            throw new RuntimeException("Post not exist. id = " + id);
        }
        postMap.remove(id);
    }

}
