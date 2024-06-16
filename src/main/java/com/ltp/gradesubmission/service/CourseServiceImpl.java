package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
         return unwrapCourse(course,id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();

    }
    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }

}
