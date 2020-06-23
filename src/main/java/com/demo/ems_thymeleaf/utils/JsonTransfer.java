package com.demo.ems_thymeleaf.utils;

import java.util.List;

public class JsonTransfer {
    private Integer code=0;
    private String msg="";
    private Integer count=1000;
    private List data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCount() {
        return count;
    }



    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
