package com.wqg.system.service.admin.service.impl;
/*用户业务接口实现类*/

import com.wqg.system.service.admin.entity.TbUser;
import com.wqg.system.service.admin.mapper.TbUserMapper;
import com.wqg.system.service.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public TbUser getUserByUsername(String username) {
        return tbUserMapper.selectUserByUsername(username);
    }
}
