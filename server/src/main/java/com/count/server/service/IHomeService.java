package com.count.server.service;

import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import org.springframework.http.ResponseEntity;
import com.count.server.controller.Home;
import com.count.server.model.HomeDto;
import com.count.server.reqdto.Querydto;
import com.count.server.resdto.CmpDto;
import com.count.server.resdto.ListResult;
import com.count.server.resdto.SumDto;

public interface IHomeService{
    ListResult list(Querydto querydto);
    boolean add(HomeDto dto);
    boolean edit(HomeDto dto);
    HomeDto detail(int id);
    List<SumDto> sum(Querydto querydto);
    List<CmpDto> compare(Querydto querydto);
    int delete(List<Integer> ids);
    Boolean deal(String path) throws IOException, ParseException;
}
