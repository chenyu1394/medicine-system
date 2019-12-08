package com.wqg.system.service.admin.mapper;
/*药品服务数据访问层接口*/

import com.wqg.system.service.admin.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MedicineMapper {

    /**
     * 添加药品
     * @param medicine 药品对象
     * @return int
     * */
    public int insertMedicine(Medicine medicine);

    /**
     * 删除药品信息
     * @param mno 药品编号
     * @return int
     * */
    public int deleteMedicineByMno(String mno);

    /**
     * 修改药品信息
     * @param medicine 药品对象
     * @return int
     * */
    public int updateMedicine(Medicine medicine);

    /**
     * 根据药品编号查询品信息
     * @param mno 药品编号
     * @return Medicine
     * */
    public Medicine selectMedicineByMno(String mno);

    /**
     * 分页查询,每页10条记录
     * @param position 起始位置
     * @return List<Medicine>
     * */
    public List<Medicine> selectMedicineByPage(int position);

    /**
     * 根据顾客编号查询药品信息
     * @param cno 顾客编号
     * @return List<Medicine>
     * */
    public List<Medicine> selectMedicineByCno(String cno);

    /**
     * 查询全部药品信息
     * @return List<Medicine>
     * */
    public List<Medicine> selectAllMedicine();

    /**
     * 返回药品信息总条数
     * @return int
     * */
    public int selectCount();

    /**
     * 根据药品名称查询药品信息
     * @param mname 药品名
     * @return List<Medicine>
     * */
    public List<Medicine> selectMedicineByMname(String mname);
}
