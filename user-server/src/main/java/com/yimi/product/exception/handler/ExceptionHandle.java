package com.yimi.product.exception.handler;

import com.yimi.product.dto.ServiceResult;
import com.yimi.product.enums.ExceptionEnum;
import com.yimi.product.exception.DescribeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.UnexpectedTypeException;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Object exceptionGet(Exception e, HttpServletRequest request, HttpServletResponse response) {
        //自定义的异常类
        DescribeException MyException = null;
        //返回前端的数据格式
        ServiceResult<?> result = null;
        //判断异常是否属于已定义
        if (e instanceof DescribeException) {
            MyException = (DescribeException) e;
            result =  new ServiceResult<String>(true, MyException.getMessage(),MyException.getCode().toString());
        }
        //其它再拦截器以及其它无法直接抛出异常的地方抛出的异常只能自己判断，类似与shiro的权限不足异常
        else if (e instanceof UnexpectedTypeException) {

        }
        //上传文件过大异常
//        else if (e instanceof UnauthorizedException) {
//            result =  ResultUtil.error(ExceptionEnum.UnauthorizedException);
//        }
        //不属于以上所有异常，按未定义异常处理
        else {
//            result = ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
            result =  new ServiceResult<String>(true, ExceptionEnum.UNKNOW_ERROR.getMsg(),ExceptionEnum.UNKNOW_ERROR.getCode().toString());

        }
        //判断是否为ajax请求，是则返回json格式数据，不是则返回ModelAndView对象
        if (true)return result;
        if(isAjax(request)) {
            return result;
        }
        else {
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("error",result.getError());
            return mav;
        }
    }

    //判断是否为ajax请求
    boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

}
