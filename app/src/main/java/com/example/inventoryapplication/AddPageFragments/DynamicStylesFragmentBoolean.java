package com.example.inventoryapplication.AddPageFragments;

import android.content.Context;
import android.icu.util.Measure;
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
    public DynamicStylesFragmentBoolean(){ super(); super.add(this); }
    Button deleteButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_dynamic_styles_boolean, container, false);

        TextView textView = view.findViewById(R.id.textView9);
        textView.setText(super.label);
        deleteButton = view.findViewById(R.id.delete_button_bool);
        //DELETING A DYNAMIC STYLES CONTAINER SUBCLASS FRAGMENT
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
}
