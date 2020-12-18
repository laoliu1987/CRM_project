package com.laoliuprojectnew.demo.controller;

import com.laoliuprojectnew.demo.bean.Admin;
import com.laoliuprojectnew.demo.dao.AdminDao;
import com.laoliuprojectnew.demo.model.AccessToken;
import com.laoliuprojectnew.demo.model.Audience;
import com.laoliuprojectnew.demo.model.ReturnModel;
import com.laoliuprojectnew.demo.util.CreateTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PersonController {
    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private AdminDao aDao;
    @Autowired
    private Audience audience;
    /**
     * @content:根据id对应的person
     * @param id=1;
     * @return returnModel
     */
    @RequestMapping(value = "/loginByToken",method = RequestMethod.POST)
    public ReturnModel exsit(@RequestBody Admin admin){
        Admin ad = aDao.getAdminByMessage(admin.getUsername(), admin.getPassword());
        if(ad==null){
            return new ReturnModel(-1,null);
        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("admin",admin);
            String accessToken = CreateTokenUtils
                    .createJWT(admin.getUsername(),audience.getClientId(), audience.getName(),audience.getExpiresSecond() * 1000, audience.getBase64Secret());
            AccessToken accessTokenEntity = new AccessToken();
            accessTokenEntity.setAccess_token(accessToken);
            accessTokenEntity.setExpires_in(audience.getExpiresSecond());
            accessTokenEntity.setToken_type("bearer");
            map.put("accessToken",accessTokenEntity);
            return new ReturnModel(0,map);
        }
    }
}