package com.SSD.SSD.repos;

import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.StudentTest;
import com.SSD.SSD.model.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentTestRepository extends JpaRepository<StudentTest, Integer> {

    Optional<StudentTest> findByStudentByStudentIdAndTestByTestId(Student student, Tests test);
}
