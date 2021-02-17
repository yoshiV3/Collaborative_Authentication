package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;


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
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;


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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection, parent, false);
        return new CustomWeightListViewAdapter.ViewHolder(view);
    }



    public void addItemList(ArrayList<Possibility> items)
    {
        int insertedItemCount         = items.size();
        int positionFirstInsertedItem = this.items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(positionFirstInsertedItem, insertedItemCount);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int positionRecyclerView = position;
        holder.getTextView().setText(this.items.get(position).getName());
        holder.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int newWeight = position +1;
                items.get(positionRecyclerView).setWeight(newWeight);
                holder.currentSelected.setText(String.valueOf(newWeight));
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
        private  final TextView currentSelected;
        private  final Spinner spinner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView          = (TextView) itemView.findViewById(R.id.textSelectionItem);
            this.spinner           = (Spinner)  itemView.findViewById(R.id.weights);
            this.currentSelected   = (TextView) itemView.findViewById(R.id.textCurrentSelected);


            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(itemView.getContext(),
                    R.array.possible_weigths, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            currentSelected.setText(String.valueOf(1));
        }

        public TextView getTextView()
        {
            return this.textView;
        }

        public TextView getCurrentSelected() {
            return currentSelected;
        }

        public Spinner getSpinner() {
            return spinner;
        }
    }

}
