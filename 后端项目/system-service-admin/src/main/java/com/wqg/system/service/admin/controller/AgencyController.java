package com.wqg.system.service.admin.controller;
/*经办人服务控制层接口*/

import com.wqg.system.service.admin.commons.permission.annotation.UserPermission;
import com.wqg.system.service.admin.entity.Agency;
import com.wqg.system.service.admin.service.AgencyService;
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
public class AgencyController {
    @Autowired
    AgencyService agencyService;

    /**
     * 增加经办人，需要“添加经办人权限”
     * @return Map<String,Object>
     * */
    @UserPermission(value = "InsertAgency")
    @RequestMapping(value = "/addAgency",method = RequestMethod.POST)
    public Map<String,Object> addAgency(String ano,String aname,String asex,String aphone,String aremark){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","添加失败，编号重复");
        Agency agency = new Agency();
        agency.setAno(ano);
        agency.setAname(aname);
        agency.setAsex(asex);
        agency.setAphone(aphone);
        agency.setAremark(aremark);
        if(agencyService.addAgency(agency) != 0){
            map.put("code",200);
            map.put("msg","添加成功");
            map.put("agency",agency);
        }
        return map;
    }

    /**
     * 根据经办人编号删除一条经办人信息,需要“删除经办人”权限
     * @param ano 经办人编号
     * @return  Map<String,Object>
     * */
    @UserPermission(value = "DeleteAgency")
    @RequestMapping(value = "/removeAgencyByAno/{ano}",method = RequestMethod.GET)
    public Map<String,Object> removeAgencyByAno(@PathVariable("ano")String ano){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","删除失败，编号不存在");
        if(agencyService.removeAgencyByAno(ano) != 0){
            map.put("code",200);
            map.put("msg","删除成功");
        }
        return map;
    }
    /**
     * 修改经办人信息，需要“修改经办人”权限
     * @return Map<String,Object>
     * */
    @UserPermission(value = "UpdateAgency")
    @RequestMapping(value = "/setAgency",method = RequestMethod.POST)
    public Map<String,Object> setAgency(String ano,String aname,String asex,String aphone,String aremark){
        Agency agency = new Agency();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","修改失败，编号不存在");
        agency.setAno(ano);
        agency.setAname(aname);
        agency.setAsex(asex);
        agency.setAphone(aphone);
        agency.setAremark(aremark);
        if(agencyService.setAgency(agency) != 0){
            map.put("code",200);
            map.put("msg","修改成功");
            map.put("agency",agency);
        }
        return map;
    }

    /**
     * 根据经办人编号，查询经办人信息。需要“查看经办人”权限
     * @param ano 经办人编号
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectAgency")
    @RequestMapping(value = "/getAgency/{ano}",method = RequestMethod.GET)
    public Map<String,Object> getAgency(@PathVariable("ano")String ano){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","编号不存在");
        Agency agency;
        if((agency = agencyService.getAgencyByAno(ano)) != null){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("agency",agency);
        }
        return map;
    }

    /**
     * 根据页码查询经办人信息，需要“查看经办人”权限
     * @param page 页码
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectAgency")
    @RequestMapping(value = "/getAgencyByPage/{page}",method = RequestMethod.GET)
    public Map<String,Object> getAgencyByPage(@PathVariable("page")int page){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","页码不存在");
        List<Agency> agencies;
        if(!(agencies = agencyService.getAgencyByPage(page)).isEmpty()){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("agencies",agencies);
        }
        return map;
    }

    /**
     * 导出全部顾客信息生成excel文件
     * */
    @RequestMapping(value = "/exportAgency",method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Agency> agencies = agencyService.getAllAgency();

        //excel标题
        String[] title = {"经办人编号", "姓名", "性别","电话","备注","时间"};

        //excel文件名
        String fileName = "经办人信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "经办人信息表";

        String [][] content = new String[agencies.size()][6];

        for (int i = 0; i < agencies.size(); i++) {
            content[i] = new String[title.length];
            Agency obj = agencies.get(i);
            content[i][0] = obj.getAno();
            content[i][1] = obj.getAname();
            content[i][2] = obj.getAphone();
            content[i][4] = obj.getAremark();
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
     * 返回总页数,需要“查看经办人”权限
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectAgency")
    @RequestMapping(value = "/getAgencyPageNumber",method = RequestMethod.GET)
    public Map<String,Object> getAgencyPageNumber(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","未知错误");
        int pageNumber;
        if((pageNumber = agencyService.getAllPage()) != 0){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("pageNumber",pageNumber);
        }
        return map;
    }

    /**
     * 根据经办人姓名查询经办人信息,需要“查看经办人”权限
     * @return Map<String,Object>
     * @param aname 经办人姓名
     * */
    @UserPermission(value = "SelectAgency")
    @RequestMapping(value = "/getAgencyByAname/{aname}",method = RequestMethod.GET)
    public Map<String,Object> getAgencyByAname(@PathVariable("aname")String aname){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","经办人不存在");
        List<Agency> agencies;
        if(!((agencies =  agencyService.getAgencyByAname(aname)).isEmpty())){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("agencies",agencies);
        }
        return map;
    }
}
