package com.wqg.system.service.admin.service;

import com.wqg.system.service.admin.entity.TbPermission;

import java.util.List;

/*权限业务层接口*/
public interface TbPermissionService {
    /**
     * 查找用户权限
     * @param username 用户名
     * @return List<TbPermission>
     * */
    public List<TbPermission> getPermissionByUsername(String username);

    /**
     * 将用户权限对象中的权限名提取出
     * @param username 用户名
     * @return List<String>
     * */
    public List<String> getPermission(String username);
}
