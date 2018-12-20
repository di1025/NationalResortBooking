package com.chendi.project.repository;

import com.chendi.project.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User,Long> {
}
