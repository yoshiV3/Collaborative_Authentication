package com.project.collaborativeauthentication.android;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.collaborativeauthentication.R;


import java.util.ArrayList;

public class CustomItemListRecyclerViewAdapter extends RecyclerView.Adapter<CustomItemListRecyclerViewAdapter.ViewHolder>
{


    private ArrayList<String>    items;
    private View.OnClickListener listener;


    public CustomItemListRecyclerViewAdapter(ArrayList<String>  items)
    {
        this.items = items;
    }


    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    public String pop(int index)
    {
        String old = this.items.remove(index);
        notifyItemRemoved(index);
        //notifyItemRangeRemoved(index,1);
        return old;
    }

    public void add(String item)
    {
        this.items.add(item);
        notifyItemInserted(this.items.size()-1);
        //notifyItemRangeInserted(this.items.size()-1, 1);
    }

    public void addItemList(ArrayList<String> items)
    {
        int insertedItemCount         = items.size();
        int positionFirstInsertedItem = this.items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(positionFirstInsertedItem, insertedItemCount);
    }

    public ArrayList<String> getItems()
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
        holder.getTextView().setText(this.items.get(position));
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
