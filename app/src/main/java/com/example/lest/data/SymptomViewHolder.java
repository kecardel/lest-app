package com.example.lest.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lest.R;

class SymptomViewHolder extends RecyclerView.ViewHolder {
    private final TextView symptomItemView;

    private SymptomViewHolder(View itemView) {
        super(itemView);
        symptomItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        symptomItemView.setText(text);
    }

    static SymptomViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new SymptomViewHolder(view);
    }
}

