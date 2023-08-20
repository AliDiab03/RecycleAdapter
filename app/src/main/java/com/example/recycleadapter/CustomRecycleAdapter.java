package com.example.recycleadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.MyHolder> {
    Context context;
    ArrayList<Student> data;
    onIteamClickLisnear lisnear ;

    public CustomRecycleAdapter(Context context, ArrayList<Student> data , onIteamClickLisnear lisnear) {
        this.context = context;
        this.data = data;
        this.lisnear = lisnear ;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_recycle,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvName.setText(data.get(position).getName());
        holder.tvRate.setText(data.get(position).getRate()+"");
        holder.imgDelete.setImageResource(data.get(position).getImgDelete());
        holder.img.setImageResource(data.get(position).getImg());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              lisnear.onClicked(data.get(holder.getAdapterPosition()),holder.getAdapterPosition());
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              lisnear.onDeleteClick(holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }





    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRate;
        ImageView img;
        RelativeLayout container ;
        ImageView imgDelete ;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvRate = itemView.findViewById(R.id.tvRate);
            img = itemView.findViewById(R.id.imageStudent);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            container = itemView.findViewById(R.id.container);
        }
    }
    interface  onIteamClickLisnear{
        void onClicked(Student student,int position);
        void onDeleteClick(int position);
    }
}
