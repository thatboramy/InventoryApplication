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
