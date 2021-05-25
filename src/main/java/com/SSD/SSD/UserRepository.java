package com.SSD.SSD;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SSD.SSD.model.*;
import org.springframework.data.repository.NoRepositoryBean;


public interface UserRepository extends JpaRepository<User,Long> {


}
