package com.wqg.system.service.admin.mapper;
/*权限数据访问层接口*/

import com.wqg.system.service.admin.entity.TbPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TbPermissionMapper {
    /**
     * 查看用户的所有权限
     * @param username
     * @return List<TbPermission>
     * */
    public List<TbPermission> selectPermissionByUsername(String username);
}
