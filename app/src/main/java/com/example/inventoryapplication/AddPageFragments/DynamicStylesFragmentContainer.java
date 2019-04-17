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
    private static ArrayList<DynamicStylesFragmentContainer> list = new ArrayList<DynamicStylesFragmentContainer>();
    private static int requiredFragments = 1;
    private static FragmentManager fragmentManager;
    private static FragmentTransaction fragmentTransaction;

    protected static int  count = 0;
    protected int localID;
    protected static int getListSize(){ return list.size(); }
    protected int getRequiredFragments(){ return requiredFragments; }
    protected int getLocalID(){ return localID; }
    protected boolean required = false;

    //public static ArrayList<DynamicStylesFragmentContainer> getList(){ return list; }
    //when MeasurementInfoFragment is destroyed, count is reset to 0
    public static void destroyed() { count = 0; list.clear(); }

    public DynamicStylesFragmentContainer(){
        localID = count;
        count++;
    }



    protected void add (DynamicStylesFragmentContainer fragment){
        list.add(fragment);
    }

    protected void remove(){
        String tag = "dynamic: " + localID;
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment removeFrag = fragmentManager.findFragmentByTag(tag);
        fragmentTransaction.remove(removeFrag);
        fragmentTransaction.commit();
        //remove fragment from list
        for(int i = 0; i < list.size(); i++){
            if(!required && localID == list.get(i).localID)
                list.remove(i);
        }
    }

    public abstract void setName(String test);
}
