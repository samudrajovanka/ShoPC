package com.majime.shopc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.model.Product;
import com.majime.shopc.utils.ExtraFunc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<Product> products, productsSetArray;
    private MaterialTextView tvSubTotal;
    private Button btnPurchase;

    public CartAdapter(
            ArrayList<Product> products, MaterialTextView tvSubTotal, Button btnPurchase
    ) {
        this.products = products;
        this.productsSetArray = new ArrayList<>(new HashSet<>(products));
        this.tvSubTotal = tvSubTotal;
        this.btnPurchase = btnPurchase;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
    ) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        holder.bind(productsSetArray.get(position));
    }

    @Override
    public int getItemCount() {
        return productsSetArray.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvCategory, tvName, tvPrice, tvAmount;
        ImageView ivPhoto;
        Button btnIncrease, btnReduce;
        ImageButton btnDelete;
        int amount = 0;
        Product product;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tv_cart_product_category);
            ivPhoto = itemView.findViewById(R.id.iv_cart_product_photo);
            tvName = itemView.findViewById(R.id.tv_cart_product_name);
            tvPrice = itemView.findViewById(R.id.tv_cart_product_price);
            tvAmount = itemView.findViewById(R.id.tv_cart_product_amount);
            btnDelete = itemView.findViewById(R.id.btn_cart_delete_product);
            btnIncrease = itemView.findViewById(R.id.btn_cart_increase_amount);
            btnReduce = itemView.findViewById(R.id.btn_cart_reduce_amount);
        }

        void bind(final Product product) {
            this.product = product;
            amount = Collections.frequency(products, product);

            tvCategory.setText(product.getClass().getSimpleName());
            ivPhoto.setImageResource(product.getPhoto());
            tvName.setText(product.getName());
            tvAmount.setText(String.valueOf(amount));

            Product prod = Data.store.getProduct(this.product.getName());
            tvPrice.setText("Rp. " + ExtraFunc.convertPrice(prod.getPrice()));
            setButton();

            int amountOfProduct = Data.store.getProduct(this.product.getName()).getAmount();
            if(amount > amountOfProduct) {
                for(int i = 0; i < amount - amountOfProduct; i++) {
                    Data.currentUser.removeProductOnCart(this.product.getName());
                }
                productsSetArray.remove(product);
                updateSubTotal();
            }

            if(amount > 1) {
                btnReduce.setBackgroundResource(R.drawable.bg_rect_grey);
            } else {
                btnReduce.setBackgroundResource(R.drawable.bg_rect_grey_30);
            }

            if(amount < Data.store.getProduct(this.product.getName()).getAmount()) {
                btnIncrease.setBackgroundResource(R.drawable.bg_rect_grey);
            } else {
                btnIncrease.setBackgroundResource(R.drawable.bg_rect_grey_30);
            }

            btnDelete.setOnClickListener(this);
            btnIncrease.setOnClickListener(this);
            btnReduce.setOnClickListener(this);
        }

        private void setButton() {
            if(Data.currentUser.getProductsOnCart().size() > 0) {
                btnPurchase.setEnabled(true);
            } else {
                btnPurchase.setEnabled(false);
            }
        }

        private void updateSubTotal() {
            int priceProduct = Data.currentUser.getPriceCartProduct();
            tvSubTotal.setText("Rp. " + ExtraFunc.convertPrice(priceProduct));
            notifyDataSetChanged();
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btn_cart_delete_product:
                    for(int i = 0; i < amount; i++) {
                        Data.currentUser.removeProductOnCart(this.product.getName());
                    }
                    productsSetArray.remove(product);
                    updateSubTotal();
                    setButton();
                    break;
                case R.id.btn_cart_increase_amount:
                    if(amount < Data.store.getProduct(this.product.getName()).getAmount()) {
                        Data.currentUser.addProductOnCart(this.product);
                        updateSubTotal();
                    }
                    break;
                case R.id.btn_cart_reduce_amount:
                    if(amount > 1) {
                        Data.currentUser.removeProductOnCart(this.product.getName());
                        updateSubTotal();
                    }
                    setButton();
                    break;
            }
        }

    }

}


