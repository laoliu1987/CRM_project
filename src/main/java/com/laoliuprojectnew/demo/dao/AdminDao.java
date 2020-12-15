package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    public Admin getAdminByMessage(@Param("username") String username, @Param("password") String password);
}
