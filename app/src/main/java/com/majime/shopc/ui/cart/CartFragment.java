package com.majime.shopc.ui.cart;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.majime.shopc.utils.ItemOffsetDecoration;

public class CartFragment extends Fragment implements View.OnClickListener {

    private RecyclerView rvCartItems;
    private MaterialTextView titleSubTotal;
    private Button btnPurchase;
    private ConstraintLayout containerNoItem;

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
        containerNoItem = view.findViewById(R.id.container_no_item_in_cart);

        titleSubTotal.setText(
                "Rp. " + ExtraFunc.convertPrice(Data.currentUser.getPriceCartProduct()));

        cekCart();
        showRecyclerView();

        btnPurchase.setOnClickListener(this);
    }

    private void cekCart() {
        if(Data.currentUser.getProductsOnCart().size() == 0) {
            containerNoItem.setVisibility(View.VISIBLE);
            rvCartItems.setVisibility(View.GONE);
        } else {
            containerNoItem.setVisibility(View.GONE);
            rvCartItems.setVisibility(View.VISIBLE);
        }
    }

    private void showRecyclerView() {
        rvCartItems.setHasFixedSize(true);
        rvCartItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        CartAdapter cartAdapter = new CartAdapter(Data.currentUser.getProductsOnCart(),
                                                  titleSubTotal,
                                                  btnPurchase
        );
        ItemOffsetDecoration itemDecoration =
                new ItemOffsetDecoration(getActivity(), R.dimen.zero, R.dimen.small_to_normal, R.dimen.zero, R.dimen.zero, "first");
        rvCartItems.addItemDecoration(itemDecoration);
        rvCartItems.setAdapter(cartAdapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_cart_purchase:
                getActivity().startActivity(new Intent(getContext(), PaymentActivity.class));
                break;
        }
    }

}