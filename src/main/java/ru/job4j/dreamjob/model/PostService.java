package ru.job4j.dreamjob.model;

import java.util.Collection;

public class PostService {
    private static final PostService INST = new PostService();
    private final PostStore store = PostStore.instOf();

    public static PostService instOf() {
        return INST;
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

