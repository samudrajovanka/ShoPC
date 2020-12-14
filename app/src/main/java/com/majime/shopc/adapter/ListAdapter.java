package com.majime.shopc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.majime.shopc.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<String> list;
    private ArrayList<Boolean> isActive = new ArrayList<>();
    private ProductAdapter productAdapter;

    public ListAdapter(ArrayList<String> list, ProductAdapter productAdapter) {
        this.list = list;
        this.productAdapter = productAdapter;
        this.isActive.add(true);
        for(int i = 1; i < list.size(); i++) this.isActive.add(false);
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListAdapter.ListViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        holder.bind(list.get(position), position);

        if(isActive.get(position)) {
            holder.tvFilter.setBackgroundResource(R.drawable.bg_rect_primary_rad_10);
        } else {
            holder.tvFilter.setBackgroundResource(R.drawable.bg_rect_primary_50_rad_10);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvFilter;
        View itemView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.tvFilter = itemView.findViewById(R.id.tv_sort_btn_all);
        }

        public void bind(String filter, int i) {
            tvFilter.setText(filter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int j = 0; j < isActive.size(); j++) {
                        if(j == i) {
                            isActive.set(j, true);
                            continue;
                        }
                        isActive.set(j, false);
                    }
                    productAdapter.getFitler().filter(tvFilter.getText().toString());
                    notifyDataSetChanged();
                }
            });
        }

    }

}
