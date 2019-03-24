package com.example.inventoryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inventoryapplication.AddPageFragments.TestFunctionsFragment;
import com.example.inventoryapplication.ItemDetailFragment.MainInfoFragment;
import com.example.inventoryapplication.Provider.Hat;
import com.example.inventoryapplication.Provider.HatDataInjector;

public class ItemDetail extends AppCompatActivity {

    TextView itemName;
    LinearLayout fragContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        HatDataInjector datainjector = new HatDataInjector();
        itemName = findViewById(R.id.textview_item_name);
        Hat tempHat = datainjector.getHatbyID((Integer)getIntent().getExtras().get("extra_itemid"));
        itemName.setText("Currently Displaying: " + tempHat.getName());
        fragContainer = findViewById(R.id.layout_item_detail);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MainInfoFragment fragment = new MainInfoFragment();
        fragmentTransaction.add(R.id.fragment_main_info, fragment);
        fragmentTransaction.commit();

        Fragment fragment_2 = addNewFragment();
        //FragmentManager fm2 = getSupportFragmentManager();
        //FragmentTransaction ft2 = fm2.beginTransaction();
        fragmentTransaction.add(R.id.layout_item_detail, fragment_2);
        Fragment fragment_3 = new TestFunctionsFragment();
        fragmentTransaction.add(R.id.layout_item_detail, fragment_3);
        //ft2.addToBackStack(null);
        //ft2.commit();

    }

    public Fragment addNewFragment(){
        MainInfoFragment fragment = new MainInfoFragment();
        return fragment;
    }
}
