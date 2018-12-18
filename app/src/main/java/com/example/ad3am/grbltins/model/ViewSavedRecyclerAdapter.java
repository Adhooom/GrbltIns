package com.example.ad3am.grbltins.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ad3am.grbltins.R;

import java.util.ArrayList;
import java.util.List;

public class ViewSavedRecyclerAdapter extends RecyclerView.Adapter<ViewSavedRecyclerAdapter.ViewHolder> {
    private ArrayList<NewInspectionFormPojo> date ;

    public ViewSavedRecyclerAdapter(ArrayList<NewInspectionFormPojo> names) {
        this.date = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_saved_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.wayName.setText(date.get(position).getWayName());
        holder.wayNumber.setText(date.get(position).getWayNum());
        holder.engName.setText(date.get(position).getEngName());
        holder.date.setText(date.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView wayName , wayNumber , engName ,date;
        public ViewHolder(View itemView) {
            super(itemView);
            wayName = itemView.findViewById(R.id.view_saved_row_text_wayName);
            wayNumber = itemView.findViewById(R.id.view_saved_row_text_wayNumber);
            engName = itemView.findViewById(R.id.view_saved_row_text_engName);
            date = itemView.findViewById(R.id.view_saved_row_text_date);
        }
    }
}
