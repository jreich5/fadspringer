package com.codeup.fadspringer.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
//    @Query("select u from User u where email = ?1")
    User findByEmail(String email);

//    @Query(value = "SELECT * FROM users where id = ?", nativeQuery = true)
//    User findByCustom(String something);

    User findById(long id);

}
