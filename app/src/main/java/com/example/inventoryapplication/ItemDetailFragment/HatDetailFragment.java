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
import android.widget.TextView;

import com.example.inventoryapplication.R;


public class HatDetailFragment extends Fragment {
    View currentView;
    TextView fragColor, fragBrand, fragMaterial, fragSize;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentView = inflater.inflate(R.layout.fragment_detail_hat, container, false);

        fragColor = currentView.findViewById(R.id.f_d_color);
        fragBrand = currentView.findViewById(R.id.f_d_brand);
        fragMaterial = currentView.findViewById(R.id.f_d_material);
        fragSize = currentView.findViewById(R.id.f_d_size);

        if(getArguments() != null) {
            fragColor.setText(getArguments().getString("color"));
            fragBrand.setText(getArguments().getString("brand"));
            fragSize.setText(getArguments().getString("size"));
            fragMaterial.setText(getArguments().getString("material"));
        }

        return currentView;
    }
}
