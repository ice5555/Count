package com.count.server.reqdto;

import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

public class Querydto {
    @ApiModelProperty(value="关键字")
    String key;
    @ApiModelProperty(value="类型")
    String type;

    
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
}
