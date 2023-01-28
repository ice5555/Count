package com.count.server.service_mpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import com.count.server.dao.IHomeMapper;
import com.count.server.model.HomeDto;
import com.count.server.reqdto.Querydto;
import com.count.server.resdto.CmpDto;
import com.count.server.resdto.ListResult;
import com.count.server.resdto.SumDto;
import com.count.server.service.IHomeService;
import java.util.List;
import java.util.ArrayList;
// import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    private boolean filterOrderProp(String prop) {
        List<String> types = new ArrayList<String>() {{
            add("label");
            add("cus_date");
            add("type");
            add("custom");
            add("count");
            add("write_off");
        }};
        return !types.contains(prop);
    }

    @Override
    public ListResult list(Querydto querydto){
        querydto.setPage((querydto.getPage() - 1) * querydto.getNum());
        querydto.setType(filterType(querydto.getType(), querydto.getKey()));
        querydto.setOrder((filterOrderProp(querydto.getOrderProp()) || querydto.getOrder() == null) ? null : querydto.getOrder().equals("ascending") ? "asc" : "desc");
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


    @Override
    @Transactional
    public Boolean deal(String path) throws IOException, ParseException {
        File root = new File("./upload");

        String fullPath = root.getCanonicalPath() + File.separator + "common" + File.separator + path;
        File dir = new File(fullPath);

        BufferedReader br = null;
        String line = "";
        String splitBy = ",";

        br = new BufferedReader(new FileReader(dir));
        while ((line = br.readLine()) != null) {
            String[] item = line.split(splitBy);
            System.out.println(item);
            HomeDto homeDto = new HomeDto();

            homeDto.setLabel(item[0]);
            homeDto.setCustom(item[1]);
            homeDto.setCount(Float.parseFloat(item[2]));
            homeDto.setType(item[3]);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            homeDto.setCus_date(new java.sql.Date(sdf.parse(item[4]).getTime()));
            homeDto.setWrite_off(item[5].equals("true"));
            homeDto.setComment(item[6]);
            mapper.add(homeDto);
        }
        return true;
    }

}
