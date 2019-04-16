package com.example.inventoryapplication.AddPageFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class DynamicStylesFragment extends Fragment {
    private static ArrayList<DynamicStylesFragment> list = new ArrayList<DynamicStylesFragment>();
    private static int  count = 0;
    private int localID;

    public int getLocalID(){
        return localID;
    }
    //when MeasurementInfoFragment is destroyed, count is reset to 0
    public static void destroyed() { count = 0; list.clear(); }
    public static ArrayList<DynamicStylesFragment> getList(){ return list; }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_styles, container, false);


        //DELETING A DYNAMIC STYLES FRAGMENT
        EditText input = view.findViewById(R.id.editTextMeasurementInput);
        //view.setOnLongClickListener(new View.OnLongClickListener(){
        input.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(list.size() > 1) {
Toast.makeText(getContext(), "Fragment ID: " + localID, Toast.LENGTH_SHORT).show();
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
                return true;
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        count++;
        localID = count;
        list.add(this);
        String output = "ID: " + localID
                + "\nCount: "  + count;
        Toast.makeText(getContext(), output , Toast.LENGTH_SHORT).show();
    }
}
