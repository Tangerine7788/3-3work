package com.geektech.a3_3work;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<NotesModel> list = new ArrayList<>();
    public void deleteNote(int position){
        list.remove(position);
        notifyDataSetChanged();
    }

    public void addNote(NotesModel model) {
        this.list.add(model);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new NotesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDescription.setText(list.get(position).getDescription());
        holder.txtDate.setText(list.get(position).getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String title = list.get(holder.getAdapterPosition()).getTitle();
                String description = list.get(holder.getAdapterPosition()).getDescription();
                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putInt("position", holder.getAdapterPosition());
                bundle.putString("description", description);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDescription, txtDate;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.tv_item_title);
            txtDescription = itemView.findViewById(R.id.tv_item_description);
            txtDate = itemView.findViewById(R.id.tv_item_date);


        }
    }

}

