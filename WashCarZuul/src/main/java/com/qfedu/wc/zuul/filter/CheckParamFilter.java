package com.qfedu.wc.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.qfedu.wc.common.vo.R;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author: Stream
 * @date: 2019/11/09 08:08
 * @version: 1.0
 * @description: 参数过滤
 */
@Component
public class CheckParamFilter extends ZuulFilter {
    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        // pre 预处理
        return "pre";
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        // 过滤器排序，值越小，优先级越高
        return 1;
    }

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() throws ZuulException {
        // 获取请求上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext ();
        // 获取请求对象
        HttpServletRequest request = requestContext.getRequest ();
        // 获取请求的所有参数信息
        Map<String, String[]> map = request.getParameterMap ();
        // 获取请求路径
        String uri = request.getRequestURI ();
        System.out.println ("当前请求的是：" + uri);

        if (uri.endsWith (".do")) {
            //Redis--Hash---存储所有映射方法对应的参数信息--字段记录：请求地址名称 值：数组(参数名称)
            if (map.containsKey ("version")) {
                // 说明参数合法
                System.out.println ("版本号：" + Arrays.toString (map.get ("version")));
            } else {
                //非法拦截直接返回结果 是否放行：true 放行 false:拦截
                requestContext.setSendZuulResponse (false);
                requestContext.setResponseStatusCode (HttpStatus.BAD_REQUEST.value ());
                HttpServletResponse response = requestContext.getResponse ();
                response.setContentType ("application/json;charset=UTF-8");
                response.setCharacterEncoding ("UTF-8");
                try {
                    response.getWriter ().println (JSON.toJSONString (R.fail ("请求异常，请合理合法请求")));
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
        return null;
    }

}
