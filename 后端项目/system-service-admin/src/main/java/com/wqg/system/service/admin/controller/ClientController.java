package com.wqg.system.service.admin.controller;

import com.wqg.system.service.admin.commons.permission.annotation.UserPermission;
import com.wqg.system.service.admin.entity.Client;
import com.wqg.system.service.admin.service.ClientService;
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

/*顾客服务控制层接口*/
@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    /**
     * 新增顾客，需要“添加顾客权限”
     * @param
     * @return Map<String,Object>
     * */
    @UserPermission(value = "InsertClient")
    @RequestMapping(value = "/addClient",method = RequestMethod.POST)
    public Map<String,Object> addClient(String cno,String cname,String csex,String cage,String caddress
    ,String cphone,String csymptom,String ano,String cremark){
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","添加失败，编号重复");
        Client client = new Client();
        client.setCno(cno);
        client.setCname(cname);
        client.setCsex(csex);
        client.setCage(cage);
        client.setCaddress(caddress);
        client.setCphone(cphone);
        client.setCsymptom(csymptom);
        client.setAno(ano);
        client.setCremark(cremark);
        if(clientService.addClient(client) != 0){
            map.put("code",200);
            map.put("msg","添加成功");
            map.put("client",client);
        }
        return map;
    }

    /**
     * 根据编号删除顾客信息,需要“删除顾客”权限
     * @param cno 顾客编号
     * @return Map<String,Object>
     * */
    @UserPermission(value = "DeleteClient")
    @RequestMapping(value = "/removeClientByCno/{cno}",method = RequestMethod.GET)
    public Map<String,Object> removeClientByCno(@PathVariable("cno")String cno){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","删除失败，该客户不存在");
        if(clientService.removeClientByCno(cno) != 0){
            map.put("code",200);
            map.put("msg","删除成功");
        }
        return map;
    }

    /**
     * 修改顾客信息,需要“修改顾客”权限
     * @param
     * @return Map<String,Object>
     * */
    @UserPermission(value = "UpdateClient")
    @RequestMapping(value = "/setClient",method = RequestMethod.POST)
    public Map<String,Object> setClient(String cno,String cname,String csex,String cage,String caddress,
                                        String cphone,String csymptom,String ano,String cremark){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","修改失败,该顾客不存在");
        Client client = new Client();
        client.setCno(cno);
        client.setCname(cname);
        client.setCsex(csex);
        client.setCage(cage);
        client.setCaddress(caddress);
        client.setCphone(cphone);
        client.setCsymptom(csymptom);
        client.setAno(ano);
        client.setCremark(cremark);
        if(clientService.setClient(client) != 0){
            map.put("code",200);
            map.put("msg","修改成功");
            map.put("client",client);
        }
        return map;
    }

    /**
     * 根据顾客编号查询顾客信息，需要“查看顾客”权限
     * @param cno 顾客编号
     * @return  Map<String,Object>
     * */
    @UserPermission(value = "SelectClient")
    @RequestMapping(value = "/getClientByCno/{cno}",method = RequestMethod.GET)
    public Map<String,Object> getClientByCno(@PathVariable("cno")String cno){
        Client client;
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","顾客不存在");
        if((client = clientService.getClientByCno(cno)) != null){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("client",client);
        }
        return map;
    }

    /**
     * 分页查询顾客信息，需要“查看顾客”权限
     * @param page 页码
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectClient")
    @RequestMapping(value = "/getClientByPage/{page}",method = RequestMethod.GET)
    public Map<String,Object> getClientByPage(@PathVariable("page")int page){
        List<Client> clients;
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","页码不存在");
        if(!((clients =  clientService.getClientByPage(page)).isEmpty())){
            System.out.println();
            //当文章列表不为空时，查询成功
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("clients",clients);
        }
        return map;
    }
    /**
     * 根据经办人编号查询顾客信息，需要“查看顾客”权限
     * @param ano 经办人编号
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectClient")
    @RequestMapping(value = "/getClientByAno/{ano}",method = RequestMethod.GET)
    public Map<String,Object> getClientByAno(@PathVariable("ano")String ano){
        List<Client> clients;
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","不存在");
        if(!((clients =  clientService.getClientByAno(ano)).isEmpty())){
            //当文章列表不为空时，查询成功
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("clients",clients);
        }
        return map;
    }
    /**
     * 导出全部顾客信息生成excel文件
     *
     * */
    @RequestMapping(value = "/exportClient",method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Client> clients = clientService.getAllClient();

        //excel标题
        String[] title = {"顾客编号", "姓名", "性别", "地址","电话","症状","经办人","时间","备注"};

        //excel文件名
        String fileName = "顾客信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "顾客信息表";

        String [][] content = new String[clients.size()][9];

        for (int i = 0; i < clients.size(); i++) {
            content[i] = new String[title.length];
            Client obj = clients.get(i);
            content[i][0] = obj.getCno();
            content[i][1] = obj.getCname();
            content[i][2] = obj.getCsex();
            content[i][3] = obj.getCaddress();
            content[i][4] = obj.getCphone();
            content[i][5] = obj.getCsymptom();
            content[i][6] = obj.getAno();
            content[i][7] = obj.getCdate().toString();
            content[i][8] = obj.getCremark();
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
     * 返回总页数,需要“查看顾客”权限
     * @return Map<String,Object>
     * */
    @UserPermission(value = "SelectClient")
    @RequestMapping(value = "/getClientPageNumber",method = RequestMethod.GET)
    public Map<String,Object> getClientPageNumber(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","未知错误");
        int pageNumber;
        if((pageNumber = clientService.getAllPage()) != 0){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("pageNumber",pageNumber);
        }
        return map;
    }

    /**
     * 根据顾客姓名查询顾客信息,需要“查看顾客”权限
     * @return Map<String,Object>
     * @param cname 顾客名
     * */
    @UserPermission(value = "SelectClient")
    @RequestMapping(value = "/getClientByCname/{cname}",method = RequestMethod.GET)
    public Map<String,Object> getClientByCname(@PathVariable("cname")String cname){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",400);
        map.put("msg","顾客不存在");
        List<Client> clients;
        if(!((clients =  clientService.getClientByCname(cname)).isEmpty())){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("clients",clients);
        }
        return map;
    }
}
