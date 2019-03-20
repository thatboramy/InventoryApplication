package com.example.inventoryapplication;


import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HatAdapter extends RecyclerView.Adapter<HatAdapter.ViewHolder> {

    Context mcontext;
    Cursor mcursor;
    private View.OnClickListener mOnItemClickListener;
    //UserProvider user = new
    //IUserProvider mockUser = new MockUserProvider();
    //ArrayList<String> mockNames = mockUser.getAllNames();

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    public HatAdapter(Context context, Cursor cursor) {
        mcontext = context;
        mcursor = cursor;
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
        return mcursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView hatName;
        public TextView hatStatus;

        public ViewHolder(final View itemView, int i) {
            super(itemView);
            final int temppos = i;
            hatName = (TextView) itemView.findViewById(R.id.textView_title);
            hatStatus = (TextView) itemView.findViewById(R.id.textView_status);

            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        mcursor.moveToPosition(i);
        //myViewHolder.shirttextView.setText(Shirt.shirts[i].name);
        //myViewHolder.colortextView.setText(Shirt.shirts[i].color);
        //holder.bindCursor(mcursor);
        String currHatName = mcursor.getString(1);
        String currStatus = mcursor.getString(3);
        holder.hatName.setText(currHatName);

        int userID = new Random().nextInt(2);

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
        };


    }
}
