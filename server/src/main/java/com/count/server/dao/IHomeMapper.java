package com.count.server.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.count.server.controller.Home;
import com.count.server.model.HomeDto;

@Mapper
@Repository
public interface IHomeMapper {
    List <HomeDto> labels();    
    boolean add(HomeDto dto);
    int num();
}