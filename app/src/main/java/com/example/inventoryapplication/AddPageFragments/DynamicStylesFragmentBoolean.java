package com.example.inventoryapplication.AddPageFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.inventoryapplication.R;

public class DynamicStylesFragmentBoolean extends DynamicStylesFragmentContainer {

    public DynamicStylesFragmentBoolean(){
        super.add(this);
    }

    Button deleteButton;
    TextView label;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_styles_boolean, container, false);
        label = view.findViewById(R.id.boolean_label);
        //DELETING A DYNAMIC STYLES CONTAINER SUBCLASS FRAGMENT
        deleteButton = view.findViewById(R.id.delete_button_bool);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getListSize() > getRequiredFragments()) {
                    //find fragment that user wants to remove
                    remove();
                }
            }
        });
        return view;
    }

    public void setName(String dname){
        label.setText(dname);
    }

    private void removeFragment(){

    }
}
