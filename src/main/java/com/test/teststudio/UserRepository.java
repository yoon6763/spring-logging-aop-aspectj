package com.test.teststudio;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class UserRepository {

    private final ConcurrentMap<Long, User> memoryDb = new ConcurrentHashMap<>();

    public User findById(Long id) {
        return memoryDb.get(id);
    }

    public void save(User user) {
        Long id = generateId();
        user.setId(id);
        memoryDb.put(id, user);
    }

    private Long generateId() {
        return memoryDb.keySet().stream()
                .max(Long::compareTo)
                .map(id -> id + 1)
                .orElse(1L);
    }

}
