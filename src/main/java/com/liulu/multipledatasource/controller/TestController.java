package com.liulu.multipledatasource.controller;

import com.liulu.multipledatasource.annotation.DS;
import com.liulu.multipledatasource.bean.User;
import com.liulu.multipledatasource.config.DataSourceContextHolder;
import com.liulu.multipledatasource.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2018/12/21 14:40
 * @Create Author: nevermore
 * @File Name: TestController
 * @Last version: 1.0.0
 */

@RestController
@Api(value="测试使用controller",tags={"测试使用"})
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;


    @GetMapping("/test1")
    @DS("datasource1")
    public List<User> test1(){
        logger.info("123");
        logger.error("456");
        logger.debug("789");
        DataSourceContextHolder.setDB("datasource2");
        return testService.findpage1();
    }
    @GetMapping("/test2")
    @DS("datasource2")
    public List<User> test2(){
        logger.info("123");
        logger.error("456");
        logger.debug("789");
        DataSourceContextHolder.setDB("datasource1");
        return testService.findpage1();
    }


    @PostMapping("testSwagger")
    public String testSwagger(@RequestBody String name){
        return name;
    }


    @ApiOperation("文件上传")
    @PostMapping("upload")
    public void upload(@RequestParam(value = "file") MultipartFile file){
        logger.info(file.getOriginalFilename());
    }


    @ApiOperation("多文件上传")
    @PostMapping("batchUpload")
    public void batchUpload(@RequestParam(value = "files") List<MultipartFile> files){
        logger.info(String.valueOf(files.size()));
    }

}
