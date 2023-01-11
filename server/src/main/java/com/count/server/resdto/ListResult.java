package com.count.server.resdto;

import com.count.server.model.HomeDto;

import java.util.List;
public class ListResult {
    int count;
    List <HomeDto> List; 

public int getCount() {
    return count;
}
public void setCount(int count) {
    this.count = count;
}
public List<HomeDto> getList() {
    return List;
}
public void setList(List<HomeDto> list) {
    List = list;
}

}
