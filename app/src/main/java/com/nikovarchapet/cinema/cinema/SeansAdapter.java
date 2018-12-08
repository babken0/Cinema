package com.nikovarchapet.cinema.cinema;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SeansAdapter extends RecyclerView.Adapter<SeansAdapter.ViewHolder>{
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_view_seans, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hallName;
        Button reserveBtn;
        TextView price;
        TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hallName = itemView.findViewById(R.id.hallName);
            reserveBtn = itemView.findViewById(R.id.reserveBtn);
            price = itemView.findViewById(R.id.price);
            time = itemView.findViewById(R.id.time);
        }
    }
}
