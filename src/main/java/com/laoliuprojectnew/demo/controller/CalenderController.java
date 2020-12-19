package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Calender;
import com.laoliuprojectnew.demo.dao.CalenderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CalenderController {
    @Autowired
    private CalenderDao caDao;

    @RequestMapping("/allCalender")//获取所有顾客
    public String getCustomerListWithName() {
        List<Calender> calender = caDao.getAllCalender();
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", calender);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/addCalender") // 添加顾客
    public String addCalender(@RequestBody Calender calender){
        int i = caDao.addCalender(calender);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteCalender")//根据主键删除信息 只需提供id
    public String deleteCCalender(String date){
        int i = caDao.deleteCalender(date);
        return i>0?"success":"error";
    }
    @RequestMapping("/getCalenderUpdate")// 获取需要修改信息的顾客信息
    public String getUpdateCalender(String date){
        Calender calender = caDao.getUpdateCalender(date);
        String string = JSON.toJSONString(date);
        return string;
    }
    @RequestMapping("/editCalender") //修改顾客信息
    public String editCalender(@RequestBody Calender calender){
        int i = caDao.editCalender(calender);
        return i>0?"success":"error";
    }
}