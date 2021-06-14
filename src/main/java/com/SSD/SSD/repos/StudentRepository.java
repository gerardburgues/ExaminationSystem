package com.SSD.SSD.repos;

import com.SSD.SSD.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentsByUserByUserId_Email(String email);
    Student findByIndexNo(Integer indexNo);
}