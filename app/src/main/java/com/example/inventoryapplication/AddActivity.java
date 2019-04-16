package com.example.inventoryapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.inventoryapplication.AddPageFragments.ColorFragment;
import com.example.inventoryapplication.AddPageFragments.DynamicStylesFragment;
import com.example.inventoryapplication.AddPageFragments.onClickedFragmentListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AddActivity extends AppCompatActivity implements onClickedFragmentListener {

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

    }

    @Override
    public void onButtonClicked(String nextfragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (nextfragment) {
            case "COLOR":
                ColorFragment cf = new ColorFragment();
                fragmentTransaction.add(R.id.add_measurement_fragments, cf);
                break;

            case "MEASURE":
                DynamicStylesFragment df = new DynamicStylesFragment();
                String tag = "dynamic: " + df.getLocalID();
                Toast.makeText(getApplicationContext(), tag + " created", Toast.LENGTH_SHORT).show();
                fragmentTransaction.add(R.id.add_measurement_fragments, df, tag);

                break;

        }
        fragmentTransaction.commit();
    }
}
