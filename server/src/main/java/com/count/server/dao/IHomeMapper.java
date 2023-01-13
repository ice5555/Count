package com.count.server.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.count.server.controller.Home;
import com.count.server.model.HomeDto;
import com.count.server.reqdto.Querydto;
import com.count.server.resdto.CmpDto;
import com.count.server.resdto.ListResult;
import com.count.server.resdto.SumDto;

@Mapper
@Repository
public interface IHomeMapper {
    List<HomeDto> list(Querydto querydto); 
    int count(Querydto querydto);
    boolean add(HomeDto dto);
    
	int delete(@Param("ids") List<Integer> ids);
    List<CmpDto> compare(Querydto querydto);
    boolean edit(HomeDto dto);
    HomeDto detail(int id);
    List<SumDto> sum(Querydto querydto);
}