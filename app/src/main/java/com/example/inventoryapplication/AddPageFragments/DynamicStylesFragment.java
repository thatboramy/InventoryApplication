package com.example.inventoryapplication.AddPageFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.inventoryapplication.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DynamicStylesFragment extends DynamicStylesFragmentContainer {
    public DynamicStylesFragment(){
        localID = count;
        count++;
        super.add(this);
    }
/*
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_styles, container, false);

        //DELETING A DYNAMIC STYLES CONTAINER SUBCLASS FRAGMENT
        Button measure = view.findViewById(R.id.button);
        //view.setOnLongClickListener(new View.OnLongClickListener(){
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getListSize() > 1) {
                    //find fragment that user wants to remove
                    String tag = "dynamic: " + localID;
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment removeFrag = fragmentManager.findFragmentByTag(tag);
                    fragmentTransaction.remove(removeFrag);
                    fragmentTransaction.commit();
                    //remove fragment from list
                    for(int i = 0; i < list.size(); i++){
                        if(localID == list.get(i).getLocalID())
                            list.remove(i);
                    }
                }
            }
        });
        return view;
    }

}
