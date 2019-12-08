package com.wqg.system.service.admin.controller;
/*药品服务控制层接口*/

import com.wqg.system.service.admin.commons.permission.annotation.UserPermission;
import com.wqg.system.service.admin.entity.Medicine;
import com.wqg.system.service.admin.service.MedicineService;
import com.wqg.system.service.admin.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    /**
     * 添加一条药品信息，需要“添加药品”权限
     * @return Map<String,Object>
     * */
    @UserPermission(value = "InsertMedicine")
    @RequestMapping(value = "/addMedicine",method = RequestMethod.POST)
    public Map<String,Object> addMedicine(String mno,String mname,String mmode,String mefficacy,String cno){
        if("".equals(cno) || cno == null){
            cno = "暂无";
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","编号重复");
        Medicine medicine = new Medicine();
        medicine.setMno(mno);
        medicine.setMname(mname);
        medicine.setMmode(mmode);
        medicine.setMefficacy(mefficacy);
        medicine.setCno(cno);
        if(medicineService.addMedicine(medicine) != 0){
            map.put("code",200);
            map.put("msg","添加成功");
            map.put("medicine",medicine);
        }
        return map;
    }

    /**
     * 根据药品编号删除一条药瓶记录，需要“删除药品”权限
     * @param mno 药品编号
     * @return Map<String,Object>
     * */
    @UserPermission(value = "DeleteMedicine")
    @RequestMapping(value = "/removeMedicineByMno/{mno}",method = RequestMethod.GET)
    public Map<String,Object> removeMedicineByMno(@PathVariable("mno")String mno){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","编号不存在");
        if(medicineService.removeMedicineByMno(mno) != 0){
            map.put("code",200);
            map.put("msg","删除成功");
        }
        return map;
    }

    /**
     * 修改一条药品记录,需要“修改药品”权限
     * @return Map<String,Object>
     * */
    @UserPermission(value = "UpdateMedicine")
    @RequestMapping(value = "/setMedicine",method = RequestMethod.POST)
    public Map<String,Object> setMedicine(String mno,String mname,String mmode,String mefficacy,String cno){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","编号不存在");
        Medicine medicine = new Medicine();
        medicine.setMno(mno);
        medicine.setMname(mname);
        medicine.setMmode(mmode);
        medicine.setMefficacy(mefficacy);
        medicine.setCno(cno);
        if(medicineService.setMedicine(medicine) != 0){
            map.put("code",200);
            map.put("msg","修改成功");
            map.put("medicine",medicine);
        }
        return map;
    }

    /**
     * 根据药品编号查询一条记录，需要“查看药品”权限
     * @param mno 药品编号
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectMedicine")
    @RequestMapping(value = "/getMedicineByMno/{mno}",method = RequestMethod.GET)
    public Map<String,Object> getMedicineByMno(@PathVariable("mno")String mno){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","编号不存在");
        Medicine medicine;
        if((medicine = medicineService.getMedicineByMno(mno)) != null){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("medicine",medicine);
        }
        return map;
    }

    /**
     * 根据页码分页查询，需要“查看药品”权限
     * @param page 页码
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectMedicine")
    @RequestMapping(value = "/getMedicineByPage/{page}",method = RequestMethod.GET)
    public Map<String,Object> getMedicineByPage(@PathVariable("page")int page){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","页码不存在");
        List<Medicine> medicines;
        if(!(medicines = medicineService.getMedicineByPage(page)).isEmpty()){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("medicines",medicines);
        }
        return map;
    }

    /**
     * 根据顾客编号查询药品信息,需要“查看药品”权限
     * @param cno 顾客编号
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectMedicine")
    @RequestMapping(value = "/getMedicineByCno/{cno}",method = RequestMethod.GET)
    public Map<String,Object> getMedicineByCno(@PathVariable("cno")String cno){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","页码");
        List<Medicine> medicines;
        if(!(medicines = medicineService.getMedicineByCno(cno)).isEmpty()){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("medicines",medicines);
        }
        return map;
    }

    /**
     * 导出全部顾客信息生成excel文件,
     * */
    @RequestMapping(value = "/exportMedicine",method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Medicine> medicines = medicineService.getAllMedicine();

        //excel标题
        String[] title = {"药品编号", "名称", "服用方法","功效","时间","顾客"};

        //excel文件名
        String fileName = "药品信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "药品信息表";

        String [][] content = new String[medicines.size()][6];

        for (int i = 0; i < medicines.size(); i++) {
            content[i] = new String[title.length];
            Medicine obj = medicines.get(i);
            content[i][0] = obj.getMno();
            content[i][1] = obj.getMname();
            content[i][2] = obj.getMmode();
            content[i][4] = obj.getMefficacy();
            content[i][5] = obj.getCreated().toString();

        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            ExcelUtils.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 返回总页数,需要“查看药品”权限
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectMedicine")
    @RequestMapping(value = "/getMedicinePageNumber",method = RequestMethod.GET)
    public Map<String,Object> getAgencyPageNumber(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","未知错误");
        int pageNumber;
        if((pageNumber = medicineService.getAllPage()) != 0){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("pageNumber",pageNumber);
        }
        return map;
    }

    /**
     * 根据药瓶名称名查询药品信息,需要“查看药品”权限
     * @return Map<String,Object>
     * @param mname 药品名
     * */
    @UserPermission(value = "SelectMedicine")
    @RequestMapping(value = "/getMedicineByMname/{mname}",method = RequestMethod.GET)
    public Map<String,Object> getMedicineByMname(@PathVariable("mname")String mname){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","顾客不存在");
        List<Medicine> medicines;
        if(!((medicines =  medicineService.getMedicineByMname(mname)).isEmpty())){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("medicines",medicines);
        }
        return map;
    }
}
