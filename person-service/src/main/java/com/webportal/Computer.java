package com.webportal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

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

    @OneToOne
    private MotherBoard motherBoard;

    @OneToMany
    private List<RAM> ramList;

    public Computer() {
    }

    public Computer(Long id, String name, Integer ipaddress,
                    String brand, MotherBoard motherBoard,
                    List<RAM> ramList) {
        this.id = id;
        this.name = name;
        this.ipaddress = ipaddress;
        this.brand = brand;
        this.motherBoard = motherBoard;
        this.ramList = ramList;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }

    public List<RAM> getRamList() {
        return ramList;
    }

    public void setRamList(List<RAM> ramList) {
        this.ramList = ramList;
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
