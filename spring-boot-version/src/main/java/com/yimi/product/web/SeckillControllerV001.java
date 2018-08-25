package com.yimi.product.web;


import com.yimi.product.dto.SeckillResult;
import com.yimi.product.sos.version.ApiVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Peter  2016-9-3下午5:02:48
 */
@Controller
@ApiVersion(001)
@RequestMapping("/{version}/seckill")//url:/项目/模块/资源/{id}/细分  seckill/list
public class SeckillControllerV001 {

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time() {
        System.out.println("版本:001");
        Date now = new Date();
        return new SeckillResult<Long>(true, now.getTime());
    }
}
