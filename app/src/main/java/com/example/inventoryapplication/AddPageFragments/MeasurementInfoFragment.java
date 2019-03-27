package com.example.inventoryapplication.AddPageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.inventoryapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MeasurementInfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_measurement_info, container, false);

        View newMeasurement =  inflater.inflate(R.layout.fragment_dynamic_styles, container, false);

        Button btnAddMeasurement = (Button) view.findViewById(R.id.buttonNew);
        Button btnContinue = (Button) view.findViewById(R.id.buttonContinue);

        btnAddMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //view.add
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minimize();
            }
        });

        return view;
    }

    public void minimize(){

    }

    public void maximize(){

    }
}
