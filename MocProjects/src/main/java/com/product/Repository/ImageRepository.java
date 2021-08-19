package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}
