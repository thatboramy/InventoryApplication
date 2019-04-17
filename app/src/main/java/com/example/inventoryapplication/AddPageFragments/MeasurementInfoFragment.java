package com.example.inventoryapplication.AddPageFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.inventoryapplication.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MeasurementInfoFragment extends Fragment {
    View view;
    Boolean minimized = false;

    private void addDynamicFragment(String type){
        DynamicStylesFragmentContainer dynamicFragment;
        //LOGIC THAT DISPLAYS TYPE OF EXPECTED USER INPUT
        if(type == "MEASURE")
            dynamicFragment = new DynamicStylesFragmentMeasure();
        else
            dynamicFragment = new DynamicStylesFragmentBoolean();
        //SET UP DYNAMIC ID: DYNAMICFRAGMENT
        String tag = "dynamic: " + dynamicFragment.getLocalID();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.add_measurement_fragments, dynamicFragment, tag);
        fragmentTransaction.commit();
    }
    //OVERLOAD WITH 2 Parameters
    private void addDynamicFragment(String type, String dispName){
        DynamicStylesFragmentContainer dynamicFragment;
        //LOGIC THAT DISPLAYS TYPE OF EXPECTED USER INPUT
        if(type == "MEASURE"){
            dynamicFragment = new DynamicStylesFragmentMeasure();

            }
        else
        {dynamicFragment = new DynamicStylesFragmentBoolean();
        }
        //SET UP DYNAMIC ID: DYNAMICFRAGMENT
        String tag = "dynamic: " + dynamicFragment.getLocalID();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.add_measurement_fragments, dynamicFragment, tag);
        fragmentTransaction.commit();
        if(type == "MEASURE")
        {
            
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_measurement_info, container, false);

        Button btnAddMeasurement = (Button) view.findViewById(R.id.buttonNew);
        Button btnContinue = (Button) view.findViewById(R.id.buttonContinue);

        //SET UP SPINNER
        final Spinner spinner = view.findViewById(R.id.spinnerSection);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.ClothingType, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        //SETUP INITIAL PROMPTS FOR USER
        //String databaseResponse = "BMBBMBBM";
        //setupRequiredInputs(databaseResponse);

        //ADD CLICKLISTENER TO BUTTON
        btnAddMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDynamicFragment("BOOLEAN");
            }
        });

        //MINIMIZE FRAGMENT
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!minimized) minimize();
            }
        });

        //MAXIMIZE FRAGMENT
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(minimized) maximize();
            }
        });

        //SPINNER LISTENER
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select_type = spinner.getSelectedItem().toString();
                if (select_type.equals("Cap")) {
                    CategoryAttribute temp_CA = new CategoryAttribute();
                    addFragments(temp_CA.getHatAttribute());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void setupRequiredInputs(String response){
        //ADD DYNAMIC STYLES FRAGMENTS
        for(int i = 0; i < response.length(); i++) {
            if(response.charAt(i) == 'M')
                addDynamicFragment("MEASURE");
            else
                addDynamicFragment("BOOLEAN");
        }
    }

    private void addFragments(ArrayList<CategoryAttribute> list){
        for (CategoryAttribute c: list) {
            switch (c.UIDisplayType){
                case "BOOLEAN":
                    addDynamicFragment("BOOLEAN", c.AttributeDisplayName);
                    break;
                case "MEASURE":
                    addDynamicFragment("MEASURE", c.AttributeDisplayName);
                    break;
            }
        }
    }

    private void minimize(){
        minimized = true;
        //HIDE SPINNER
        Spinner spinner = view.findViewById(R.id.spinnerSection);
        spinner.setVisibility(view.GONE);
/*
        //HIDE DYNAMIC STYLES FRAGMENTS
        ArrayList<DynamicStylesFragmentMeasure> list = DynamicStylesFragmentMeasure.getList();
        String tag;
        Fragment hideFrag;
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        for(int i = 0; i < list.size(); i++){
            tag = "dynamic: " + list.get(i).getLocalID();
            hideFrag = manager.findFragmentByTag(tag);
            transaction.hide(hideFrag);
        }
        transaction.commit();
*/
        //HIDE NEW MEASUREMENT BUTTON
        Button hideButton = view.findViewById(R.id.buttonNew);
        hideButton.setVisibility(view.GONE);
        hideButton = view.findViewById(R.id.buttonContinue);
        hideButton.setVisibility(view.GONE);

    }

    private void maximize(){
        minimized = false;
        //SHOW SPINNER
        Spinner spinner = view.findViewById(R.id.spinnerSection);
        spinner.setVisibility(view.VISIBLE);
/*
        //SHOW DYNAMIC STYLES FRAGMENTS
        ArrayList<DynamicStylesFragmentMeasure> list = DynamicStylesFragmentMeasure.getList();
        String tag;
        Fragment showFrag;
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        for(int i = 0; i < list.size(); i++){
            tag = "dynamic: " + list.get(i).getLocalID();
            showFrag = manager.findFragmentByTag(tag);
            transaction.show(showFrag);
        }
        transaction.commit();
*/
        //SHOW NEW MEASUREMENT BUTTON
        Button showButton = view.findViewById(R.id.buttonNew);
        showButton.setVisibility(view.VISIBLE);
        showButton = view.findViewById(R.id.buttonContinue);
        showButton.setVisibility(view.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //reset the fragment count in DynamicStylesFragmentMeasure
        DynamicStylesFragmentMeasure.destroyed();
    }
}
