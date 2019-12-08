package com.wqg.system.service.admin.service;

import com.wqg.system.service.admin.entity.Medicine;

import java.util.List;

/*药品服务业务层接口*/
public interface MedicineService {

    /**
     * 添加药品
     * @param medicine 药品对象
     * @return int
     * */
    public int addMedicine(Medicine medicine);

    /**
     * 删除药品信息
     * @param mno 药品编号
     * @return int
     * */
    public int removeMedicineByMno(String mno);

    /**
     * 修改药品信息
     * @param medicine 药品对象
     * @return int
     * */
    public int setMedicine(Medicine medicine);

    /**
     * 根据药品编号查询品信息
     * @param mno 药品编号
     * @return Medicine
     * */
    public Medicine getMedicineByMno(String mno);

    /**
     * 分页查询,每页10条记录
     * @param page 页码
     * @return List<Medicine>
     * */
    public List<Medicine> getMedicineByPage(int page);

    /**
     * 根据顾客编号查询药品信息
     * @param cno 顾客编号
     * @return List<Medicine>
     * */
    public List<Medicine> getMedicineByCno(String cno);

    /**
     * 查询全部药品信息
     * @return List<Medicine>
     * */
    public List<Medicine> getAllMedicine();

    /**
     * 返回总页数
     * @return  int
     * */
    public int getAllPage();

    /**
     * 根据药品名称查询药品信息
     * @param mname 药品名
     * @return List<Medicine>
     * */
    public List<Medicine> getMedicineByMname(String mname);

}
