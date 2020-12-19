package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Shopping;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.ShoppingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    private ShoppingDao sDao;
    @RequestMapping("/allShoppingWithName") //获取商品
    public String getShoppingListWithName(QueryInfo queryInfo) {
        int numbers = sDao.getShoppingCountsWithName(queryInfo.getQuery());
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Shopping> Shopping = sDao.getAllShoppingWithName("%"+queryInfo.getQuery()+"%",pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", Shopping);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/addShopping") // 添加商品
    public String addShopping(@RequestBody Shopping Shopping){
        int i = sDao.addShopping(Shopping);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteShopping")//根据主键删除商品 只需提供id
    public String deleteShopping(int id){
        int i = sDao.deleteShopping(id);
        return i>0?"success":"error";
    }
    @RequestMapping("/getShoppingUpdate")// 获取需要修改信息的商品信息
    public String getUpdateShopping(int id){
        Shopping Shopping = sDao.getUpdateShopping(id);
        String string = JSON.toJSONString(Shopping);
        return string;
    }
    @RequestMapping("/editShopping") //修改商品信息
    public String editShopping(@RequestBody Shopping Shopping){
        int i = sDao.editShopping(Shopping);
        return i>0?"success":"error";
    }
}