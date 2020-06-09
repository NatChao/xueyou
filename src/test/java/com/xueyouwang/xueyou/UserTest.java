package com.xueyouwang.xueyou;

import com.xueyouwang.xueyou.dao.FileDao;
import com.xueyouwang.xueyou.dao.UserMapper;
import com.xueyouwang.xueyou.entity.FilePath;
import com.xueyouwang.xueyou.entity.User;
import com.xueyouwang.xueyou.service.Impl.UserServiceImpl;
import com.xueyouwang.xueyou.utlis.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = XueyouApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FileDao fileDao;

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
        userMapper.insertSelective(user);
    }

    @Test
    public void testMD5(){
        String md5 = Util.getMD5("123456");
        System.out.println("md5  : " + md5);
        System.out.println(md5.equals("e10adc3949ba59abbe56e057f20f883e"));
    }

    @Test
    public void getFiles(){
        List<FilePath> filePaths = fileDao.queryFiles();
        for (FilePath file: filePaths) {
            System.out.println("file : " + file.toString());
        }
    }

    @Test
    public void getUser(){
        User aaa = userMapper.selectUserName("aaa");
        System.out.println("userName : "  + aaa.getUserName());
    }


}
