package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Goods;
import com.laoliuprojectnew.demo.bean.Operation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationDao {
    public List<Operation> getAllOperationWithName(@Param("name") String name,
                                                   @Param("pageStart") int PageStart,
                                                   @Param("pageSize") int pageSize);
    public int getOperationCountsWithName(@Param("name") String name);
    public int addOperation(Operation operation);
    public int deleteOperation(Integer id);
    public Operation getUpdateOperation(Integer id);
    public int editOperation(Operation operation);
}

