package com.SSD.SSD.repos;

import com.SSD.SSD.model.Course;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

    StudentCourse findByStudentByStudentIdAndCourseByCourseId(Student studentByStudentId, Course courseByCourseId);
}
