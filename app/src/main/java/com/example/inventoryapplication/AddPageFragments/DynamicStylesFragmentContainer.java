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
    protected int localID;

    //when MeasurementInfoFragment is destroyed, count is reset to 0
    public static void destroyed() { count = 0; list.clear(); }
    public static ArrayList<DynamicStylesFragmentContainer> getList(){ return list; }
    protected static int getListSize(){ return list.size(); }
    protected int getLocalID(){ return localID; }


    public DynamicStylesFragmentContainer(){
        localID = count;
        count++;
    }

    public void add (DynamicStylesFragmentContainer fragment){
        list.add(fragment);
    }
}
