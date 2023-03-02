package com.gxu.bsdn.config;

import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.utils.TokenUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("request请求地址path[{}] uri[{}]", request.getServletPath(),request.getRequestURI());
        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (token!=null){
            boolean result= TokenUtils.verify(token);
            if (result){
                logger.info("通过拦截器");
                return true;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json=new JSONObject();
            json.put("message", ResultEnum.VALIDATION_FAILURE.getResult());
            json.put("code","400");
            response.getWriter().append(json.toString());
            logger.info("认证失败，未通过拦截器");
        } catch (Exception e) {
            return false;
        }
        /**
         * 还可以在此处检验用户存不存在等操作
         */
        return false;
    }
}
