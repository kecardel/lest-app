package com.example.lest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lest.data.SymptomListAdapter;
import com.example.lest.data.SymptomViewModel;


public class LogFragment extends Fragment {

    private SymptomViewModel mSymptomViewModel;

    public LogFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSymptomViewModel = new ViewModelProvider(this).get(SymptomViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_log, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final SymptomListAdapter adapter = new SymptomListAdapter(new SymptomListAdapter.SymptomDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mSymptomViewModel.getAllSymptoms().observe(getViewLifecycleOwner(), symptoms -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(symptoms);
        });

        return view;




    }
}