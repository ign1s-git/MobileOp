package org.mobileOp.repositories;

import org.mobileOp.Objects.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<User, Long> автоматически предоставляет базовые методы:
    // .findAll()           -> SELECT * FROM users;
    // .findById(id)        -> SELECT * FROM users WHERE id = ?;
    // .save(user)          -> INSERT INTO users ... или UPDATE users ...;
    // .deleteById(id)      -> DELETE FROM users WHERE id = ?;
    //
    // Если понадобятся кастомные методы поиска, Spring Data генерирует их сам по имени:
    // Optional<User> findByName(String name);
    // Optional<User> findByPassportData(String passportData);
}
