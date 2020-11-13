package com.lyq.springbootdemo.Repository;

import com.lyq.springbootdemo.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRespository extends JpaRepository<Image,Integer> {
}
