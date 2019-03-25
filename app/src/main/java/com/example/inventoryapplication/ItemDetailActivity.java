package com.example.inventoryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.nfc.Tag;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inventoryapplication.AddPageFragments.TestFunctionsFragment;
import com.example.inventoryapplication.ItemDetailFragment.DescriptionFragment;
import com.example.inventoryapplication.ItemDetailFragment.HatDetailFragment;
import com.example.inventoryapplication.ItemDetailFragment.MainInfoFragment;
import com.example.inventoryapplication.Provider.Hat;
import com.example.inventoryapplication.Provider.HatDataInjector;

public class ItemDetailActivity extends AppCompatActivity {

    TextView itemName;
    LinearLayout fragContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_item_detail);

            //Creating the HatDataInjector
            HatDataInjector datainjector = new HatDataInjector();
            itemName = findViewById(R.id.textview_item_name);
            int postion = (Integer) getIntent().getExtras().get("extra_itemid");
            Hat tempHat = datainjector.getHatbyID(postion);
            itemName.setText("Currently Displaying: " + tempHat.getName());

        if(savedInstanceState == null) {
            //Depending on whether an item was a hat or shirt, we display a different amount of fragments or details
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //First Manual Element:The Name//
            MainInfoFragment fragment = new MainInfoFragment();
            Bundle name = new Bundle();
            name.putString("name", tempHat.getName());
            name.putString("status", tempHat.getStatus());
            fragment.setArguments(name);
            fragmentTransaction.commit();
            Fragment fragment_2 = addNewFragment();
            fragment_2.setArguments(name);
            fragmentTransaction.add(R.id.layout_item_detail, fragment_2);

            //Hat-Only Element//
            HatDetailFragment hatFragment = new HatDetailFragment();
            Bundle hatdetail = new Bundle();
            hatdetail.putString("color", tempHat.getColor());
            hatdetail.putString("brand", tempHat.getBrand());
            hatdetail.putString("size", tempHat.getSize());
            hatdetail.putString("material", tempHat.getMaterial());
            hatFragment.setArguments(hatdetail);
            fragmentTransaction.add(R.id.layout_item_detail, hatFragment);

            //Manual Element: Item Description
            DescriptionFragment descriptionFragment = new DescriptionFragment();
            fragmentTransaction.add(R.id.layout_item_detail, descriptionFragment);
        }
    }

    public Fragment addNewFragment(){
        MainInfoFragment fragment = new MainInfoFragment();
        return fragment;
    }
}
