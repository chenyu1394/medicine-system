package com.wqg.system.service.admin.mapper;

import com.wqg.system.service.admin.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* 用户数据访问层
* */
@Component
@Mapper
public interface TbUserMapper {
    /**
    * 查询用户密码
    * @param username 用户名
    * @return TbUser
    * */
    public TbUser selectUserByUsername(String username);
}
