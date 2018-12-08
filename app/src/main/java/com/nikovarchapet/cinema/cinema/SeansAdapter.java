package com.nikovarchapet.cinema.cinema;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SeansAdapter extends RecyclerView.Adapter<SeansAdapter.ViewHolder>{
    List<Seans> seans;
    Context context;

    public SeansAdapter(Context context,List<Seans> seans) {
        this.seans = seans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_view_seans, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.hallName.setText( seans.get(viewHolder.getAdapterPosition()).hall.name );
        viewHolder.price.setText("price: " + seans.get(viewHolder.getAdapterPosition()).price);
        viewHolder.time.setText("Time: " + seans.get(viewHolder.getAdapterPosition()).date); ;
        viewHolder.reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HallActivity.class);
                intent.putExtra("Hall",seans.get(viewHolder.getAdapterPosition()).hall);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seans.size();
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
