package com.example.inventoryapplication.Provider;

import android.util.Pair;

import java.util.ArrayList;

public class Hat {
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void addDetail(String label, String value){
        Pair<String, String> temp = new Pair<String, String>(label,value);
        if(this.otherDetails == null){
            this.otherDetails = new ArrayList<Pair<String, String>>();
            this.otherDetails.add(new Pair<String, String>(label, value));
        }
    }

    String name;
    String color;
    String status;
    //Only display in detailView
    String brand;
    String material;
    String condition;
    String size;

    public ArrayList<Pair<String, String>> getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(ArrayList<Pair<String, String>> otherDetails) {
        this.otherDetails = otherDetails;
    }

    ArrayList<Pair <String,String>> otherDetails;

    public Hat(String name, String color, String status, String brand, String material, String condition, String size) {
        this.name = name;
        this.color = color;
        this.status = status;
        this.brand = brand;
        this.material = material;
        this.condition = condition;
        this.size = size;
    }

    public Hat(String name, String color, String status, String brand, String material, String size) {
        this.name = name;
        this.color = color;
        this.status = status;
        this.brand = brand;
        this.material = material;
        this.size = size;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Hat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Hat(String name, String color, String status) {
        this.name = name;
        this.color = color;
        this.status = status;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
