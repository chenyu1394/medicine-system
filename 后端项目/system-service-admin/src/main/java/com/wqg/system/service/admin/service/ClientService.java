package com.wqg.system.service.admin.service;

import com.wqg.system.service.admin.entity.Client;

import java.util.List;

/*顾客服务业务层接口*/
public interface ClientService {

    /**
     * 添加顾客信息
     * @param client 顾客对象
     * @return int
     * */
    public int addClient(Client client);

    /**
     * 根据顾客编号删除顾客信息
     * @param cno 顾客编号
     * @return int
     * */
    public int removeClientByCno(String cno);

    /**
     * 修改顾客信息
     * @param client 顾客对象
     * @return int
     * */
    public int setClient(Client client);

    /**
     * 根据顾客编号查询顾客信息
     * @param cno 顾客编号
     * @return  Client
     * */
    public Client getClientByCno(String cno);

    /**
     * 分页查询顾客信息,每页10条
     * @param page 页码
     * @return List<Client>
     * */
    public List<Client> getClientByPage(int page);

    /**
     * 查询全部数据
     * @return List<Client>
     * */
    public List<Client> getAllClient();

    /**
     * 根据经办人编号查询顾客信息
     * @param ano 经办人编号
     * @return List<Client>
     * */
    public List<Client> getClientByAno(String ano);

    /**
     * 返回总页数
     * @return  int
     * */
    public int getAllPage();

    /**
     * 根据顾客姓名查询顾客信息
     * @param cname 顾客姓名
     * @return List<Client>
     * */
    public List<Client> getClientByCname(String cname);
}
