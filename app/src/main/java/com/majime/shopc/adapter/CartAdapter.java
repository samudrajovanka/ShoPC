package com.majime.shopc.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.majime.shopc.R;
import com.majime.shopc.model.Product;
import com.majime.shopc.ui.product_detail.ProductDetailActivity;
import com.majime.shopc.utils.ExtraFunc;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<Product> products, productsFull;
    private Context context;

    public CartAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
        this.productsFull = new ArrayList<>(products);
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        holder.bind(products.get(position), position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategory, tvName, tvPrice, tvAmount;
        ImageView ivPhoto;
        Button btnIncrease, btnReduce;
        ImageButton btnDelete;
        View itemView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvCategory = itemView.findViewById(R.id.tv_cart_product_category);
            ivPhoto = itemView.findViewById(R.id.iv_cart_product_photo);
            tvName = itemView.findViewById(R.id.tv_cart_product_name);
            tvPrice = itemView.findViewById(R.id.tv_cart_product_price);
            tvAmount = itemView.findViewById(R.id.tv_cart_product_amount);
            btnDelete = itemView.findViewById(R.id.btn_cart_delete_product);
            btnIncrease = itemView.findViewById(R.id.btn_cart_increase_amount);
            btnReduce = itemView.findViewById(R.id.btn_cart_reduce_amount);
        }

        void bind(final Product product, int position) {
            String amount = "";
            int currentAmount = product.getAmount();
            amount = amount + currentAmount;

            tvCategory.setText(product.getClass().getSimpleName());
            ivPhoto.setImageResource(product.getPhoto());
            tvName.setText(product.getName());
            tvAmount.setText(amount);
            tvPrice.setText("Rp. " + ExtraFunc.convertPrice((product.getPrice())));

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                }
            });
            btnIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String amount = "";
                    int currentAmount = (product.getAmount() + 1);

                    if (currentAmount < 1) {
                        currentAmount = 1;
                    }

                    product.setAmount(currentAmount);
                    amount = amount + currentAmount;
                    tvAmount.setText(amount);
                }
            });
            btnReduce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String amount = "";
                    int currentAmount = (product.getAmount() - 1);

                    if (currentAmount < 1) {
                        currentAmount = 1;
                    }

                    product.setAmount(currentAmount);
                    amount = amount + currentAmount;
                    tvAmount.setText(amount);
                }
            });
        }

    }
}


