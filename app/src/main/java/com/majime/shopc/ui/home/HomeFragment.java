package com.majime.shopc.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.majime.shopc.data.Data;
import com.majime.shopc.utils.ItemOffsetDecoration;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private RecyclerView rvBestSeller;

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
        ImageButton btnCategoryHardware = view.findViewById(R.id.btn_dashboard_category_hardware);
        ImageButton btnCategorySoftware = view.findViewById(R.id.btn_dashboard_category_software);
        rvBestSeller = view.findViewById(R.id.rv_dashboard_best_seller);

        // set toolbar
        btnBack.setVisibility(View.INVISIBLE);
        ivLogoToolbar.setVisibility(View.VISIBLE);
        titleToolbar.setText(getString(R.string.app_name));

        showGridView();

        //  Navigasi ke kategori hardware / software
        btnCategoryHardware.setOnClickListener(this);
        btnCategorySoftware.setOnClickListener(this);
    }

    private void showGridView() {
        rvBestSeller.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), Data.store.getProductsBestSeller());
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.normal);
        rvBestSeller.addItemDecoration(itemDecoration);
        rvBestSeller.setAdapter(productAdapter);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_dashboard_category_hardware:
                Toast.makeText(getActivity(), "Category: Hardware", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_dashboard_category_software:
                Toast.makeText(getActivity(), "Category: Software", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}