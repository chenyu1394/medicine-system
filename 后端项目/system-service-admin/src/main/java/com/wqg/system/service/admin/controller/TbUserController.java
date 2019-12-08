package com.wqg.system.service.admin.controller;

import com.wqg.system.service.admin.entity.TbUser;
import com.wqg.system.service.admin.service.TbPermissionService;
import com.wqg.system.service.admin.service.TbUserService;
import com.wqg.system.service.admin.util.JwtUtil;
import com.wqg.system.service.admin.util.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TbUserController {
    @Autowired
    TbUserService tbUserService;
    @Autowired
    TbPermissionService tbPermissionService;
    /**
    * 登陆验证
    * @param username,password 用户名，密码
     * @return String
    * */
    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public Map<String,Object> checkLogin(String username, String password){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","密码错误或用户名不存在");
        TbUser tbUser;
        if((tbUser = tbUserService.getUserByUsername(username)) !=null){
            if(password.equals(PasswordEncoding.Base64decode(tbUser.getPassword()))){
                //验证成功并返回token
                map.put("code",200);
                map.put("msg","验证成功");
                map.put("token", JwtUtil.encode(username));
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(PasswordEncoding.Base64decode("MTIzNDU2"));
    }
}
