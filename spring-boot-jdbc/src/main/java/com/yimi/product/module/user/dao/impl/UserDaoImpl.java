package com.yimi.product.module.user.dao.impl;

import com.yimi.product.module.user.dao.UserDao;

/**
 * 用户dao实现
 */
//@Repository
public class UserDaoImpl implements UserDao {
    //private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(String name, int state) {
        //jdbcTemplate.update("INSERT  INTO user_info (name,state) VALUES (?,?)", name, state);
    }

    @Override
    public Integer getAllUsers() {
        //return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM  user_info",Integer.class);
        return null;
    }

}
