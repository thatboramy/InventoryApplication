package com.example.inventoryapplication.Provider;

import java.util.ArrayList;

public interface IUserProvider {
    ArrayList<String> getAllNames();
}

interface IInventoryProvider{
    ArrayList<String> getAllHatNames();
    ArrayList<String> getAllUserNames();
}

interface IHatProvider{
    ArrayList<String> getAllHatNames();
}