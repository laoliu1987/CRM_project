package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Daka;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.DakaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private DakaDao dDao;
    @RequestMapping("/allDakaA")
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
}
