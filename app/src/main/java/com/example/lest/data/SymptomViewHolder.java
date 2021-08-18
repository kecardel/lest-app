package com.example.lest.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lest.R;

import java.util.Date;

class SymptomViewHolder extends RecyclerView.ViewHolder {
    private final TextView symptomDateItemView;
    private final TextView symptomItemView;

    private SymptomViewHolder(View itemView) {
        super(itemView);
        symptomDateItemView = itemView.findViewById(R.id.textView);

        symptomItemView = itemView.findViewById(R.id.textView2);

    }

    public void bind(Date date) {
        symptomDateItemView.setText(date.toString());
    }

    public void bind(String symptom) {
        symptomItemView.setText(symptom);
    }

    static SymptomViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new SymptomViewHolder(view);
    }
}

