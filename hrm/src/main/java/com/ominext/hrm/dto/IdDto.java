package com.ominext.hrm.dto;

import java.io.Serializable;

public class IdDto implements Serializable {

    private static final long serialVersionUID = 5042675909233566226L;
    
    private String id;
    
    public IdDto(String id) {
        super();
        
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
