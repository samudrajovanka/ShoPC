package com.majime.shopc.ui.delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.ProductFixAdapter;
import com.majime.shopc.data.Data;
import com.majime.shopc.utils.ItemOffsetDecoration;

public class DeliveryActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvProduct;
    private ConstraintLayout containerNoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        initiateUi();
    }

    private void initiateUi() {
        MaterialTextView titleToolbar = findViewById(R.id.tv_toolbar);
        ImageButton btnBack = findViewById(R.id.btn_back_toolbar);
        rvProduct = findViewById(R.id.rv_on_delivery_product);
        containerNoItem = findViewById(R.id.container_no_item_in_delivery);

        titleToolbar.setText(getString(R.string.product_on_delivery_title));

        cekDelivery();
        showRecyclerProduct();

        btnBack.setOnClickListener(this);
    }

    private void cekDelivery() {
        if(Data.currentUser.getWaitingListProducts().size() == 0) {
            containerNoItem.setVisibility(View.VISIBLE);
            rvProduct.setVisibility(View.GONE);
        } else {
            containerNoItem.setVisibility(View.GONE);
            rvProduct.setVisibility(View.VISIBLE);
        }
    }

    private void showRecyclerProduct() {
        rvProduct.setHasFixedSize(true);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        ProductFixAdapter productPaymentAdapter =
                new ProductFixAdapter(Data.currentUser.getWaitingListProducts());
        ItemOffsetDecoration itemDecoration =
                new ItemOffsetDecoration(this, R.dimen.zero, R.dimen.small_to_normal, R.dimen.zero, R.dimen.zero, "first");
        rvProduct.addItemDecoration(itemDecoration);
        rvProduct.setAdapter(productPaymentAdapter);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_back_toolbar:
                onBackPressed();
                break;
        }
    }

}