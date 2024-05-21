package com.trestle.redis.Cashing.repo;

import com.trestle.redis.Cashing.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {
}
