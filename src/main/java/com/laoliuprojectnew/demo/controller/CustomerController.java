package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Customer;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerDao cDao;

    @RequestMapping("/allCustomerWithName")//获取所有顾客
    public String getCustomerListWithName(QueryInfo queryInfo) {
        int numbers = cDao.getCustomerCountsWithName(queryInfo.getQuery());
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Customer> customer = cDao.getAllCustomerWithName("%"+queryInfo.getQuery()+"%",pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", customer);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/addCustomer") // 添加顾客
    public String addCustomer(@RequestBody Customer customer){
        int i = cDao.addCustomer(customer);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteCustomer")//根据主键删除信息 只需提供id
    public String deleteCustomer(int id){
        int i = cDao.deleteCustomer(id);
        return i>0?"success":"error";
    }
    @RequestMapping("/getCustomerUpdate")// 获取需要修改信息的顾客信息
    public String getUpdateCustomer(int id){
        Customer customer = cDao.getUpdateCustomer(id);
        String string = JSON.toJSONString(customer);
        return string;
    }
    @RequestMapping("/editCustomer") //修改顾客信息
    public String editCustomer(@RequestBody Customer customer){
        int i = cDao.editCustomer(customer);
        return i>0?"success":"error";
    }
}
