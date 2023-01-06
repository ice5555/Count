package com.count.server.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.count.server.reqdto.Querydto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/home")
@Api(tags="首页")
public class home {
    @GetMapping("/test1")
    @ApiOperation("测试接口1")
    public ResponseEntity<String> test1(@RequestParam("msg")String msg){
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/test2")
    @ApiOperation("测试接口2")
    public ResponseEntity<Querydto> test2(@RequestBody Querydto msg){
        return ResponseEntity.ok(msg);
    }




}
