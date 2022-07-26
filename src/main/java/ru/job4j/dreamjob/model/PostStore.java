package ru.job4j.dreamjob.model;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class PostStore {

    private static final AtomicInteger ID = new AtomicInteger(3);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "какое-то описание",
                LocalDateTime.now(), true, new City(1, "Москва")));
        posts.put(2, new Post(2, "Middle Java Job", "какое-то описание",
                LocalDateTime.now(), false, new City(2, "СПб")));
        posts.put(3, new Post(3, "Senior Java Job", "какое-то описание",
                LocalDateTime.now(), true, new City(3, "Екб")));
    }


    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        post.setId(ID.incrementAndGet());
        post.setCreated(LocalDateTime.now());
        posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }
}
