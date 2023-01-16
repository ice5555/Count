package com.count.server.reqdto;

import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

public class Querydto {
    @ApiModelProperty(value="关键字")
    String key;
    @ApiModelProperty(value="类型")
    String type;

    @ApiModelProperty(value = "页码（从1开始）")
    int page;
    @ApiModelProperty(value = "每页数量")
    int num;

    @ApiModelProperty(value = "是否已经销账")
    boolean write_off;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Boolean getWrite_off() {
        return write_off;
    }
    public void setWrite_off(Boolean write_off) {
        this.write_off = write_off;
    }


}
