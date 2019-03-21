package com.example.inventoryapplication.Provider;

import java.util.ArrayList;

public class UserDataInjector implements IUserProvider {
    IUserProvider provider = new MockUser();
    @Override
    public ArrayList<String> getAllNames() {
        return provider.getAllNames();
    }
}
