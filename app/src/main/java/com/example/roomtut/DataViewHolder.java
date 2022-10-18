package com.example.roomtut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private final TextView myTextView;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        myTextView = itemView.findViewById(R.id.textview);
    }

    public void bind(String text){
        myTextView.setText(text);
    }

    static DataViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_view,parent , false);
        return new DataViewHolder(view);
    }

}
