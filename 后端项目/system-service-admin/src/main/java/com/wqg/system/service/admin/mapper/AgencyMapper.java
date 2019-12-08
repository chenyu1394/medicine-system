package com.wqg.system.service.admin.mapper;

import com.wqg.system.service.admin.entity.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/*经办人服务数据访问层*/
@Component
@Mapper
public interface AgencyMapper {

    /**
     * 添加经办人
     * @param agency 经办人对象
     * @return int
     * */
    public int insertAgency(Agency agency);

    /**
     * 删除一条经办人信息
     * @param ano 经办人编号
     * @return int
     * */
    public int deleteAgencyByAno(String ano);

    /**
     * 修改经办人信息
     * @param agency 经办人对象
     * @return  int
     * */
    public int updateAgency(Agency agency);

    /**
     * 根据经办人编号查询经办人信息
     * @param ano 经办人编号
     * @return Agency
     * */
    public Agency selectAgencyByAno(String ano);

    /**
     * 分页查询经办人信息，每页10条
     * @param position 起始位置
     * @return List<Agency>
     * */
    public List<Agency> selectAgencyByPage(int position);

    /**
     * 查询全部经办人信息
     * @return List<Agency>
     * */
    public List<Agency> selectAllAgency();


    /**
     * 返回经办人信息总条数
     * @return int
     * */
    public int selectCount();

    /**
     * 根据经办人姓名查询经办人信息
     * @param aname 经办人姓名
     * @return  List<Agency>
     * */
    public List<Agency> selectAgencyByAname(String aname);
}
