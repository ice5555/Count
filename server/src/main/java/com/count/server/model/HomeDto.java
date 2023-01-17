package com.count.server.model;

import java.sql.Date;

public class HomeDto {
    int id;
    String label;
    String custom;
    float count;
    String comment;
    String type;
    Date cus_date;
    Boolean write_off;
    String pic;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getCustom() {
        return custom;
    }
    public void setCustom(String custom) {
        this.custom = custom;
    }
    public float getCount() {
        return count;
    }
    public void setCount(float count) {
        this.count = count;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Date getCus_date() {
        return cus_date;
    }
    public void setCus_date(Date cus_date) {
        this.cus_date = cus_date;
    }

    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public Boolean getWrite_off() {
        return write_off;
    }
    public void setWrite_off(Boolean write_off) {
        this.write_off = write_off;
    }
    
}
