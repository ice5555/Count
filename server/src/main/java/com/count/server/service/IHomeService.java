package com.count.server.service;

import java.util.List;

import com.count.server.model.HomeDto;

public interface IHomeService{
    List <HomeDto> labels();
    boolean add(HomeDto dto);
}
