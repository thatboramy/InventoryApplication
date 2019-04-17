package com.example.inventoryapplication.AddPageFragments;

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
    public DynamicStylesFragmentMeasure(){ super.add(this); }
    TextView label;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dynamic_styles_measure, container, false);
        label = view.findViewById(R.id.measure_label);
        label.setText("Measure");
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

    public void setName(String dName){
        View test = this.getView();
        label = this.getView().findViewById(R.id.measure_label);
        label.setText(dName);
    }

}
