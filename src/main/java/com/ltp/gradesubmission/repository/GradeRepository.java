package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GradeRepository extends CrudRepository <Grade,Long>{
   Optional<Grade> findByStudentIdAndCourse(Long studentId, Long courseId);
  @Transactional
   void deleteByStudentIdAndCourseId(Long studentId,Long CourseId);
  List<Grade> findByStudentId(Long studentId);
  List<Grade> findCoursebyId(Long courseId);
}