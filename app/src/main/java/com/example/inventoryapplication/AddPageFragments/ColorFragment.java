package com.example.inventoryapplication.AddPageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.inventoryapplication.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ColorFragment extends Fragment {

    View currentView;
    Spinner spinner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentView = inflater.inflate(R.layout.fragment_color, container, false);

        //ArrayList<String> spinnerArray = new ArrayList<>();
        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Black");
        spinnerArray.add("Red");
        spinnerArray.add("Grey");
        spinnerArray.add("Green");
        spinnerArray.add("Blue");
        spinnerArray.add("Yellow");

        spinner = currentView.findViewById(R.id.spinner_color);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                spinnerArray
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return currentView;
    }
}
