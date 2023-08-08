package com.rachelcampbell.RedStoreSA.Repository;

import com.rachelcampbell.RedStoreSA.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}