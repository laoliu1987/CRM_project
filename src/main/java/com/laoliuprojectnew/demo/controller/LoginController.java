package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Admin;
import com.laoliuprojectnew.demo.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    AdminDao adminDao;

    @CrossOrigin
    @RequestMapping("/login")
    public String login(@RequestBody Admin admin){
        String flag = "error";
        Admin ad = adminDao.getAdminByMessage(admin.getUsername(),admin.getPassword());
        HashMap<String,Object> res = new HashMap<>();
        if(ad!=null){
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("admin",admin);
        String  res_json =JSON.toJSONString(res);
        return res_json;
    }
}
