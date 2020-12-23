package com.majime.shopc.ui.cart;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.CartAdapter;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.payment.PaymentActivity;
import com.majime.shopc.utils.ExtraFunc;

public class CartFragment extends Fragment implements View.OnClickListener {
    private RecyclerView rvCartItems;
    private MaterialTextView titleSubTotal;
    private Button btnPurchase;

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
        titleSubTotal = view.findViewById(R.id.tv_cart_sub_total);
        btnPurchase = view.findViewById(R.id.btn_cart_purchase);
        rvCartItems = view.findViewById(R.id.rv_cart_product);

        titleSubTotal.setText("Rp. "+ ExtraFunc.convertPrice(Data.currentUser.getPriceCartProduct()));

        showRecyclerView();

        btnPurchase.setOnClickListener(this);
    }

    private void showRecyclerView() {
        rvCartItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        CartAdapter cartAdapter = new CartAdapter(Data.currentUser.getWaitingCartProducts(), titleSubTotal, btnPurchase);
        //VerticalSpaceItemDecoration itemDecoration = new VerticalSpaceItemDecoration(16);
        //rvCartItems.addItemDecoration(itemDecoration);
        rvCartItems.setAdapter(cartAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cart_purchase:
                getActivity().startActivity(new Intent(getContext(), PaymentActivity.class));
                break;
        }
    }
}