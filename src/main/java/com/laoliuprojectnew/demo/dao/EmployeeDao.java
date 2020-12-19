package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    public List<Employee> getAllEmployeeWithName(@Param("name") String name,
                                         @Param("pageStart") int PageStart,
                                         @Param("pageSize") int pageSize);
    public int getEmployeeCountsWithName(@Param("name") String name);
    public int updateState(Integer id);
    public int addDakaWithNameAndId(Integer id,String name);
    public int addEmployee(Employee employee);
    public int deleteEmployee(Integer id);
    public Employee getUpdateEmployee(Integer id);
    public int editEmployee(Employee employee);
    public List<Employee> getAllEmployeeNoDaka(@Param("pageStart") int PageStart,
                                               @Param("pageSize") int pageSize);
    public List<Employee> getAllEmployeeOkDaka(@Param("pageStart") int PageStart,
                                               @Param("pageSize") int pageSize);
    public int getAllEmployeeOkDakaNumber();
    public int getAllEmployeeNoDakaNumber();
}
