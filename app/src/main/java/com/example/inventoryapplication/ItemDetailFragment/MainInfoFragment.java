package com.example.inventoryapplication.ItemDetailFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryapplication.R;

public class MainInfoFragment extends Fragment {

    View currentview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        currentview = inflater.inflate(R.layout.fragment_main_info, container, false);
        return inflater.inflate(R.layout.fragment_main_info, container, false);
    }

    public View getCurrentview(){
        return currentview;
    }


}