package com.example.inventoryapplication.Provider;

import java.util.ArrayList;

public class HatDataInjector implements IHatProvider {

    IHatProvider hatprovider = new MockHat();

    @Override
    public ArrayList<String> getAllHatNames() {
        return hatprovider.getAllHatNames();
    }

    @Override
    public ArrayList<Hat> getAllData() {
        return hatprovider.getAllData();
    }

    @Override
    public Hat getHatbyID(int id) {
        return hatprovider.getHatbyID(id);
    }
}
