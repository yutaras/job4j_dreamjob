package ru.job4j.dreamjob.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostStore {

    private static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "какое-то описание",
                LocalDateTime.of(2022, 5, 22, 0, 0, 0, 0)));
        posts.put(2, new Post(2, "Middle Java Job", "какое-то описание",
                LocalDateTime.of(2022, 1, 31, 0, 0, 0, 0)));
        posts.put(3, new Post(3, "Senior Java Job", "какое-то описание",
                LocalDateTime.of(2021, 12, 10, 0, 0, 0, 0)));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        posts.put(posts.size(), post);
    }
}
