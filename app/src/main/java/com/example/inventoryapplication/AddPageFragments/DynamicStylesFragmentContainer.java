package com.example.inventoryapplication.AddPageFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DynamicStylesFragmentContainer extends Fragment {
    private FragmentManager fragmentManager;
    //private FragmentTransaction fragmentTransaction;
    private static int fragCount = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_container_dynamic_styles, container,false);
        return view;
    }

    //displays number of fragments based on style type
    public void addStylesFragment(FragmentManager temp){

        if(fragmentManager == null) {
            System.out.println("TESTING IF FRAGMENT MANAGER IS NULL");
        }

        if(fragCount < 3) {
            System.out.println("-------------------------------------");
            FragmentTransaction fragmentTransaction = temp.beginTransaction();

            Fragment dynamicStyles = new DynamicStylesFragment();
            String latest = "dynamicFragment" + fragCount;
            fragmentTransaction.add(R.id.fragmentDynamicStyles, dynamicStyles, latest);
            fragmentTransaction.commit();
            fragCount++;
            System.out.println("fragCount: " + fragCount);
            System.out.println("-------------------------------------");
        }
        System.out.println("-------------------------------------");

    }
}
