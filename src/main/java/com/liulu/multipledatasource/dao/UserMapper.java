package com.liulu.multipledatasource.dao;

import com.liulu.multipledatasource.bean.User;
import com.liulu.multipledatasource.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}