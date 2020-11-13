package com.lyq.springbootdemo.Repository;

import com.lyq.springbootdemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRespository extends JpaRepository<User, Integer> {
}
