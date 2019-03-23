package com.example.inventoryapplication.Adapter;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inventoryapplication.Provider.Hat;
import com.example.inventoryapplication.Provider.HatDataInjector;
import com.example.inventoryapplication.Provider.UserDataInjector;
import com.example.inventoryapplication.R;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HatAdapter extends RecyclerView.Adapter<HatAdapter.ViewHolder> {

    Context mcontext;
    private View.OnClickListener mOnItemClickListener;
    UserDataInjector mockUser = new UserDataInjector();
    ArrayList<String> mockNames = mockUser.getAllNames();

    HatDataInjector mockHat = new HatDataInjector();
    ArrayList<Hat> mockHatList = mockHat.getAllData();

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    public HatAdapter(Context context) {
        mcontext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, i);
        return viewHolder;
    }


    @Override
    public int getItemCount() {
        return mockHatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView hatName;
        public TextView hatStatus;
        public TextView userName;

        public ViewHolder(final View itemView, int i) {
            super(itemView);
            final int temppos = i;
            hatName =itemView.findViewById(R.id.textView_title);
            hatStatus =itemView.findViewById(R.id.textView_status);
            userName =itemView.findViewById(R.id.textView_user);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        String currHatName = mockHatList.get(i).getName();
        String currStatus = mockHatList.get(i).getStatus();
        holder.hatName.setText(currHatName);

        int userID = new Random().nextInt(2);
        String tempUserName = mockNames.get(userID);
        holder.userName.setText(tempUserName);

        Resources res = mcontext.getResources();
        int color;
        switch (currStatus){
            case "SOLD":
                holder.hatStatus.setText(currStatus);
                color = ResourcesCompat.getColor(res, R.color.color_status_Sold, null);
                holder.hatStatus.setTextColor(color);
                break;
            case "UNLISTED":
                holder.hatStatus.setText(currStatus);
                color = ResourcesCompat.getColor(res, R.color.color_status_Unlisted, null);
                holder.hatStatus.setTextColor(color);
                break;
            case "LISTED":
                holder.hatStatus.setText(currStatus);
                color = ResourcesCompat.getColor(res, R.color.color_status_Posted, null);
                holder.hatStatus.setTextColor(color);
                break;
            default:
                holder.hatStatus.setText(currStatus);
                color = ResourcesCompat.getColor(res, R.color.color_status_Unlisted, null);
                holder.hatStatus.setTextColor(color);
                break;
        }


    }
}
