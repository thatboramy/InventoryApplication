package com.example.inventoryapplication.Provider;

import java.util.ArrayList;
import java.util.Random;


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

    String[] hatType = new String[]{"Cap", "Beanie", "Baseball Cap", "Fedora", "Trucker Hat"};
    String[] color = new String[]{"Red", "Brown", "Blue", "Green", "Yellow", "Purple"};
    String[] status = new String[]{"UNLISTED", "POSTED", "SOLD"};
    String[] brand = new String[]{"Nike", "Addidas", "Puma", "Hawaiin Headwear", "Pendelton", "Logo7"};
    String[] material = new String[]{"Cotton", "Fur", "Leather", "Fake Cotton", "Silk", "Wool", "Fake Wool"};
    String[] size = new String[]{"One Size", "Adjustable"};

    public MockHat() {
        this.hatList = new ArrayList<>();
        for(int i = 0 ; i < 20; i++){
            hatList.add(generateHat());
        }
    }
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

    @Override
    public Hat getHatbyID(int id) {
        return hatList.get(id);
    }

    Hat generateHat(){
        Hat tempHat = new Hat(generateRand(hatType), generateRand(color), generateRand(status), generateRand(brand), generateRand(material),generateRand(size));
        return tempHat;
    }

    String generateRand(String[] arr){
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }
}