package com.Rapid.kenApp.repository;

import com.Rapid.kenApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    @Query(value="select * from employees_list where department = :depname ",nativeQuery = true)
    List<Employee> findByDepartment(@Param("depname") String department);

    @Query(value="select * from employees_list where position = :position ",nativeQuery = true)
    List<Employee> findByPosition(@Param("position") String position);

    @Query(value="select * from employees_list limit  :limit ",nativeQuery = true)
    List<Employee> findByLimit(@Param("limit") int limit);

    @Query(value="select * from employees_list where position=:position ,department=:department limit  :limit ",nativeQuery = true)
    List<Employee> findByDepartmentPositionLimit(@Param("position")String position ,@Param("department")String department, @Param("limit") int limit);

}
