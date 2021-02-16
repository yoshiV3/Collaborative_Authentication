package com.project.collaborativeauthentication.android.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;


import java.util.ArrayList;

public class CustomWeightListViewAdapter extends RecyclerView.Adapter<CustomWeightListViewAdapter.ViewHolder>
{


    private ArrayList<Possibility> items;

    public CustomWeightListViewAdapter(ArrayList<Possibility> items)
    {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_name, parent, false);
        return new CustomWeightListViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int positionRecyclerView = position;
        holder.getTextView().setText(this.items.get(position).getName());
        holder.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                items.get(positionRecyclerView).setWeight(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private  final TextView textView;
        private  final Spinner spinner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.textSelectionItem);
            this.spinner  = (Spinner)  itemView.findViewById(R.id.weigths);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(itemView.getContext(),
                    R.array.possible_weigths, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setTag("spinner");
        }

        public TextView getTextView()
        {
            return this.textView;
        }

        public Spinner getSpinner() {
            return spinner;
        }
    }

}
