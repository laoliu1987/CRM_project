package com.laoliuprojectnew.demo.controller;

import com.alibaba.fastjson.JSON;
import com.laoliuprojectnew.demo.bean.Goods;
import com.laoliuprojectnew.demo.bean.Operation;
import com.laoliuprojectnew.demo.bean.QueryInfo;
import com.laoliuprojectnew.demo.dao.GoodsDao;
import com.laoliuprojectnew.demo.dao.OperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class OperationController {
    @Autowired
    private OperationDao oDao;
    @RequestMapping("/allOperationWithName") //获取商品
    public String getOperationListWithName(QueryInfo queryInfo) {
        int numbers = oDao.getOperationCountsWithName(queryInfo.getQuery());
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Operation> operation = oDao.getAllOperationWithName("%"+queryInfo.getQuery()+"%",pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", operation);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/addOperation") // 添加商品
    public String addOperation(@RequestBody Operation operation){
        int i = oDao.addOperation(operation);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteOperation")//根据主键删除商品 只需提供id
    public String deleteOperation(int id){
        int i = oDao.deleteOperation(id);
        return i>0?"success":"error";
    }
    @RequestMapping("/getGoodsUpdate")// 获取需要修改信息的商品信息
    public String getUpdateOperation(int id){
        Operation operation = oDao.getUpdateOperation(id);
        String string = JSON.toJSONString(operation);
        return string;
    }
    @RequestMapping("/editGoods") //修改商品信息
    public String editOperation(@RequestBody Operation operation){
        int i = oDao.editOperation(operation);
        return i>0?"success":"error";
    }
}
