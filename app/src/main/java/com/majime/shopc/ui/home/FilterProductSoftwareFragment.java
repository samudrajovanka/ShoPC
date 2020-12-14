package com.majime.shopc.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.ProductAdapter;

public class FilterProductSoftwareFragment extends Fragment {
    String[] productCategory = {
            "According to", "all known laws", "of aviation", "there is no",
            "way a bee", "should be able", "to fly. its", "wings are too"
    };
    int[] productImage = {
            R.drawable.ic_home, R.drawable.logo, R.drawable.ic_home, R.drawable.logo,
            R.drawable.logo, R.drawable.ic_home, R.drawable.logo, R.drawable.logo
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter_product_software, container, false);
        initiateUi(view);

        return view;
    }

    private void initiateUi(View view) {
        //final MaterialTextView all = view.findViewById(R.id.sortbtn_sw_all);
        //final MaterialTextView os = view.findViewById(R.id.sortbtn_os);
        //final MaterialTextView games = view.findViewById(R.id.sortbtn_games);
        //final MaterialTextView antivirus = view.findViewById(R.id.sortbtn_antivirus);
        //GridView gridview = view.findViewById(R.id.gv_filter_product_software);
        //com.majime.shopc.adapter.ProductAdapter productAdapter = new ProductAdapter(productCategory,
        //        productName, productImage, productPrice, productRating, getActivity());
        //
        //gridview.setAdapter(productAdapter);
        //gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //    @Override
        //    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //        //  Untuk masuk ke detail product
        //        /*
        //        String selectedName = productName[i];
        //        int selectedImage = productImage[i];
        //        startActivity(new Intent(MainActivity.this,ClickedItemActivity.class).putExtra("name",selectedName).putExtra("image",selectedImage));
        //        */
        //
        //        Toast.makeText(getActivity(), "Item " + i + " clicked.", Toast.LENGTH_SHORT).show();
        //    }
        //});
        //
        //all.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Toast.makeText(getActivity(), "Category: All", Toast.LENGTH_SHORT).show();
        //        all.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        //        os.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        games.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        antivirus.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //    }
        //});
        //
        //os.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Toast.makeText(getActivity(), "Category: Operating System", Toast.LENGTH_SHORT).show();
        //        all.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        os.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        //        games.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        antivirus.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //    }
        //});
        //
        //games.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Toast.makeText(getActivity(), "Category: Games", Toast.LENGTH_SHORT).show();
        //        all.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        os.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        games.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        //        antivirus.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //    }
        //});
        //
        //antivirus.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Toast.makeText(getActivity(), "Category: Antivirus", Toast.LENGTH_SHORT).show();
        //        all.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        os.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //        games.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        //        antivirus.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));
        //    }
        //});

    }
}