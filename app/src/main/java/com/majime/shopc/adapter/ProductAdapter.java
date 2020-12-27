package com.majime.shopc.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.majime.shopc.R;
import com.majime.shopc.model.Antivirus;
import com.majime.shopc.model.Game;
import com.majime.shopc.model.Motherboard;
import com.majime.shopc.model.OperatingSystem;
import com.majime.shopc.model.Processor;
import com.majime.shopc.model.Product;
import com.majime.shopc.model.Ram;
import com.majime.shopc.model.Storage;
import com.majime.shopc.model.Vga;
import com.majime.shopc.ui.productDetail.ProductDetailActivity;
import com.majime.shopc.utils.ExtraFunc;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> products, productsFull;
    private Context context;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
        this.productsFull = new ArrayList<>(products);
    }

    private Filter productFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence chars) {
            ArrayList<Product> productsFilter = new ArrayList<>();

            if(chars == null || chars.length() == 0) {
                productsFilter.addAll(productsFull);
            } else {
                String filterPattern = chars.toString().toLowerCase().trim();

                for(Product product : productsFull) {
                    if(filterPattern.equals("all")) {
                        productsFilter.add(product);
                    } else if(filterPattern.equals("motherboard")) {
                        if(product instanceof Motherboard) {
                            productsFilter.add(product);
                        }
                    } else if(filterPattern.equals("processor")) {
                        if(product instanceof Processor) {
                            productsFilter.add(product);
                        }
                    } else if(filterPattern.equals("ram")) {
                        if(product instanceof Ram) {
                            productsFilter.add(product);
                        }
                    } else if(filterPattern.equals("vga")) {
                        if(product instanceof Vga) {
                            productsFilter.add(product);
                        }
                    } else if(filterPattern.equals("storage")) {
                        if(product instanceof Storage) {
                            productsFilter.add(product);
                        }
                    } else if(filterPattern.equals("operating system")) {
                        if(product instanceof OperatingSystem) {
                            productsFilter.add(product);
                        }
                    } else if(filterPattern.equals("games")) {
                        if(product instanceof Game) {
                            productsFilter.add(product);
                        }
                    } else if(filterPattern.equals("antivirus")) {
                        if(product instanceof Antivirus) {
                            productsFilter.add(product);
                        }
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = productsFilter;

            return results;
        }

        @Override
        protected void publishResults(
                CharSequence charSequence, FilterResults filterResults
        ) {
            ArrayList<Product> list = (ArrayList<Product>) filterResults.values;
            products.clear();
            products.addAll(list);

            notifyDataSetChanged();
        }
    };

    public Filter getFitler() {
        return this.productFilter;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategory, tvName, tvPrice;
        ImageView imageView, ivRating1, ivRating2, ivRating3, ivRating4, ivRating5;
        View itemView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvCategory = itemView.findViewById(R.id.tv_product_category);
            imageView = itemView.findViewById(R.id.iv_product_photo);
            tvName = itemView.findViewById(R.id.tv_product_name);
            tvPrice = itemView.findViewById(R.id.tv_product_price);
            ivRating1 = itemView.findViewById(R.id.iv_rating_star_1);
            ivRating2 = itemView.findViewById(R.id.iv_rating_star_2);
            ivRating3 = itemView.findViewById(R.id.iv_rating_star_3);
            ivRating4 = itemView.findViewById(R.id.iv_rating_star_4);
            ivRating5 = itemView.findViewById(R.id.iv_rating_star_5);
        }

        void bind(Product product) {
            tvCategory.setText(product.getClass().getSimpleName());
            imageView.setImageResource(product.getPhoto());
            tvName.setText(product.getName());
            tvPrice.setText("Rp. " + ExtraFunc.convertPrice((product.getPrice())));

            ExtraFunc.setStarRating(
                    product.getRating(),
                    ivRating1,
                    ivRating2,
                    ivRating3,
                    ivRating4,
                    ivRating5
            );

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProductDetailActivity.class);
                    intent.putExtra(ProductDetailActivity.key_name, product.getName());
                    context.startActivity(intent);
                }
            });
        }

    }

}