package com.majime.shopc.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.ProductAdapter;
import com.majime.shopc.data.Data;
import com.majime.shopc.utils.ItemOffsetDecoration;

public class HomeFragment extends Fragment implements View.OnClickListener {

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
        rvBestSeller.setHasFixedSize(true);
        rvBestSeller.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ProductAdapter productAdapter =
                new ProductAdapter(getActivity(), Data.store.getProductsBestSeller());
        ItemOffsetDecoration itemDecoration =
                new ItemOffsetDecoration(getActivity(), R.dimen.normal, true);
        rvBestSeller.addItemDecoration(itemDecoration);
        rvBestSeller.setAdapter(productAdapter);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_fragment_main, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_dashboard_category_hardware:
                Bundle bundleHardware = new Bundle();
                bundleHardware.putString(FilterProductFragment.key,
                                         getString(R.string.title_hardware)
                );
                Fragment fragmentHardware = new FilterProductFragment();
                fragmentHardware.setArguments(bundleHardware);
                loadFragment(fragmentHardware);
                break;
            case R.id.btn_dashboard_category_software:
                Bundle bundleSoftware = new Bundle();
                bundleSoftware.putString(FilterProductFragment.key,
                                         getString(R.string.title_software)
                );
                Fragment fragmentSoftware = new FilterProductFragment();
                fragmentSoftware.setArguments(bundleSoftware);
                loadFragment(fragmentSoftware);
                break;
        }
    }

}