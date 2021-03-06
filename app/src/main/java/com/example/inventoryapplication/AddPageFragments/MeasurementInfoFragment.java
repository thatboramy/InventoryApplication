package com.example.inventoryapplication.AddPageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.inventoryapplication.Provider.Category;
import com.example.inventoryapplication.Provider.CategoryAttribute;
import com.example.inventoryapplication.Provider.CategoryDataInjector;
import com.example.inventoryapplication.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MeasurementInfoFragment extends Fragment {
    private View view;
    private Boolean minimized = false;
    private static String label = "";
    //private String previousCategory = "EMPTY SPACE";
    //private String currentCategory;

    public static String getText(){ return label; }

    private void addDynamicFragment(String type, String text) {
        label = text;
        DynamicStylesFragmentContainer dynamicFragment;
        //LOGIC THAT DISPLAYS TYPE OF EXPECTED USER INPUT
        if (type == "MEASUREMENT")
            dynamicFragment = new DynamicStylesFragmentMeasure();
        else if (type == "BOOLEAN"){
            dynamicFragment = new DynamicStylesFragmentBoolean();
        }else{
            dynamicFragment = new DynamicStylesFragmentSpinner();
        }

        //SET UP DYNAMIC ID: DYNAMICFRAGMENT
        String tag = "dynamic: " + dynamicFragment.getLocalID();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.add_measurement_fragments, dynamicFragment, tag);
        fragmentTransaction.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_measurement_info, container, false);
        Button btnAddMeasurement = (Button) view.findViewById(R.id.buttonNew);
        Button btnContinue = (Button) view.findViewById(R.id.buttonContinue);

        //SET UP SPINNER
        final Spinner spinner = view.findViewById(R.id.spinnerSection);
        final CategoryDataInjector catInjector = new CategoryDataInjector();
        final ArrayList<Category> categories = catInjector.getCategories();
        final ArrayList<String> categories_name = new ArrayList<>();
        categories_name.add("");
        for(Category c:categories){
            categories_name.add(c.getName());
        }
        //ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.ClothingType, android.R.layout.simple_spinner_item);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,categories_name);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        //Spinner OnCLick Listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected_type = spinner.getSelectedItem().toString();
                long type;
                if(selected_type == "Hat"){
                    type = 1;
                }else{type = 2;}

                //REMOVE EMPTY SPACE SPINNER OPTION
                if(selected_type.equals("")){
                    System.out.println("-----------------");
                    System.out.println("INITIALIZING THE MEASUREINFO");
                    System.out.println("-----------------");
                }
                else if(categories_name.get(0).equals("") && !selected_type.equals("")) {
                    //empty item listener is not selected
                    ArrayList<CategoryAttribute> tempCA = catInjector.getCategoryAttributesById(type);
                    removeCurrFragments();
                    for (CategoryAttribute c : tempCA) {
                        addDynamicFragment(c.getUIDisplayType(), c.getAttributeDisplayName());
                    }
                    categories_name.remove(0);
                }
                //SET UP FRAGMENTS OF NEW CATEGORY
                else {
                    //DynamicStylesFragmentContainer.destroyed();

                    ArrayList<CategoryAttribute> tempCA = catInjector.getCategoryAttributesById(type);
                    removeCurrFragments();
                    for (CategoryAttribute c : tempCA) {
                        addDynamicFragment(c.getUIDisplayType(), c.getAttributeDisplayName());
                    }
                    System.out.println("-----------------");
                    System.out.println("SELECTED DIFFERENT CATEGORY");
                    System.out.println("-----------------");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //SETUP INITIAL PROMPTS FOR USER
        //String databaseResponse = "BMBBMBBMB";
        //setupRequiredInputs(databaseResponse);

        //ADD CLICKLISTENER TO BUTTON
        btnAddMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDynamicFragment("BOOLEAN", "TEST 1");
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

    private void removeCurrFragments() {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        List<Fragment> fragments = fm.getFragments();
        for(Fragment f: fragments){
            ft.remove(f);
        }
        ft.commit();
    }

    private void setupRequiredInputs(String response){
        //ADD DYNAMIC STYLES FRAGMENTS
        for(int i = 0; i < response.length(); i++) {
            if(response.charAt(i) == 'M')
                addDynamicFragment("MEASURE", "TEST 2");
            else
                addDynamicFragment("BOOLEAN", "TEST 3");
        }
    }

    private void minimize(){
        minimized = true;
        //HIDE SPINNER
        Spinner spinner = view.findViewById(R.id.spinnerSection);
        spinner.setVisibility(view.GONE);
        //HIDE NEW MEASUREMENT BUTTON
        Button hideButton = view.findViewById(R.id.buttonNew);
        hideButton.setVisibility(view.GONE);
        hideButton = view.findViewById(R.id.buttonContinue);
        hideButton.setVisibility(view.GONE);

        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        List<Fragment> test = fm.getFragments();
        for(Fragment f:test){
            ft.hide(f);
        }
        ft.commit();

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

        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        List<Fragment> test = fm.getFragments();
        for(Fragment f:test){ft.show(f);}
        ft.commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //reset the fragment count in DynamicStylesFragmentMeasure
        DynamicStylesFragmentMeasure.destroyed();
    }
}
