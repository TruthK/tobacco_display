package edu.ecnu.tobacco_display.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ecnu.tobacco_display.utils.JWTUtils;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.jsonwebtoken.Claims;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到controller之前的方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {


//            // 如果是OPTIONS则结束请求
//            if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//                response.setStatus(HttpStatus.NO_CONTENT.value());
//                response.setHeader("Access-Control-Allow-Origin", "*");
//                response.setHeader("Access-Control-Allow-Credentials", "true");
//                response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
//                response.setHeader("Access-Control-Max-Age", "86400");
//                response.setHeader("Access-Control-Allow-Headers", "*");
//                return false;
//            }

            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }

            if (StringUtils.isNotBlank(accessToken)) {
                Claims claims = JWTUtils.findJWT(accessToken);
                if (claims == null) {
                    //告诉登录过期，重新登录
                    sendJsonMessage(response, JsonData.buildError("登录过期，重新登录"));
                    return false;
                }

                String id = (String) claims.get("id");
                String nname = (String) claims.get("nname");

                request.setAttribute("user_id", id);
                request.setAttribute("nname", nname);

                return true;

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        sendJsonMessage(response, JsonData.buildError("请先登录"));

        return false;
    }


    /**
     * 响应json数据给前端
     *
     * @param response
     * @param obj
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
