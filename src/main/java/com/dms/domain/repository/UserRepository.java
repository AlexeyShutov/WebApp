package com.dms.domain.repository;

import com.dms.domain.model.User;

public interface UserRepository extends BaseRepository {

    User getByUsername(String username);
}
