package com.wqg.system.service.admin.service.impl;
/*药品服务业务层接口是实现类*/

import com.wqg.system.service.admin.entity.Medicine;
import com.wqg.system.service.admin.mapper.MedicineMapper;
import com.wqg.system.service.admin.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    MedicineMapper medicineMapper;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int addMedicine(Medicine medicine) {
        int flag = 0;
        if(medicineMapper.selectMedicineByMno(medicine.getMno()) == null){
            flag = medicineMapper.insertMedicine(medicine);
        }
        return flag;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int removeMedicineByMno(String mno) {
        return medicineMapper.deleteMedicineByMno(mno);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int setMedicine(Medicine medicine) {
        return medicineMapper.updateMedicine(medicine);
    }


    @Override
    public Medicine getMedicineByMno(String mno) {
        return medicineMapper.selectMedicineByMno(mno);
    }

    @Override
    public List<Medicine> getMedicineByPage(int page) {
        int position = 10*(page-1);
        return medicineMapper.selectMedicineByPage(position);
    }

    @Override
    public List<Medicine> getMedicineByCno(String cno) {
        return medicineMapper.selectMedicineByCno(cno);
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return medicineMapper.selectAllMedicine();
    }

    @Override
    public int getAllPage() {
        int page = 1;
        int count;
        if((count = medicineMapper.selectCount()) != 0){
            page = count/10 + 1;
        }
        return page;
    }

    @Override
    public List<Medicine> getMedicineByMname(String mname) {
        return medicineMapper.selectMedicineByMname(mname);
    }
}
