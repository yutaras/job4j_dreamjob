package ru.job4j.dreamjob.model;

import net.jcip.annotations.ThreadSafe;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class CandidateStore {
    private static final CandidateStore INST = new CandidateStore();

    private static final AtomicInteger ID = new AtomicInteger(3);

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Юрий", "какое-то описание",
                LocalDateTime.of(2022, 7, 22, 0, 0, 0, 0)));
        candidates.put(2, new Candidate(2, "Александр", "какое-то описание",
                LocalDateTime.of(2022, 7, 31, 0, 0, 0, 0)));
        candidates.put(3, new Candidate(3, "Петр", "какое-то описание",
                LocalDateTime.of(2017, 8, 10, 0, 0, 0, 0)));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidate.setId(ID.incrementAndGet());
        candidate.setCreated(LocalDateTime.now());
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public void update(Candidate candidate) {
        candidates.replace(candidate.getId(), candidate);
    }
}
