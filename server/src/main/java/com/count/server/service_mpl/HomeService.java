package com.count.server.service_mpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.count.server.dao.IHomeMapper;
import com.count.server.model.HomeDto;
import com.count.server.resdto.ListResult;
import com.count.server.service.IHomeService;
import java.util.List;

@Service
public class HomeService implements IHomeService{
    @Autowired
    IHomeMapper mapper;
    
    @Override
    public ListResult labels(){
        ListResult result = new ListResult();
        result.setList(mapper.labels());
        result.setCount(mapper.num()); 
        return result;
    }

    @Override
    public boolean add(HomeDto dto){

        return mapper.add(dto);
    }

}
