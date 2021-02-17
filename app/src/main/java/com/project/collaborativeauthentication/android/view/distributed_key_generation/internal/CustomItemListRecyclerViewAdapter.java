package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;


import java.util.ArrayList;

public class CustomItemListRecyclerViewAdapter extends RecyclerView.Adapter<CustomItemListRecyclerViewAdapter.ViewHolder>
{


    private ArrayList<Possibility>    items;
    private View.OnClickListener      listener;


    public CustomItemListRecyclerViewAdapter(ArrayList<Possibility>  items)
    {
        this.items = items;
    }


    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    public Possibility pop(int index)
    {
        Possibility old = this.items.remove(index);
        notifyItemRemoved(index);
        return old;
    }

    public void add(Possibility item)
    {
        this.items.add(item);
        notifyItemInserted(this.items.size()-1);
    }

    public void addItemList(ArrayList<Possibility> items)
    {
        int insertedItemCount         = items.size();
        int positionFirstInsertedItem = this.items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(positionFirstInsertedItem, insertedItemCount);
    }

    public ArrayList<Possibility> getItems()
    {
        return new ArrayList<>(this.items);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_name, parent, false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.getTextView().setText(this.items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private  final TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.TextviewItem);
        }

        public TextView getTextView()
        {
            return this.textView;
        }
    }
}
