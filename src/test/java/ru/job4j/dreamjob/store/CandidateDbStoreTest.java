package ru.job4j.dreamjob.store;

import org.junit.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Candidate;


import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CandidateDbStoreTest {
    @Test
    public void whenCreateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(1, "Петр", "какое-то описание",
                LocalDateTime.now());
        store.add(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(1, "Петр", "какое-то описание1",
                LocalDateTime.now());
        store.add(candidate);
        Candidate candidateU = new Candidate(1, "Юрий", "какое-то описание2",
                candidate.getCreated());
        store.update(candidateU);
        Candidate candidateInDb = store.findById(candidateU.getId());
        assertThat(candidateInDb.getName(), is(candidateU.getName()));
    }
}