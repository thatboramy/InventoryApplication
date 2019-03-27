package com.example.inventoryapplication.AddPageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.inventoryapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFunctionsFragment extends Fragment{
    View currentView;
    boolean minimized = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentView = inflater.inflate(R.layout.fragment_test_functions, container, false);
        Button save_button = currentView.findViewById(R.id.button_save);

        //section is open and saved button is not clicked causing it to be minimized
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minimize();
                minimized = true;
            }
        });
        //if section is minimized, maximize to show contents in fragment
        currentView.setOnClickListener(new ViewGroup.OnClickListener(){
            @Override
            public void onClick(View v){
                if(minimized){
                    maximize();
                    minimized = false;
                }
            }
        });
        return currentView;
    }

    private void minimize() {
        TextView input1 = currentView.findViewById(R.id.textView_itemName);
        input1.setVisibility(View.GONE);
        TextView input2 = currentView.findViewById(R.id.textView_itemColor);
        input2.setVisibility(View.GONE);
        Button saveB = currentView.findViewById(R.id.button_save);
        saveB.setVisibility(View.GONE);

        View bar = currentView.findViewById(R.id.bar);
        bar.setVisibility(View.GONE);
    }

    private void maximize() {
        TextView input1 = currentView.findViewById(R.id.textView_itemName);
        input1.setVisibility(View.VISIBLE);
        TextView input2 = currentView.findViewById(R.id.textView_itemColor);
        input2.setVisibility(View.VISIBLE);
        Button saveB = currentView.findViewById(R.id.button_save);
        saveB.setVisibility(View.VISIBLE);

        View bar = currentView.findViewById(R.id.bar);
        bar.setVisibility(View.VISIBLE);
    }

}
