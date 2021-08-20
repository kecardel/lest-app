package com.example.lest.data;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class SymptomListAdapter extends ListAdapter<Symptom, SymptomViewHolder> {

    public SymptomListAdapter(@NonNull DiffUtil.ItemCallback<Symptom> diffCallback) {
        super(diffCallback);
    }

    @Override
    public SymptomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return SymptomViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(SymptomViewHolder holder, int position) {
        Symptom current = getItem(position);
        holder.bind(current.getSymptomDate(),(current.getSymptomString()));
    }

    public static class SymptomDiff extends DiffUtil.ItemCallback<Symptom> {

        @Override
        public boolean areItemsTheSame(@NonNull Symptom oldItem, @NonNull Symptom newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Symptom oldItem, @NonNull Symptom newItem) {
            return oldItem.getSymptomDate().equals(newItem.getSymptomDate());
        }
    }
}
