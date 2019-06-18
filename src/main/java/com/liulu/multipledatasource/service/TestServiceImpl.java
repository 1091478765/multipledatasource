package com.liulu.multipledatasource.service;

import com.liulu.multipledatasource.bean.User;
import com.liulu.multipledatasource.config.DataSourceContextHolder;
import com.liulu.multipledatasource.dao.UserMapper;
import com.liulu.multipledatasource.utils.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findpage1() {
        DataSourceContextHolder.setDB("datasource1");
        PageHelper pageHelper = new PageHelper();
        List<User> list = userMapper.selectByRowBounds(null,pageHelper);
        return list;
    }

    @Override
    public List<User> findpage2() {
        DataSourceContextHolder.setDB("datasource2");
        PageHelper pageHelper = new PageHelper();
        List<User> list = userMapper.selectByRowBounds(null,pageHelper);
        return list;
    }
}
