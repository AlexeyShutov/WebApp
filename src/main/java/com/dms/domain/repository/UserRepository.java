package com.dms.domain.repository;

import com.dms.domain.model.User;
import java.util.List;

public interface UserRepository {

    List<User> getAll();

    User getById(Integer id);

    User getByUsername(String username);

    void add(User user);

    void update(User user);

    void delete(User user);
}
