package com.count.server.service_mpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.count.server.dao.IHomeMapper;
import com.count.server.service.IHomeService;
import java.util.List;

//@Service
public class HomeService implements IHomeService{
    @Autowired
    IHomeMapper mapper;
    
    @Override
    public List <String> labels(){

        return mapper.labels();
    }
}
