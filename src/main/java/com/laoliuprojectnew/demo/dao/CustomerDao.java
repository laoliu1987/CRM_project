package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {
    public List<Customer> getAllCustomerWithName(@Param("name") String name,
                                         @Param("pageStart") int PageStart,
                                         @Param("pageSize") int pageSize);
    public int getCustomerCountsWithName(@Param("name") String name);
    public int addCustomer(Customer customer);
    public int deleteCustomer(Integer id);
    public Customer getUpdateCustomer(Integer id);
    public int editCustomer(Customer customer);
}
