package com.wqg.system.service.admin.mapper;
/*顾客服务数据访问层接口*/

import com.wqg.system.service.admin.entity.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ClientMapper {

    /**
     * 添加顾客信息
     * @param client 顾客对象
     * @return int
     * */
    public int insertClient(Client client);


    /**
     * 根据顾客编号删除顾客信息
     * @param cno 顾客编号
     * @return int
     * */
    public int deleteClientByCno(String cno);

    /**
     * 修改顾客信息
     * @param client 顾客对象
     * @return int
     * */
    public int updateClient(Client client);

    /**
     * 根据顾客编号查询顾客信息
     * @param cno 顾客编号
     * @return  Client
     * */
    public Client selectClientByCno(String cno);

    /**
     * 分页查询顾客信息,每页10条
     * @param position 起始位置
     * @return List<Client>
     * */
    public List<Client> selectClientByPage(int position);

    /**
     * 查询全部数据
     * @return List<Client>
     * */
    public List<Client> selectAllClient();

    /**
     * 根据经办人编号查询顾客信息
     * @param ano 经办人编号
     * @return List<Client>
     * */
    public List<Client> selectClientByAno(String ano);

    /**
     * 返回顾客信息总条数
     * @return int
     * */
    public int selectCount();

    /**
     * 根据顾客姓名查询顾客信息
     * @param cname 顾客姓名
     * @return List<Client>
     * */
    public List<Client> selectClientByCname(String cname);
}
