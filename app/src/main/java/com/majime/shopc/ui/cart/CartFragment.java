package com.majime.shopc.ui.cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.CartAdapter;
import com.majime.shopc.data.Data;
import com.majime.shopc.model.Product;
import com.majime.shopc.utils.ExtraFunc;
import com.majime.shopc.utils.ItemOffsetDecoration;
import com.majime.shopc.utils.VerticalSpaceItemDecoration;

import java.util.ArrayList;

public class CartFragment extends Fragment implements View.OnClickListener {
    private ArrayList<Product> products;
    private RecyclerView rvCartItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        initiateUi(view);

        return view;
    }

    private void initiateUi(View view) {
        MaterialTextView titleSubTotal = view.findViewById(R.id.tv_cart_sub_total);
        Button btnPurchase = view.findViewById(R.id.btn_cart_purchase);
        rvCartItems = view.findViewById(R.id.rv_cart_product);

        titleSubTotal.setText("Sub Total: Rp. " + ExtraFunc.convertPrice((0)));
        showRecyclerView();

        btnPurchase.setOnClickListener(this);
    }

    private void showRecyclerView() {
        rvCartItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        CartAdapter cartAdapter = new CartAdapter(getActivity(), Data.store.getProductsBestSeller());
        VerticalSpaceItemDecoration itemDecoration = new VerticalSpaceItemDecoration(16);
        rvCartItems.addItemDecoration(itemDecoration);
        rvCartItems.setAdapter(cartAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cart_purchase:
                Toast.makeText(getActivity(), "Payment Method", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}