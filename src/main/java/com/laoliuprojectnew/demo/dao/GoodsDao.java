package com.laoliuprojectnew.demo.dao;


import com.laoliuprojectnew.demo.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    public List<Goods> getAllGoodsWithName(@Param("name") String name,
                                              @Param("pageStart") int PageStart,
                                              @Param("pageSize") int pageSize);
    public int getGoodsCountsWithName(@Param("name") String name);
    public int addGoods(Goods goods);
    public int deleteGoods(Integer id);
    public Goods getUpdateGoods(Integer id);
    public int editGoods(Goods goods);
}
