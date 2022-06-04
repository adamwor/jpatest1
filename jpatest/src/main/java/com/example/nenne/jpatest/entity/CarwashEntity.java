package com.example.nenne.jpatest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carwash")
public class CarwashEntity {

    @Id
    private String NAME;

    private Integer IDX;

    private String ADDRESS;

    private Double WGS84_LATITUDE;

    private Double WGS84_LONGTITUDE;

    private Integer NUM;

    public Integer getIDX() {
        return IDX;
    }

    public String getNAME() {
        return NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    /*public Double getWGS84_LATITUDE() {
        return WGS84_LATITUDE;
    }

    public Double getWGS84_LONGTITUDE() {
        return WGS84_LONGTITUDE;
    }*/

    public Integer getNUM() {
        return NUM;
    }

    public CarwashEntity(Integer idx, String name, String address,
                         Double wgs84_latitude, Double wgs84_longtitude, Integer num) {
        this.IDX = idx;
        this.NAME = name;
        this.ADDRESS = address;
        this.WGS84_LATITUDE = wgs84_latitude;
        this.WGS84_LONGTITUDE = wgs84_longtitude;
        this.NUM = num;
    }

    // JPA 규약으로 기본 생성자를 제공해야 함
    public CarwashEntity(){

    }
}
