package com.count.server.service;

import java.util.List;

import com.count.server.model.HomeDto;
import com.count.server.resdto.ListResult;

public interface IHomeService{
    ListResult labels();
    boolean add(HomeDto dto);
}
