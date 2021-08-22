package com.cinema.userservice.repository;

import com.cinema.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update User u set u.email = ?1, u.password = ?2 where u.id = ?3")
    void updateUser(String email, String password, int id);

    User findByEmail(String email);
}
