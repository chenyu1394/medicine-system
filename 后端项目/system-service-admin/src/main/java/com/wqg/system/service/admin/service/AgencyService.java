package com.wqg.system.service.admin.service;

import com.wqg.system.service.admin.entity.Agency;

import java.util.List;

/*经办人服务业务层接口*/
public interface AgencyService {
    /**
     * 添加经办人
     * @param agency 经办人对象
     * @return int
     * */
    public int addAgency(Agency agency);

    /**
     * 删除一条经办人信息
     * @param ano 经办人编号
     * @return int
     * */
    public int removeAgencyByAno(String ano);

    /**
     * 修改经办人信息
     * @param agency 经办人对象
     * @return  int
     * */
    public int setAgency(Agency agency);

    /**
     * 根据经办人编号查询经办人信息
     * @param ano 经办人编号
     * @return Agency
     * */
    public Agency getAgencyByAno(String ano);

    /**
     * 分页查询经办人信息，每页10条
     * @param page 页码
     * @return List<Agency>
     * */
    public List<Agency> getAgencyByPage(int page);

    /**
     * 查询全部经办人信息
     * @return List<Agency>
     * */
    public List<Agency> getAllAgency();

    /**
     * 返回总页数
     * @return  int
     * */
    public int getAllPage();


    /**
     * 根据经办人姓名查询经办人信息
     * @param aname 经办人姓名
     * @return  List<Agency>
     * */
    public List<Agency> getAgencyByAname(String aname);
}
