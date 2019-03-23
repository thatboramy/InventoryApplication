package com.example.inventoryapplication.Provider;

import java.util.ArrayList;

class MockUser implements IUserProvider {
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

class MockHat implements IHatProvider{
    ArrayList<Hat> hatList;

    public MockHat() {
        this.hatList = new ArrayList<>();
        hatList.add(new Hat("Beanie", "Brown", "SOLD"));
        hatList.add(new Hat("Beanie", "Red", "UNLISTED"));
        hatList.add(new Hat("Beanie", "Brown", "SOLD"));
        hatList.add(new Hat("Beanie", "Blue", "LISTED"));
        hatList.add(new Hat("Beanie", "Black", "SOLD"));}

    @Override
    public ArrayList<String> getAllHatNames() {
        ArrayList<String> allName = new ArrayList<>();
        for(Hat tempHat : hatList){
            allName.add(tempHat.getName());
        }
        return allName;
    }

    @Override
    public ArrayList<Hat> getAllData() {
        return this.hatList;
    }
}