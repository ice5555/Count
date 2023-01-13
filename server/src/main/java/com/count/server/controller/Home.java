package com.count.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.count.server.model.HomeDto;
import com.count.server.reqdto.Querydto;
import com.count.server.resdto.CmpDto;
import com.count.server.resdto.ListResult;
import com.count.server.resdto.SumDto;
import com.count.server.service.IHomeService;
//import com.count.server.resdto.s;;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
@RestController
@RequestMapping("api/home")
@Api(tags="首页")
public class Home {
    
    @Autowired
    IHomeService HomeService;

    @PostMapping("/list")
    @ApiOperation("查询")
    public ResponseEntity<ListResult> list(@RequestBody Querydto querydto){
        return ResponseEntity.ok(HomeService.list(querydto));
    }

    @GetMapping("/detail")
    @ApiOperation("详情")
    public ResponseEntity<HomeDto> detail(@RequestParam("id") int id){
        return ResponseEntity.ok(HomeService.detail(id));
    }

    @PostMapping("/sum")
    @ApiOperation("总和")
    public ResponseEntity<List<SumDto>> sum(@RequestBody Querydto querydto){
        return ResponseEntity.ok(HomeService.sum(querydto));
    }

    @PostMapping("/compare")
    @ApiOperation("比较")
    public ResponseEntity<List<CmpDto>> compare(@RequestBody Querydto querydto){
        return ResponseEntity.ok(HomeService.compare(querydto));
    }

    @PostMapping("/add")
    @ApiOperation("增加")
    public ResponseEntity<Boolean> add(@RequestBody HomeDto dto){
        return ResponseEntity.ok(HomeService.add(dto));
    }

    @PostMapping("/edit")
    @ApiOperation("修改")
    public ResponseEntity<Boolean> edit(@RequestBody HomeDto dto){
        return ResponseEntity.ok(HomeService.edit(dto));
    }

    @PostMapping("/delete")
    @ApiOperation("批量删除")
    public ResponseEntity<Integer> delete(@RequestBody List<Integer> ids ){
        return ResponseEntity.ok(HomeService.delete(ids));
    }

}
