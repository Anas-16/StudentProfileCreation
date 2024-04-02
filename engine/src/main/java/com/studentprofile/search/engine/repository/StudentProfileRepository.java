package com.studentprofile.search.engine.repository;


import com.studentprofile.search.engine.entity.StudentProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends CrudRepository<StudentProfile, Integer> {
}
