package com.yimi.product.web;


import com.yimi.product.dto.Result;
import com.yimi.product.dto.ServiceResult;
import com.yimi.product.entity.SysUser;
import com.yimi.product.entity.User;
import com.yimi.product.enums.ExceptionEnum;
import com.yimi.product.exception.DescribeException;
import com.yimi.product.service.UserService;
import com.yimi.product.sos.version.ApiVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author Peter  2016-9-3下午5:02:48
 */
@RestController
@ApiVersion(001)
@RequestMapping("/{version}/user")//url:/项目/模块/资源/{id}/细分  seckill/list
public class UserControllerV001 {
    private final static Logger logger = LoggerFactory.getLogger(UserControllerV001.class);

    @Autowired
    private UserService userService;


    @GetMapping("/user")
//    @PreAuthorize("hasAuthority('userInfo:add')")
    public Principal user(Principal user){
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public Result world(@RequestParam String name) {
        Result result = new Result();
        System.out.println(name);
        if (true)
        throw new DescribeException(ExceptionEnum.AccountIsLocked);
        return result;
    }

    /**
     * 查询单个用户
     *
     * @return
     */
    @RequestMapping(value = "/searchById", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<SysUser> searchById(long uid) {
        logger.info("根据id查询用户{}", uid);
        SysUser sysUser = userService.getUser(uid);
        logger.info("根据查询用户{}", sysUser.toString());
        return new ServiceResult<SysUser>(Boolean.TRUE, sysUser);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<List<SysUser>> searchAll() {
        logger.info("查询所有用户1");
        List<SysUser> sysUsers = userService.getUsers();
        return new ServiceResult<List<SysUser>>(true, sysUsers);
    }
    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public User search() {
//        logger.info("查询所有用户1");
        return new User();
    }
    /**
     * 添加对象 name username, password
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult<Boolean> save(SysUser sysUser) {
        logger.info("执行用户添加");
        sysUser.setState((byte) 1);
        boolean boo = userService.save(sysUser);
        return new ServiceResult<Boolean>(true, boo);
    }


    /**
     * 添加成功,返回用户对象
     *
     * @return
     */
    @RequestMapping(value = "/updateState", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<Long> updateState() {
        logger.info("执行用户添加");
        SysUser sysUser = new SysUser();
        sysUser.setUid(1);
        long result = 0;
        try {
            result = userService.updateState(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ServiceResult<Long>(true, result);
    }

    /**
     * 添加成功,返回用户对象
     *
     * @return
     */
    @RequestMapping(value = "/updateState1", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<Long> updateState1() {
        logger.info("执行用户添加");
        SysUser sysUser = new SysUser();
        sysUser.setUid(2);
        long result = userService.updateState1(sysUser);
        return new ServiceResult<Long>(true, result);
    }
}
