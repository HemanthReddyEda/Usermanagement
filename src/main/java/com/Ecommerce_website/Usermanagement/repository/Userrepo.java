package com.Ecommerce_website.Usermanagement.repository;


import com.Ecommerce_website.Usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {
    Optional<User> findByName(String name);
}
