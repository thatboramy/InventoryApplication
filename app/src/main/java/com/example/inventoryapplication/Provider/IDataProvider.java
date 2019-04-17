package com.example.inventoryapplication.Provider;

import java.lang.reflect.Array;
import java.util.ArrayList;

interface IUserProvider {
    ArrayList<String> getAllNames();
}

interface IInventoryProvider{
    ArrayList<String> getAllHatNames();
    ArrayList<String> getAllUserNames();
}

interface IHatProvider{
    ArrayList<String> getAllHatNames();
    ArrayList<Hat> getAllData();
    Hat getHatbyID(int id);
}

interface  ICategoryProvider{
    ArrayList<Category> getCategories();
    ArrayList<CategoryAttribute> getCategoryAttributesById(long id);
}