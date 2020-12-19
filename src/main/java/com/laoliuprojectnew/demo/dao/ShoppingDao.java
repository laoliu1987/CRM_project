package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Operation;
import com.laoliuprojectnew.demo.bean.Shopping;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingDao {
    public List<Shopping> getAllShoppingWithName(@Param("name") String name,
                                                  @Param("pageStart") int PageStart,
                                                  @Param("pageSize") int pageSize);
    public int getShoppingCountsWithName(@Param("name") String name);
    public int addShopping(Shopping shopping);
    public int deleteShopping(Integer id);
    public Shopping getUpdateShopping(Integer id);
    public int editShopping(Shopping shopping);
}