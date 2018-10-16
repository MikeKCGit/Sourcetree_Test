package com.MikeKC.training.repositiry;

import com.MikeKC.training.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository <Users, Long> {

    Users findByName(String name);
}
