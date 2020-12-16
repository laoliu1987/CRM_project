package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Customer;
import com.laoliuprojectnew.demo.bean.Employee;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao eDao;

    @RequestMapping("/allEmployee") //列出所有员工
    public String getEmployeeList(QueryInfo queryInfo){
        int numbers = eDao.getEmployeeCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Employee> employee = eDao.getAllEmployee("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", employee);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/EmployeeState") //修改员工状态（打卡）
    public String updateEmployeeState(@RequestParam("id")Integer id){
        int i = eDao.updateState(id);
        return i > 0 ? "success":"error";
    }
    @RequestMapping("/addEmployee") // 添加员工
    public String addEmployee(@RequestBody Employee employee){
        int i = eDao.addEmployee(employee);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteEmployee")//根据主键删除信息 只需提供id
    public String deleteEmployee(int id){
        int i = eDao.deleteEmployee(id);
        return i>0?"success":"error";
    }
    @RequestMapping("/getUpdate")// 或许需要修改信息的员工信息
    public String getUpdateEmployee(int id){
        Employee employee = eDao.getUpdateEmployee(id);
        String string = JSON.toJSONString(employee);
        return string;
    }
    @RequestMapping("/editEmployee") //修改员工信息
    public String editEmployee(@RequestBody Employee employee){
        int i = eDao.editEmployee(employee);
        return i>0?"success":"error";
    }
}
