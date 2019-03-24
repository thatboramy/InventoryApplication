package com.example.inventoryapplication.ItemDetailFragment;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inventoryapplication.R;

public class MainInfoFragment extends Fragment {

    View currentview;
    TextView itemName,statusName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        currentview = inflater.inflate(R.layout.fragment_detail_main_info, container, false);
        if(getArguments() != null) {
            itemName = currentview.findViewById(R.id.textView_item_title);
            itemName.setText(getArguments().getString("name"));
            setStatus(getArguments().getString("status"));
        }
        return currentview;
    }

    private void setStatus(String status){
        statusName = currentview.findViewById(R.id.fragment_detail_textview_status);
        Resources res = getResources();
        int color;

        switch (status){
            case "SOLD":
                color = ResourcesCompat.getColor(res, R.color.color_status_Sold, null);
                statusName.setText("SOLD");
                statusName.setTextColor(color);
                break;
            case "UNLISTED":
                color = ResourcesCompat.getColor(res, R.color.color_status_Unlisted, null);
                statusName.setText("UNLISTED");
                statusName.setTextColor(color);
                break;
            case "LISTED":
                color = ResourcesCompat.getColor(res, R.color.color_status_Posted, null);
                statusName.setText("LISTED");
                statusName.setTextColor(color);
                break;
            default:
                color = ResourcesCompat.getColor(res, R.color.color_status_Unlisted, null);
                statusName.setText(status);
                statusName.setTextColor(color);
                break;
        }
    }
}
