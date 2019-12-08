package com.wqg.system.service.admin.service.impl;

import com.wqg.system.service.admin.entity.TbPermission;
import com.wqg.system.service.admin.mapper.TbPermissionMapper;
import com.wqg.system.service.admin.service.TbPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {
    @Autowired
    TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> getPermissionByUsername(String username) {
        return tbPermissionMapper.selectPermissionByUsername(username);
    }

    //获取用户权限英文名字符串列表
    @Override
    public List<String> getPermission(String username) {
        List<String> list = new ArrayList<>();
        List<TbPermission> TbPermissions = getPermissionByUsername(username);
        for(TbPermission e : TbPermissions){
            list.add(e.getEnname());
        }
        return list;
    }

}
