package com.example.inventoryapplication.AddPageFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.inventoryapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DynamicStylesFragmentMeasure extends DynamicStylesFragmentContainer {
    public DynamicStylesFragmentMeasure(){ super(); super.add(this); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_dynamic_styles_measure, container, false);

        TextView textView = view.findViewById(R.id.textView3);
        textView.setText(super.label);
        System.out.println("-------------------------");
        System.out.println("Measure: " + super.label);
        System.out.println("Local ID: " + super.localID);
        System.out.println("-------------------------");

        //DELETING A DYNAMIC STYLES CONTAINER SUBCLASS FRAGMENT
        Button measure = view.findViewById(R.id.button);
        //view.setOnLongClickListener(new View.OnLongClickListener(){
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getListSize() > getRequiredFragments()) {
                    remove();
                }
            }
        });
        return view;
    }
}
