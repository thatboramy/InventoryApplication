package com.example.inventoryapplication.Provider;

import java.util.ArrayList;

public class MockUser implements IUserProvider {
    ArrayList<String> names;

    public MockUser() {
        this.names = new ArrayList<>();
        names.add("Anna");
        names.add("Brandon");
        names.add("Chris");
        names.add("Devin");
        names.add("Evans");
    }


    @Override
    public ArrayList<String> getAllNames() {
        return names;
    }
}

class Hat2{
    String name;
    String color;
    String status;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Hat2(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Hat2(String name, String color, String status) {
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

class MockHat implements IHatProvider{
    ArrayList<Hat2> hatList = new ArrayList<>();

    public MockHat() {
        this.hatList = new ArrayList<>();
        hatList.add(new Hat2("Beanie", "Brown", "SOLD"));
        hatList.add(new Hat2("Beanie", "Red", "UNLISTED"));
        hatList.add(new Hat2("Beanie", "Brown", "SOLD"));
        hatList.add(new Hat2("Beanie", "Blue", "LISTED"));
        hatList.add(new Hat2("Beanie", "Black", "SOLD"));}

    @Override
    public ArrayList<String> getAllHatNames() {
        ArrayList<String> allName = new ArrayList<>();
        for(Hat2 tempHat : hatList){
            allName.add(tempHat.getName());
        }
        return allName;
    }
}