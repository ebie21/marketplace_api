package com.marketplace.marketplace_api.repository;

import com.marketplace.marketplace_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
