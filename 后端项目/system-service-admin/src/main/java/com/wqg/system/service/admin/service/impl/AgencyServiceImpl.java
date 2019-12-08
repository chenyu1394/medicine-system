package com.wqg.system.service.admin.service.impl;
/*经办人服务业务层接口实现类*/
import com.wqg.system.service.admin.entity.Agency;
import com.wqg.system.service.admin.mapper.AgencyMapper;
import com.wqg.system.service.admin.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    AgencyMapper agencyMapper;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int addAgency(Agency agency) {
        int flag = 0;
        if(agencyMapper.selectAgencyByAno(agency.getAno()) == null){
                flag = agencyMapper.insertAgency(agency);
        }
        return flag;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int removeAgencyByAno(String ano) {
        return agencyMapper.deleteAgencyByAno(ano);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int setAgency(Agency agency) {
        return agencyMapper.updateAgency(agency);
    }

    @Override
    public Agency getAgencyByAno(String ano) {
        return agencyMapper.selectAgencyByAno(ano);
    }

    @Override
    public List<Agency> getAgencyByPage(int page) {
        int position = 10*(page-1);
        return agencyMapper.selectAgencyByPage(position);
    }

    @Override
    public List<Agency> getAllAgency() {
        return agencyMapper.selectAllAgency();
    }

    @Override
    public int getAllPage() {
        int page = 1;
        int count;
        if((count = agencyMapper.selectCount()) != 0){
            page = count/10 + 1;
        }
        return page;
    }

    @Override
    public List<Agency> getAgencyByAname(String aname) {
        return agencyMapper.selectAgencyByAname(aname);
    }
}
