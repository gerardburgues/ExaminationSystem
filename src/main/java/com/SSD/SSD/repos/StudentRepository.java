package com.SSD.SSD.repos;

import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findAllByStudentId(Integer studentId);
    Optional<Student> findStudentsByUserByUserId_Email(String email);

}
