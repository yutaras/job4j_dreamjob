package ru.job4j.dreamjob.model;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostService {

    private final PostStore store;

    public PostService(PostStore store) {
        this.store = store;
    }

    public void add(Post post) {
        store.add(post);
    }

    public void update(Post post) {
        store.update(post);
    }

    public Post findById(int id) {
        return store.findById(id);
    }

    public Collection<Post> findAll() {
        return store.findAll();
    }
}

