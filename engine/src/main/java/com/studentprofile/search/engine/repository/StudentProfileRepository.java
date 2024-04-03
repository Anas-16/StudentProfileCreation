package com.studentprofile.search.engine.repository;


import com.studentprofile.search.engine.entity.StudentProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends CrudRepository<StudentProfile, Integer> {
    List<StudentProfile> findByName(String name);
}
