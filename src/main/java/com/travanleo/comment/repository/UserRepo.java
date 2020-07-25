package com.travanleo.comment.repository;

import com.travanleo.comment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
