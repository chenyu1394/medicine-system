package com.wqg.system.service.admin.service.impl;
/*顾客服务业务访问层接口实现类*/
import com.wqg.system.service.admin.entity.Client;
import com.wqg.system.service.admin.mapper.ClientMapper;
import com.wqg.system.service.admin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientMapper clientMapper;
    //保证事务一致性
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int addClient(Client client) {
        int flag = 0;
        if(clientMapper.selectClientByCno(client.getCno()) == null){
                flag = clientMapper.insertClient(client);
        }
        return flag;
    }
    //保证事务一致性
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int removeClientByCno(String cno) {
        return clientMapper.deleteClientByCno(cno);
    }

    //保证事务一致性
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int setClient(Client client) {
        return clientMapper.updateClient(client);
    }

    @Override
    public Client getClientByCno(String cno) {
        return clientMapper.selectClientByCno(cno);
    }

    @Override
    public List<Client> getClientByPage(int page) {
        int position = 10*(page-1);
        return clientMapper.selectClientByPage(position);
    }

    @Override
    public List<Client> getAllClient() {
        return clientMapper.selectAllClient();
    }

    @Override
    public List<Client> getClientByAno(String ano) {
        return clientMapper.selectClientByAno(ano);
    }

    @Override
    public int getAllPage() {
        int page = 1;
        int count;
        if((count = clientMapper.selectCount()) != 0){
            page = count/10 + 1;
        }
        return page;
    }

    @Override
    public List<Client> getClientByCname(String cname) {
        return clientMapper.selectClientByCname(cname);
    }
}
