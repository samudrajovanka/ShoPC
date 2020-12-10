package com.majime.shopc.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.ProductAdapter;

public class HomeFragment extends Fragment {

    //  Dummy data
    String[] productCategory = {
            "According to", "all known laws", "of aviation", "there is no",
            "way a bee", "should be able", "to fly. its", "wings are too"
    };
    int[] productImage = {
            R.drawable.ic_processor, R.drawable.logo, R.drawable.ic_processor, R.drawable.logo,
            R.drawable.logo, R.drawable.ic_processor, R.drawable.logo, R.drawable.logo
    };
    String[] productName = {
            "Intel Core i1", "Intel Core i2", "Intel Core i3", "Intel Core i4",
            "Intel Core i5", "Intel Core i6", "Intel Core i7", "Intel Core i8"
    };
    String[] productPrice = {
            "Rp 5.841.000", "Rp 420.069", "Rp 1.337.808", "Rp 1.488.088",
            "Rp 6.696.000", "$ 500", "gratis", "Rp 1.234.567"
    };
    int[] productRating = {
            4, 5, 2, 4, 5, 4, 3, 4
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initiateUi(view);

        return view;
    }

    private void initiateUi(View view) {
        ImageButton btnBack = view.findViewById(R.id.btn_back_toolbar);
        ImageView ivLogoToolbar = view.findViewById(R.id.iv_logo_toolbar);
        MaterialTextView titleToolbar = view.findViewById(R.id.tv_toolbar);

        GridView gridView = view.findViewById(R.id.gv_dashboard_best_seller);
        ImageButton btnCategoryHardware = view.findViewById(R.id.btn_dashboard_category_hardware);
        ImageButton btnCategorySoftware = view.findViewById(R.id.btn_dashboard_category_software);
        ImageView ivRating1 = view.findViewById(R.id.iv_rating_star_1);
        ImageView ivRating2 = view.findViewById(R.id.iv_rating_star_2);
        ImageView ivRating3 = view.findViewById(R.id.iv_rating_star_3);
        ImageView ivRating4 = view.findViewById(R.id.iv_rating_star_4);
        ImageView ivRating5 = view.findViewById(R.id.iv_rating_star_5);

        // mengubah btn back menjadi logo pada toolbar
        btnBack.setVisibility(View.INVISIBLE);
        ivLogoToolbar.setVisibility(View.VISIBLE);

        // mengubah text pada toolbar
        titleToolbar.setText(getString(R.string.app_name));

        //  Navigasi ke kategori hardware / software
        btnCategoryHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Category: Hardware", Toast.LENGTH_SHORT).show();
            }
        });
        btnCategorySoftware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Category: Software", Toast.LENGTH_SHORT).show();
            }
        });

        //  Grid view best seller
        ProductAdapter productAdapter = new ProductAdapter(productCategory, productName, productImage, productPrice, productRating, getActivity());
        gridView.setAdapter(productAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //  Untuk masuk ke detail product
                /*
                String selectedName = productName[i];
                int selectedImage = productImage[i];
                startActivity(new Intent(MainActivity.this,ClickedItemActivity.class).putExtra("name",selectedName).putExtra("image",selectedImage));
                */

                Toast.makeText(getActivity(), "Item " + i + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}