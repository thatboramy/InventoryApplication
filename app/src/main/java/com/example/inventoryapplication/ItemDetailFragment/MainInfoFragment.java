package com.example.inventoryapplication.ItemDetailFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inventoryapplication.R;

public class MainInfoFragment extends Fragment {

    View currentview;
    TextView itemName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        currentview = inflater.inflate(R.layout.fragment_detail_main_info, container, false);
        if(getArguments() != null) {
            itemName = currentview.findViewById(R.id.textView_item_title);
            itemName.setText(getArguments().getString("name"));
        }
        return currentview;
    }

    public View getCurrentview(){
        return currentview;
    }


}
