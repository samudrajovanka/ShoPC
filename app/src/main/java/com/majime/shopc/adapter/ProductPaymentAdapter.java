package com.majime.shopc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.model.Product;
import com.majime.shopc.utils.ExtraFunc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ProductPaymentAdapter extends RecyclerView.Adapter<ProductPaymentAdapter.ProductPaymentHolder> {

    ArrayList<Product> products, productsSetArray;;

    public ProductPaymentAdapter(ArrayList<Product> products) {
        this.products = products;
        this.productsSetArray = new ArrayList<>(new HashSet<>(products));
    }

    @NonNull
    @Override
    public ProductPaymentAdapter.ProductPaymentHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_payment, parent, false);
        return new ProductPaymentAdapter.ProductPaymentHolder((view));
    }

    @Override
    public void onBindViewHolder(
            @NonNull ProductPaymentAdapter.ProductPaymentHolder holder, int position
    ) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return productsSetArray.size();
    }

    public class ProductPaymentHolder extends RecyclerView.ViewHolder {

        ImageView ivProduct;
        MaterialTextView tvNameProduct, tvComponentProduct, tvPrice, tvAmountBuy;
        int amount = 0;

        public ProductPaymentHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.iv_product_payment);
            tvNameProduct = itemView.findViewById(R.id.tv_name_product_payment);
            tvComponentProduct = itemView.findViewById(R.id.tv_component_product_payment);
            tvPrice = itemView.findViewById(R.id.tv_price_item_payment);
            tvAmountBuy = itemView.findViewById(R.id.tv_amount_product_buy);
        }

        void bind(Product product) {
            amount = Collections.frequency(products, product);

            ivProduct.setImageResource(product.getPhoto());
            tvNameProduct.setText(product.getName());
            tvComponentProduct.setText(product.getClass().getSimpleName());
            tvPrice.setText("Rp. " + ExtraFunc.convertPrice(product.getPrice()));
            tvAmountBuy.setText("x" + amount);
        }

    }

}
