package ru.job4j.dreamjob.store;

import org.junit.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostDBStoreTest {
    @Test
    public void whenCreatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(1, "Junior Java Job", "какое-то описание",
                LocalDateTime.now(), true, new City(1, "Москва"));
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(1, "Junior Java Job", "какое-то описание",
                LocalDateTime.now(), true, new City(1, "Москва"));
        store.add(post);
        Post postU = new Post(1, "Middle Java Job", "какое-то описание",
                post.getCreated(), true, new City(1, "Москва"));
        store.update(postU);
        Post postInDb = store.findById(postU.getId());
        assertThat(postInDb.getName(), is(postU.getName()));
    }

}