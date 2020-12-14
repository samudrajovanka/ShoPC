package com.majime.shopc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.majime.shopc.R;
import com.majime.shopc.model.Product;
import com.majime.shopc.utils.ExtraFunc;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<Product> products;
    private Context context;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.bind(products.get(position), position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategory, tvName, tvPrice;
        ImageView imageView, ivRating2, ivRating3, ivRating4, ivRating5;
        View itemView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvCategory = itemView.findViewById(R.id.tv_product_category);
            imageView = itemView.findViewById(R.id.iv_product_photo);
            tvName = itemView.findViewById(R.id.tv_product_name);
            tvPrice = itemView.findViewById(R.id.tv_product_price);
            ivRating2 = itemView.findViewById(R.id.iv_rating_star_2);
            ivRating3 = itemView.findViewById(R.id.iv_rating_star_3);
            ivRating4 = itemView.findViewById(R.id.iv_rating_star_4);
            ivRating5 = itemView.findViewById(R.id.iv_rating_star_5);
        }

        void bind(Product product, int position) {
            tvCategory.setText(product.getClass().getSimpleName());
            imageView.setImageResource(product.getPhoto());
            tvName.setText(product.getName());
            tvPrice.setText("Rp. " + ExtraFunc.convertPrice((product.getPrice())));


            switch(product.getRating()) {
                case 1:
                    ivRating5.setVisibility(View.GONE);
                    ivRating4.setVisibility(View.GONE);
                    ivRating3.setVisibility(View.GONE);
                    ivRating2.setVisibility(View.GONE);
                    break;
                case 2:
                    ivRating5.setVisibility(View.GONE);
                    ivRating4.setVisibility(View.GONE);
                    ivRating3.setVisibility(View.GONE);
                    break;
                case 3:
                    ivRating5.setVisibility(View.GONE);
                    ivRating4.setVisibility(View.GONE);
                    break;
                case 4:
                    ivRating5.setVisibility(View.GONE);
                    break;
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Test " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

}