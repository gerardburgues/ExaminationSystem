package com.SSD.SSD.repos;

import com.SSD.SSD.model.StudentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTestRepository extends JpaRepository<StudentTest, Integer> {
}
