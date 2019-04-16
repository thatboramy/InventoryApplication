package com.example.inventoryapplication.AddPageFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.inventoryapplication.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class DynamicStylesFragmentContainer extends Fragment {
    protected static ArrayList<DynamicStylesFragmentContainer> list = new ArrayList<DynamicStylesFragmentContainer>();
    protected static int  count = 0;
    private int localID;

    //when MeasurementInfoFragment is destroyed, count is reset to 0
    public static void destroyed() { count = 0; list.clear(); }
    public static ArrayList<DynamicStylesFragmentContainer> getList(){ return list; }
    public int getLocalID(){ return localID; }

    public DynamicStylesFragmentContainer(){
        localID = count;
        count++;
        //list.add(this);
    }

    /*
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_styles, container, false);


        //DELETING A DYNAMIC STYLES CONTAINER SUBCLASS FRAGMENT
        Button measure = view.findViewById(R.id.button);
        //view.setOnLongClickListener(new View.OnLongClickListener(){
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.size() > 1) {
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
            }
        });
        return view;
    }
    */
}
