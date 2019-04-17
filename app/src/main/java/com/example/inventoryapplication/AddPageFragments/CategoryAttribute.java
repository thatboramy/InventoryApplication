package com.example.inventoryapplication.AddPageFragments;

import java.util.ArrayList;

public class CategoryAttribute {
    boolean required;
    int ListOrder;
    String AttributeName;
    String AttributeDisplayName;
    int AttributeValueLimit;
    String UIDisplayType;

    public CategoryAttribute(boolean required, int listOrder, String attributeName, String attributeDisplayName, String UIDisplayType) {
        this.required = required;
        ListOrder = listOrder;
        AttributeName = attributeName;
        AttributeDisplayName = attributeDisplayName;
        this.UIDisplayType = UIDisplayType;
    }

    public CategoryAttribute() {
    }

    ArrayList<CategoryAttribute> getHatAttribute(){
        ArrayList<CategoryAttribute> tempHat = new ArrayList<>();
        tempHat.add(new CategoryAttribute(true, 0, "adjustable", "Adjustable?","BOOLEAN"));
        tempHat.add(new CategoryAttribute(false, 1, "size","Size", "MEASURE"));
        return tempHat;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getListOrder() {
        return ListOrder;
    }

    public void setListOrder(int listOrder) {
        ListOrder = listOrder;
    }

    public String getAttributeName() {
        return AttributeName;
    }

    public void setAttributeName(String attributeName) {
        AttributeName = attributeName;
    }

    public String getAttributeDisplayName() {
        return AttributeDisplayName;
    }

    public void setAttributeDisplayName(String attributeDisplayName) {
        AttributeDisplayName = attributeDisplayName;
    }

    public int getAttributeValueLimit() {
        return AttributeValueLimit;
    }

    public void setAttributeValueLimit(int attributeValueLimit) {
        AttributeValueLimit = attributeValueLimit;
    }

    public String getUIDisplayType() {
        return UIDisplayType;
    }

    public void setUIDisplayType(String UIDisplayType) {
        this.UIDisplayType = UIDisplayType;
    }
}
