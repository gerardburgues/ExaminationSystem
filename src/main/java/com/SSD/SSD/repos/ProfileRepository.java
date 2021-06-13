package com.SSD.SSD.repos;

import com.SSD.SSD.model.Department;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findUsersByEmail(String email);

}