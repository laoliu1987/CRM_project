package com.laoliuprojectnew.demo.dao;

import com.laoliuprojectnew.demo.bean.Calender;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalenderDao {
    public List<Calender> getAllCalender();
    public int addCalender(Calender calender);
    public int deleteCalender(String date);
    public Calender getUpdateCalender(String date);
    public int editCalender(Calender calender);
}

