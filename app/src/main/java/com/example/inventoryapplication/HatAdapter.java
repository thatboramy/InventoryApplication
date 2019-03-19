package com.example.inventoryapplication;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HatAdapter extends RecyclerView.Adapter<HatAdapter.ViewHolder> {

    Context mcontext;
    Cursor mcursor;
    private View.OnClickListener mOnItemClickListener;

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

        public ViewHolder(final View itemView, int i) {
            super(itemView);
            final int temppos = i;
            hatName = (TextView) itemView.findViewById(R.id.textView_title);

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
        holder.hatName.setText(currHatName);
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mcursor.getString(1);
                Toast toast = Toast.makeText(mcontext, "Item Clicked: " + name, Toast.LENGTH_SHORT);
                toast.show();
            }
        });*/
    }
}
