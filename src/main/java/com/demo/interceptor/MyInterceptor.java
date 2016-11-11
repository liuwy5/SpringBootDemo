package com.demo.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by lw on 16-11-10.

 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHand>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        HandlerMethod handlerMethod = (HandlerMethod)o;
//        Method method = handlerMethod.getMethod();
//        Enumeration<String> attributeNames = httpServletRequest.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String str = attributeNames.nextElement();
//            Object obj = httpServletRequest.getAttribute(str);
//            System.out.println(obj.toString());
//        }
        for(MethodParameter methodParameter : handlerMethod.getMethodParameters()){
            System.out.println("======================" + methodParameter.getParameterName() + "  -" + methodParameter.getParameterType());
            Object object = methodParameter.getParameterType().newInstance();
            System.out.println("===" + methodParameter);
        }
        Map<String, String[]> map = httpServletRequest.getParameterMap();

        Set<String> nameList = map.keySet();
        for(String key : nameList){
            for(String value : map.get(key)){
                System.out.println("key: " + key + " value: " + value);
            }
        }
        httpServletRequest.setAttribute("user", "fsdfddfdfd");

        map.put("user",new String[]{"dsfads"});
        System.out.println(map);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
