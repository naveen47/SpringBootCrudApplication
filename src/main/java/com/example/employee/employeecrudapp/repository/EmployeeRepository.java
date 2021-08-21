package com.example.employee.employeecrudapp.repository;

import java.util.List;

import com.example.employee.employeecrudapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findByName(String name);


    @Query("SELECT e FROM Employee e WHERE e.designation =:d")
    public List<Employee> findEmployeeByDesignation(@Param("d") String designation);


    @Query("select e from Employee e")
    public List<Employee> getAllEmployessByJPQL();


    @Query(value = "select * from employee", nativeQuery = true)
    public List<Employee> getAllEmployeeByNative();


    @Query(value = "select * from employee where name = ? and designation = ?", nativeQuery = true)
    public List<Employee> getAllEmployeeByNativeParameter(String name, String designation);

    
    @Modifying(clearAutomatically = true)
    @Query("update Employee e set e.name =:name, e.designation =:designation, e.salary =:salary, e.company =:company where e.id =:id")
    public void updateEmployeeById(@Param("id") Integer id, @Param("name") String name, @Param("designation") String designation, @Param("salary") Float salary, @Param("company") String company);
    
}
