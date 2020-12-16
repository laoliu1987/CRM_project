package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Daka;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DakaDao {
    public List<Daka> getAllDaka(@Param("pageStart") int PageStart,
                                 @Param("pageSize") int pageSize);
    public int getDakaCounts();
    public int addDaka(Daka daka);
    public int deleteDaka(Integer id);
    public Daka getUpdateDaka(Integer id);
    public int editDaka(Daka daka);
}
