package com.nikovarchapet.cinema.cinema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    private RecyclerView recyclerView;
    private List<Film> data;
    private Context context;

    public SimpleAdapter(Context context,List<Film> data) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        viewHolder.name.setText(data.get(viewHolder.getAdapterPosition()).name);
        viewHolder.image.setImageURI((Uri.parse(data.get(viewHolder.getAdapterPosition()).imageUri)));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SeansListActivity.class);
                intent.putExtra("Film", data.get(viewHolder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout item;
        public TextView name;
        public  ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.desc);

        }
    }
}
