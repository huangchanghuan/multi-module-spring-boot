package com.yimi.product.web;


import com.yimi.product.dto.ServiceResult;
import com.yimi.product.sos.version.ApiVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 
 * @author Peter  2016-9-3下午5:02:48
 *
 */
@Controller
@ApiVersion(001)
@RequestMapping("/{version}/user")//url:/项目/模块/资源/{id}/细分  seckill/list
public class UserControllerV001 {
	/**
	 * 添加成功,返回用户对象
	 * @return
	 */
	@RequestMapping(value="/add" ,method=RequestMethod.GET)
	@ResponseBody
	public ServiceResult<Long> time(){
		System.out.println("版本:001");
		Date now=new Date();
		return new ServiceResult<Long>(true,now.getTime());
	}
}
