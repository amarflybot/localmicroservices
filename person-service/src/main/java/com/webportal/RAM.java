package com.webportal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by amarendra on 24/09/16.
 */
@Document(collection = "RAM")
public class RAM {

    @Id
    private Long id;
    private String ramName;
    private RAMCLASS ramclass;

    public RAM(Long id, String ramName, RAMCLASS ramclass) {
        this.id = id;
        this.ramName = ramName;
        this.ramclass = ramclass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRamName() {
        return ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    public RAMCLASS getRamclass() {
        return ramclass;
    }

    public void setRamclass(RAMCLASS ramclass) {
        this.ramclass = ramclass;
    }
}
