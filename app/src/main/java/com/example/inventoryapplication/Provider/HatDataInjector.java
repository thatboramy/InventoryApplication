package com.example.inventoryapplication.Provider;

import java.util.ArrayList;

public class HatDataInjector implements IHatProvider {

    IHatProvider hatprovider = new MockHat();

    @Override
    public ArrayList<String> getAllHatNames() {
        return hatprovider.getAllHatNames();
    }
}
