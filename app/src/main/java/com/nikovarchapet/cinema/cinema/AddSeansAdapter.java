package com.nikovarchapet.cinema.cinema;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;


public class AddSeansAdapter extends RecyclerView.Adapter<AddSeansAdapter.ViewHolder> {

    private List<Seans> seans;


    public AddSeansAdapter(List<Seans> seans) {
        this.seans = seans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_view_add_seans, viewGroup, false);
        return new AddSeansAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.spinner.setText("Hall: " + seans.get(viewHolder.getAdapterPosition()).hall.name);
        viewHolder.time.setText("Time: " + seans.get(viewHolder.getAdapterPosition()).date);
        viewHolder.price.setText("Price: " + seans.get(viewHolder.getAdapterPosition()).price);
    }


    @Override
    public int getItemCount() {
        return seans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView spinner;
        TextView time;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            spinner = itemView.findViewById(R.id.recyclerViewSpinner);
            time = itemView.findViewById(R.id.recyclerViewTime);
            price = itemView.findViewById(R.id.recyclerViewPrice);

        }
    }
}
