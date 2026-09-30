package org.mobileOp.repositories;

import org.mobileOp.Objects.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository автоматически предоставляет:
    // findAll() -> SELECT * FROM users
    // findById(id) -> SELECT * FROM users WHERE id = ?
    // save(user) -> INSERT или UPDATE
    // deleteById(id) -> DELETE FROM users WHERE id = ?

//    Optional<User> findByName(String name);
//    Optional<User> findByPassportData(String passportData);
}
