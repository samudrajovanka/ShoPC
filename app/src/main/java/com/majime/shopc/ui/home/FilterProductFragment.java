package com.majime.shopc.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.ListAdapter;
import com.majime.shopc.adapter.ProductAdapter;
import com.majime.shopc.data.Data;
import com.majime.shopc.utils.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.Collections;

public class FilterProductFragment extends Fragment implements View.OnClickListener {

    public static final String key = "TITLE";
    private RecyclerView rvFilterProduct, rvListFilter;
    private String title;
    private ProductAdapter productAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter_product, container, false);
        initiateUi(view);

        return view;
    }

    private void initiateUi(View view) {
        ImageButton btnBack = view.findViewById(R.id.btn_back_toolbar);
        MaterialTextView titleToolbar = view.findViewById(R.id.tv_toolbar);
        rvFilterProduct = view.findViewById(R.id.rv_filter_product);
        rvListFilter = view.findViewById(R.id.rv_item_list);
        title = getArguments().getString(FilterProductFragment.key);

        // set toolbar
        titleToolbar.setText(title);
        showGridView();
        showRecylerViewList();

        btnBack.setOnClickListener(this);
    }

    private void showRecylerViewList() {
        ArrayList<String> list = new ArrayList<>();
        String[] componentHardware =
                getResources().getStringArray(R.array.component_product_hardware);
        String[] componentSoftware =
                getResources().getStringArray(R.array.component_product_software);
        list.add("All");

        if(title.equals(getString(R.string.title_hardware))) {
            Collections.addAll(list, componentHardware);
        } else {
            Collections.addAll(list, componentSoftware);
        }

        rvListFilter.setHasFixedSize(true);
        rvListFilter.setLayoutManager(new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        ));
        ListAdapter listAdapter = new ListAdapter(list, productAdapter);
        ItemOffsetDecoration itemDecoration =
                new ItemOffsetDecoration(getActivity(), R.dimen.normal, R.dimen.zero, R.dimen.zero, R.dimen.zero, "not first");
        rvListFilter.addItemDecoration(itemDecoration);
        rvListFilter.setAdapter(listAdapter);
    }

    private void showGridView() {
        rvFilterProduct.setHasFixedSize(true);
        rvFilterProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        productAdapter = new ProductAdapter(getActivity(), Data.store.getProductsByTitle(title));
        ItemOffsetDecoration itemDecoration =
                new ItemOffsetDecoration(getActivity(), R.dimen.normal, R.dimen.zero, R.dimen.zero, R.dimen.zero, "odd");
        rvFilterProduct.addItemDecoration(itemDecoration);
        rvFilterProduct.setAdapter(productAdapter);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_back_toolbar:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_fragment_main, new HomeFragment())
                        .commit();
                break;
        }
    }

}