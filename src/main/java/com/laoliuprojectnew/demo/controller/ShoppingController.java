package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Shopping;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.ShoppingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    private ShoppingDao sDao;
    @RequestMapping("/allShoppingWithName") //获取消费记录
    public String getShoppingListWithName(QueryInfo queryInfo) {
        int numbers = sDao.getShoppingCountsWithName(queryInfo.getQuery());
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Shopping> shopping = sDao.getAllShoppingWithName("%"+queryInfo.getQuery()+"%",pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", shopping);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/addShopping") // 添加消费记录
    public String addShopping(@RequestBody Shopping shopping){
        int i = sDao.addShopping(shopping);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteShopping")//根据主键删除商消费记录 只需提供id
    public String deleteShopping(int id){
        int i = sDao.deleteShopping(id);
        return i>0?"success":"error";
    }
    @RequestMapping("/getShoppingUpdate")// 获取需要修改消费记录的消费记录
    public String getUpdateShopping(@RequestParam("cname")String cname){
        List<Shopping> shopping = sDao.getUpdateShopping(cname);
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", shopping);
        String string = JSON.toJSONString(res);
        return string;
    }
    @RequestMapping("/editShopping") //修改消费记录
    public String editShopping(@RequestBody Shopping shopping){
        int i = sDao.editShopping(shopping);
        return i>0?"success":"error";
    }
}