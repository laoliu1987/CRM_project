package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Customer;
import com.laoliuprojectnew.demo.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {
    public List<Customer> getAllCustomer(@Param("name") String name,
                                         @Param("pageStart") int PageStart,
                                         @Param("pageSize") int pageSize);
    public int getCustomerCounts(@Param("name") String name);
    public int addCustomer(Customer customer);
    public int deleteCustomer(Integer id);
    public Customer getUpdateCustomer(Integer id);
    public int editCustomer(Customer customer);
}
