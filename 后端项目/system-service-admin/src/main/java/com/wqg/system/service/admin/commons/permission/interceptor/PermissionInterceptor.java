package com.wqg.system.service.admin.commons.permission.interceptor;
/*
* 自定义权限拦截器，对需要权限的方法进行拦截
* */

import com.wqg.system.service.admin.commons.permission.annotation.UserPermission;
import com.wqg.system.service.admin.service.TbPermissionService;
import com.wqg.system.service.admin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    TbPermissionService tbPermissionService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            //判断注解是否存在，若存在则执行权限处理
            if(handlerMethod.hasMethodAnnotation(UserPermission.class)){
                String permission = Objects.requireNonNull(handlerMethod.getMethodAnnotation(UserPermission.class)).value();
                //权限判定
                flag = doJudge(permission,request,response);
            }
        }
        return flag;
    }

        private boolean doJudge(String permission, HttpServletRequest request, HttpServletResponse response) throws IOException {
            boolean flag = false;
            String token = "";
            if((token =  request.getParameter("token")) != null ){
                List<String> permissions =  tbPermissionService.getPermission(JwtUtil.decode(token));
                if(permissions.contains(permission)){
                    //当用户拥有目标权限时，返回true
                    flag = true;
                }
            }
            return flag;
        }

}
