package com.webportal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by amarendra on 24/09/16.
 */
@Document(collection = "MotherBoard")
public class MotherBoard {

    @Id
    private Long id;
    private String motherboardName;

    public MotherBoard(Long id, String motherboardName) {
        this.id = id;
        this.motherboardName = motherboardName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }
}
