package com.xueyouwang.xueyou.service.Impl;

import com.xueyouwang.xueyou.dao.UserDao;
import com.xueyouwang.xueyou.entity.Result;
import com.xueyouwang.xueyou.entity.User;
import com.xueyouwang.xueyou.response.ResponseResult;
import com.xueyouwang.xueyou.service.UserService;
import com.xueyouwang.xueyou.utlis.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {
        User userBean = userDao.selectUserName(user.getUserName());
        if (userBean != null)
            return ResponseResult.genFailResult("用户名已存在！");
        String md5Password = Util.getMD5(user.getPassword()); //将用户输入的密码进行MD5加密
        user.setPassword(md5Password);
        user.setCreateTime(LocalDateTime.now());  //设置当前时间
        userDao.save(user);
        return ResponseResult.genSuccessResult("注册成功");
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    //缺少设置session信息、
    @Override
    public Result login(User user) {
        String password = Util.getMD5(user.getPassword()); //将用户输入密码进行MD5加密
        User userBean = userDao.selectUserName(user.getUserName());
        if (userBean != null && userBean.getPassword().equals(password))
            return ResponseResult.genSuccessResult("登录成功");
        return ResponseResult.genFailResult("用户名或密码错误");
    }

}
