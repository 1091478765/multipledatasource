package com.liulu.multipledatasource.service;

import com.liulu.multipledatasource.bean.User;

import java.util.List;

public interface TestService {

    public List<User> findpage1();
    public List<User> findpage2();

}
