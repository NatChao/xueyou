package com.xueyouwang.xueyou;

import com.xueyouwang.xueyou.dao.UserDao;
import com.xueyouwang.xueyou.entity.User;
import com.xueyouwang.xueyou.service.Impl.UserServiceImpl;
import com.xueyouwang.xueyou.utlis.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = XueyouApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testSelectUserName(){
        User user = new User();
        user.setUserName("abc111");
        user.setPassword("abc111");
        userServiceImpl.register(user);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("Max123333");
        user.setPassword("123456");
        userDao.save(user);
    }

    @Test
    public void testMD5(){
        String md5 = Util.getMD5("123456");
        System.out.println("md5  : " + md5);
        System.out.println(md5.equals("e10adc3949ba59abbe56e057f20f883e"));
    }

}
