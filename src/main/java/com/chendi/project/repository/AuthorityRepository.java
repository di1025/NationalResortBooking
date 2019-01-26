package com.chendi.project.repository;

import com.chendi.project.domain.Authority;
import com.chendi.project.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority,Long> {

    List<Authority> findAuthoritiesByUserId(Long userId);

    List<User> findUsersByAuthority(String authority);

}
