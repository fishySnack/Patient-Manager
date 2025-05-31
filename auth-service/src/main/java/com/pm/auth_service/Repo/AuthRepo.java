package com.pm.auth_service.Repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.auth_service.Model.User;

@Repository
public interface AuthRepo extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

}
