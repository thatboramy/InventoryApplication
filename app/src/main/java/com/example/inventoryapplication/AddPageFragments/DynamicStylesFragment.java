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
    public static void destroyed() { count = 0;}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_styles, container, false);
        EditText input = view.findViewById(R.id.editTextMeasurementInput);

        //DELETING A DYNAMIC FRAGMENT
        //view.setOnLongClickListener(new View.OnLongClickListener(){
        input.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Toast.makeText(getContext(), "ID: " + count, Toast.LENGTH_SHORT).show();
                if(list.size() > 1) {
                    String output = "removed fragment: " + localID
                                + "\ncount is now " + (count-1);
                    Toast.makeText(getActivity(), output, Toast.LENGTH_SHORT).show();
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
        localID = count;
        count++;
        list.add(this);
        String output = "ID: " + localID
                + "\nCount: "  + count;
        Toast.makeText(getContext(), output , Toast.LENGTH_SHORT).show();
    }

    /*
    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Toast.makeText(getContext(), "Fragment attached", Toast.LENGTH_SHORT).show();
        localID = count;
        count++;
        list.add(this);
    }
    */
}
