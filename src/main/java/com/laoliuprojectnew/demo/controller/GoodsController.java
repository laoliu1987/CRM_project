package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Goods;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsDao gDao;
    @RequestMapping("/allGoodsWithName") //获取商品
    public String getGoodsListWithName(QueryInfo queryInfo) {
        int numbers = gDao.getGoodsCountsWithName(queryInfo.getQuery());
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Goods> goods = gDao.getAllGoodsWithName("%"+queryInfo.getQuery()+"%",pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", goods);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/addGoods") // 添加商品
    public String addGoods(@RequestBody Goods goods){
        int i = gDao.addGoods(goods);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteGoods")//根据主键删除商品 只需提供id
    public String deleteGoods(int id){
        int i = gDao.deleteGoods(id);
        return i>0?"success":"error";
    }
    @RequestMapping("/getGoodsUpdate")// 获取需要修改信息的商品信息
    public String getUpdateGoods(int id){
        Goods goods = gDao.getUpdateGoods(id);
        String string = JSON.toJSONString(goods);
        return string;
    }
    @RequestMapping("/editGoods") //修改商品信息
    public String editCustomer(@RequestBody Goods goods){
        int i = gDao.editGoods(goods);
        return i>0?"success":"error";
    }
}
