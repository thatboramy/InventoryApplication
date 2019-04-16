package com.example.inventoryapplication.AddPageFragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.inventoryapplication.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MeasurementInfoFragment extends Fragment {
    onClickedFragmentListener mListener;
    View view;
    Boolean minimized = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_measurement_info, container, false);

        Button btnAddMeasurement = (Button) view.findViewById(R.id.buttonNew);
        Button btnContinue = (Button) view.findViewById(R.id.buttonContinue);

        //SET UP SPINNER
        Spinner spinner = view.findViewById(R.id.spinnerSection);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.ClothingType, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        //ADD DYNAMIC STYLES FRAGMENT
        addDynamicFragment();

        //ADD CLICKLISTENER TO BUTTON
        btnAddMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clickButton();
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
        return view;
    }

    public void minimize(){
        minimized = true;
        //HIDE SPINNER
        Spinner spinner = view.findViewById(R.id.spinnerSection);
        spinner.setVisibility(view.GONE);
/*
        //HIDE DYNAMIC STYLES FRAGMENTS
        ArrayList<DynamicStylesFragment> list = DynamicStylesFragment.getList();
        String tag;
        Fragment hideFrag;
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        for(int i = 0; i < list.size(); i++){
            tag = "Dynamic: " + list.get(i).getLocalID();
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

    public void maximize(){
        minimized = false;
        //SHOW SPINNER
        Spinner spinner = view.findViewById(R.id.spinnerSection);
        spinner.setVisibility(view.VISIBLE);
/*
        //SHOW DYNAMIC STYLES FRAGMENTS
        ArrayList<DynamicStylesFragment> list = DynamicStylesFragment.getList();
        String tag;
        Fragment showFrag;
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        for(int i = 0; i < list.size(); i++){
            tag = "Dynamic: " + list.get(i).getLocalID();
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

    private void addDynamicFragment(){
        DynamicStylesFragment dynamicFragment = new DynamicStylesFragment();
        //SET UP DYNAMIC ID: DYNAMICFRAGMENT
        String tag = "dynamic: " + dynamicFragment.getLocalID();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.add_measurement_fragments, dynamicFragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (onClickedFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnButtonClickedListener ");
        }
    }

    public void clickButton() {
        // When the button is clicked, notify the activity.
        //   The activity will then pass the information to fragment
        //   B (if it has been created).

        //mListener.onButtonClicked("COLOR");
        mListener.onButtonClicked("MEASURE");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //reset the fragment count in DynamicStylesFragment
        DynamicStylesFragment.destroyed();
    }
}
