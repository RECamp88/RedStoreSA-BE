package com.rachelcampbell.RedStoreSA.Repository;

import com.rachelcampbell.RedStoreSA.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

     public Login findByEmail(String email);
}
