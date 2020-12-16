package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Customer;
import com.laoliuprojectnew.demo.bean.Daka;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.DakaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class DakaController {
    @Autowired
    private DakaDao dDao;
    @RequestMapping("/allDaka")
    public String getDakaList(QueryInfo queryInfo) {
        int numbers = dDao.getDakaCounts();
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Daka> daka = dDao.getAllDaka(pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", daka);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/addDaka") //添加打卡记录
    public String addDaka(@RequestBody Daka daka){
        int i = dDao.addDaka(daka);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteDaka")//根据主键删除信息 只需提供id
    public String deleteDaka(int id){
        int i = dDao.deleteDaka(id);
        return i>0?"success":"error";
    }
    @RequestMapping("/getDakaUpdate")// 或许需要修改信息的打卡信息
    public String getUpdateCustomer(int id){
        Daka daka = dDao.getUpdateDaka(id);
        String string = JSON.toJSONString(daka);
        return string;
    }
    @RequestMapping("/editDaka") //修改打卡信息
    public String editCustomer(@RequestBody Daka daka){
        int i = dDao.editDaka(daka);
        return i>0?"success":"error";
    }
}
