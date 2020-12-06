package com.hubino.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hubino.jwt.model.Department;



@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long> {

	Department findByDeptName(String name);
}
