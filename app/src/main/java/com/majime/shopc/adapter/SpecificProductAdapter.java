package com.majime.shopc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.majime.shopc.R;

import java.util.ArrayList;

public class SpecificProductAdapter extends RecyclerView.Adapter<SpecificProductAdapter.SpecificProductHolder> {

    ArrayList<String> title, value;

    public SpecificProductAdapter(ArrayList<String> title, ArrayList<String> value) {
        this.title = title;
        this.value = value;
    }

    @NonNull
    @Override
    public SpecificProductAdapter.SpecificProductHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_specific_product, parent, false);
        return new SpecificProductAdapter.SpecificProductHolder((view));
    }

    @Override
    public void onBindViewHolder(
            @NonNull SpecificProductAdapter.SpecificProductHolder holder, int position
    ) {
        holder.bind(title.get(position), value.get(position));
    }

    @Override
    public int getItemCount() {
        return this.title.size();
    }

    public class SpecificProductHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvValue;

        public SpecificProductHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_specific_product);
            tvValue = itemView.findViewById(R.id.tv_value_specific);
        }

        void bind(String title, String value) {
            tvTitle.setText(title);
            tvValue.setText(value);
        }

    }

}
