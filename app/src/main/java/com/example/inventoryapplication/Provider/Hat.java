package com.example.inventoryapplication.Provider;

public class Hat {
    String name;
    String color;
    String status;
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
