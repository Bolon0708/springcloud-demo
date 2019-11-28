package com.liang.com.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: LoginFilter
 * @Author: Bolon
 * @Date: 2019/11/26 19:20
 * @Description: TODO
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 功能描述: 过滤器类型：pre route post error
     * @return: java.lang.String
     * @author: Bolon
     * @date: 2019/11/26 19:21
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 功能描述: 执行顺序，返回值越小，优先级越高
     * @return:
     * @author: Bolon
     * @date: 2019/11/26 19:23
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 功能描述: 是否执行run方法
     * true：执行run方法
     * @return:
     * @author: Bolon
     * @date: 2019/11/26 19:24
     */
    @Override
    public boolean shouldFilter() {
        // return true;
        return false;
    }

    /**
     * 功能描述: 编写过滤器业务逻辑
     * @return:
     * @author: Bolon
     * @date: 2019/11/26 19:25
     */
    @Override
    public Object run() throws ZuulException {
        // 初始化context上下文对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获取request对象
        HttpServletRequest request = currentContext.getRequest();
        // 获取参数
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            // 拦截，不转发请求
            currentContext.setSendZuulResponse(false);
            // 设置响应状态码，401-身份未认证
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            // 设置返回提示
            currentContext.setResponseBody("request error!");
        }
        // 返回值为null，表示过滤器声明都不做，不拦截
        return null;
    }
}
