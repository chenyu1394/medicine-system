package com.wqg.system.service.admin.service;
/*
* 用户业务层接口
*
* */

import com.wqg.system.service.admin.entity.TbUser;


public interface TbUserService {
    /**
    * 得到用户信息，用户名和密码
    * @param  username
    * @return TbUser
    * */
    public TbUser getUserByUsername(String username);
}
