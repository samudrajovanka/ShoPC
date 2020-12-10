package com.majime.shopc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.majime.shopc.R;

public class ProductAdapter extends BaseAdapter {
    private String[] productCategory;
    private int[] productImage;
    private String[] productName;
    private String[] productPrice;
    private int[] productRating;
    private Context context;
    private LayoutInflater layoutInflater;

    public int[] getProductRating() {
        return productRating;
    }

    public void setProductRating(int[] productRating) {
        this.productRating = productRating;
    }

    public String[] getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String[] productCategory) {
        this.productCategory = productCategory;
    }

    public int[] getProductImage() {
        return productImage;
    }

    public void setProductImage(int[] productImage) {
        this.productImage = productImage;
    }

    public String[] getProductName() {
        return productName;
    }

    public void setProductName(String[] productName) {
        this.productName = productName;
    }

    public String[] getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String[] productPrice) {
        this.productPrice = productPrice;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public ProductAdapter(String[] productCategory, String[] productName, int[] productImage, String[] productPrice, int[] productRating, Context context) {
        this.productName = productName;
        this.productImage = productImage;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return productImage.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_product, viewGroup, false);
        }
        TextView tvCategory = view.findViewById(R.id.tv_product_category);
        ImageView imageView = view.findViewById(R.id.iv_product_photo);
        TextView tvName = view.findViewById(R.id.tv_product_name);
        TextView tvPrice = view.findViewById(R.id.tv_product_price);
        ImageView ivRating1 = view.findViewById(R.id.iv_rating_star_1);
        ImageView ivRating2 = view.findViewById(R.id.iv_rating_star_2);
        ImageView ivRating3 = view.findViewById(R.id.iv_rating_star_3);
        ImageView ivRating4 = view.findViewById(R.id.iv_rating_star_4);
        ImageView ivRating5 = view.findViewById(R.id.iv_rating_star_5);

        tvCategory.setText(productCategory[i]);
        imageView.setImageResource(productImage[i]);
        tvName.setText(productName[i]);
        tvPrice.setText(productPrice[i]);

        if (productRating[i] == 1) {
            ivRating5.setVisibility(View.GONE);
            ivRating4.setVisibility(View.GONE);
            ivRating3.setVisibility(View.GONE);
            ivRating2.setVisibility(View.GONE);
        } else if (productRating[i] == 2) {
            ivRating5.setVisibility(View.GONE);
            ivRating4.setVisibility(View.GONE);
            ivRating3.setVisibility(View.GONE);
        } else if (productRating[i] == 3) {
            ivRating5.setVisibility(View.GONE);
            ivRating4.setVisibility(View.GONE);
        } else if (productRating[i] == 4) {
            ivRating5.setVisibility(View.GONE);
        }

        return view;
    }
}
