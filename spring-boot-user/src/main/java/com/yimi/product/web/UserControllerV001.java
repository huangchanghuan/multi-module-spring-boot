package com.yimi.product.web;


import com.yimi.product.dto.ServiceResult;
import com.yimi.product.entity.SysUser;
import com.yimi.product.service.UserService;
import com.yimi.product.sos.version.ApiVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Peter  2016-9-3下午5:02:48
 *
 */
@Controller
@ApiVersion(001)
@RequestMapping("/{version}/user")//url:/项目/模块/资源/{id}/细分  seckill/list
public class UserControllerV001 {
	private final static Logger logger = LoggerFactory.getLogger(UserControllerV001.class);

	@Autowired
	private UserService userService;

	/**
	 * 添加成功,返回用户对象
	 * @return
	 */
	@RequestMapping(value="/add" ,method=RequestMethod.GET)
	@ResponseBody
	public ServiceResult<SysUser> time(){
		logger.info("执行用户添加");
		SysUser sysUser=userService.getUser(1l);
		return new ServiceResult<SysUser>(true,sysUser);
	}

	/**
	 * 添加成功,返回用户对象
	 * @return
	 */
	@RequestMapping(value="/updateState" ,method=RequestMethod.GET)
	@ResponseBody
	public ServiceResult<Long> updateState(){
		logger.info("执行用户添加");
		SysUser sysUser = new SysUser();
		sysUser.setUid(1);
		long result= 0;
		try {
			result = userService.updateState(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ServiceResult<Long>(true,result);
	}
	/**
	 * 添加成功,返回用户对象
	 * @return
	 */
	@RequestMapping(value="/updateState1" ,method=RequestMethod.GET)
	@ResponseBody
	public ServiceResult<Long> updateState1(){
		logger.info("执行用户添加");
		SysUser sysUser = new SysUser();
		sysUser.setUid(2);
		long result=userService.updateState1(sysUser);
		return new ServiceResult<Long>(true,result);
	}
}