package com.example.inventoryapplication.Provider;

import java.util.ArrayList;

public class CategoryDataInjector implements ICategoryProvider {
    @Override
    public ArrayList<Category> getCategories() {
        ArrayList<Category> temp = new ArrayList<>();
        temp.add(new Category(1, "Hat"));
        temp.add(new Category(2, "Shirt"));
        temp.add(new Category(3, "Pants"));
        temp.add(new Category(4, "Jacket"));
        return temp;
    }

    @Override
    public ArrayList<CategoryAttribute> getCategoryAttributesById(long id) {
        ArrayList<CategoryAttribute> tempCA = new ArrayList<>();
        //public CategoryAttribute(boolean required, int listOrder, String attributeName, String attributeDisplayName, int attributeValueLimit, String attributeValue, String UIDisplayType) {
            tempCA.add(new CategoryAttribute(true, 1, "adjustable","Adjustable?", 5, "bool", "BOOLEAN"));
            tempCA.add(new CategoryAttribute(false,2,"size","Size", 10, "int","MEASUREMENT"));
        return tempCA;
    }
}
