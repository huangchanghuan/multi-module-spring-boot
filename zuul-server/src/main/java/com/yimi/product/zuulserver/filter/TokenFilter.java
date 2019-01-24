package com.yimi.product.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求必须带有token
 */
public class TokenFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
//    @Autowired
//    private KafkaSender<KafkaMessage> kafkaSender;
    @Override
    public String filterType() {
        return "pre"; // 可以在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("--->>> TokenFilter {},{},{}", request.getMethod(), request.getRequestURL().toString(),request.getRemoteHost());
        logger.info("发送消息到kafka");
//        try {
//            kafkaSender.send(new KafkaMessage());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        request.getUserPrincipal();

        String token = request.getParameter("token");// 获取请求的参数

//        if (StringUtils.isNotBlank(token)) {
//            ctx.setSendZuulResponse(true); //对请求进行路由
//            ctx.setResponseStatusCode(200);
//            ctx.set("isSuccess", true);
//            return null;
//        } else {
//            ctx.setSendZuulResponse(false); //不对其进行路由
//            ctx.setResponseStatusCode(400);
//            ctx.setResponseBody("token is empty");
//            ctx.set("isSuccess", false);
//            return null;
//        }
        return null;
    }

}