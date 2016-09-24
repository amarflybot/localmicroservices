package com.webportal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by amarendra on 24/09/16.
 */

@Document(collection = "Computer")
public class Computer {

    @Id
    private Long id;
    private String name;
    private Integer ipaddress;
    private String brand;

    public Computer() {
    }

    public Computer(Long id, String name, Integer ipaddress, String brand) {
        this.id = id;
        this.name = name;
        this.ipaddress = ipaddress;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(Integer ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ipaddress=" + ipaddress +
                ", brand='" + brand + '\'' +
                '}';
    }
}
