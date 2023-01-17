package com.count.server.service_mpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.count.server.dao.IHomeMapper;
import com.count.server.model.HomeDto;
import com.count.server.reqdto.Querydto;
import com.count.server.resdto.CmpDto;
import com.count.server.resdto.ListResult;
import com.count.server.resdto.SumDto;
import com.count.server.service.IHomeService;
import java.util.List;
import java.util.ArrayList;
import javax.xml.ws.http.HTTPException;
@Service
public class HomeService implements IHomeService{
    @Autowired
    IHomeMapper mapper;
    private String filterType(String type, String key) {

        String queryString = "";
        List<String> types = new ArrayList<String>() {{
            add("label");
            add("custom");
            add("type");
            add("comment");
            // add("write_off");
        }};
        if (type.equals("all")) {
            for (String tp : types
            ) {
                queryString += tp + " like '%" + key + "%' or ";
            }
            queryString = queryString.substring(0, queryString.length() - 3);
        } else if (types.contains(type)) {
            queryString += type + " like '%" + key+ "%'";
        } 
        // else {
        //     // throw new HTTPException(400);
        // }

        return queryString;
    }

    @Override
    public ListResult list(Querydto querydto){
        querydto.setPage((querydto.getPage() - 1) * querydto.getNum());
        querydto.setType(filterType(querydto.getType(), querydto.getKey()));
        ListResult result = new ListResult();
        result.setList(mapper.list(querydto));
        result.setCount(mapper.count(querydto)); 
        return result;
    }

    @Override
    public boolean add(HomeDto dto){

        return mapper.add(dto);
    }

    @Override
    public boolean edit(HomeDto dto) {

        return mapper.edit(dto);
    }

    @Override
    public HomeDto detail(int id) {
        return mapper.detail(id);
    }

    @Override
    public List<SumDto> sum(Querydto querydto) {
        querydto.setType(filterType(querydto.getType(), querydto.getKey()));
        return mapper.sum(querydto);
    }

    @Override
    public List<CmpDto> compare(Querydto querydto) {
        querydto.setType(filterType(querydto.getType(), querydto.getKey()));
        return mapper.compare(querydto);
    }

    @Override
    public int delete(List<Integer> ids) {
      
        return mapper.delete(ids);
    }



}
