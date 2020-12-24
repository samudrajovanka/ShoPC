package com.majime.shopc.ui.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.ProductPaymentAdapter;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.alert.AlertActivity;
import com.majime.shopc.utils.ExtraFunc;

public class PaymentActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    RecyclerView rvProduct;
    Spinner spinner;
    String address, debitId;
    String shipping = "JNE";
    Boolean isDebit = false;
    EditText etAddress, etDebitId;
    ConstraintLayout containerBtnCash, containerBtnDebit, containerDebitId;
    MaterialTextView tvTotalPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        initiateUi();
    }

    private void initiateUi() {
        MaterialTextView tvToolbar = findViewById(R.id.tv_toolbar);
        ImageView ivToolbar = findViewById(R.id.iv_logo_toolbar);
        ImageButton btnBack = findViewById(R.id.btn_back_toolbar);
        rvProduct = findViewById(R.id.rv_product_payment);
        spinner = findViewById(R.id.spinner_shipping_user_payment);
        MaterialTextView tvBtnPayment = findViewById(R.id.tv_btn_pay);
        etAddress = findViewById(R.id.et_address_user_payment);
        containerBtnCash = findViewById(R.id.container_btn_cash_payment);
        containerBtnDebit = findViewById(R.id.container_btn_debit_payment);
        containerDebitId = findViewById(R.id.container_debit_id_payment);
        etDebitId = findViewById(R.id.et_debit_id_payment);
        tvTotalPayment = findViewById(R.id.tv_total_payment);

        // set toolbar
        tvToolbar.setText(R.string.paymeny_title);
        ivToolbar.setVisibility(View.GONE);
        btnBack.setVisibility(View.VISIBLE);

        etAddress.setText(Data.currentUser.getAddress());

        btnBack.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);
        containerBtnCash.setOnClickListener(this);
        containerBtnDebit.setOnClickListener(this);
        tvBtnPayment.setOnClickListener(this);

        showRecyclerProduct();
        setSpinner();
        setTotalPayment();
    }

    private void setTotalPayment() {
        int total = Data.currentUser.getPriceCartProduct();
        if(shipping.equalsIgnoreCase("jne")) {
            if(isDebit) {
                total += Data.store.calculate(Data.jne, Data.debit);
            } else {
                total += Data.store.calculate(Data.jne, Data.cash);
            }
        } else if(shipping.equalsIgnoreCase("tiki")) {
            if(isDebit) {
                total += Data.store.calculate(Data.tiki, Data.debit);
            } else {
                total += Data.store.calculate(Data.tiki, Data.cash);
            }
        }
        tvTotalPayment.setText("Rp. " + ExtraFunc.convertPrice(total));
    }

    private void setSpinner() {
        String[] shippings = new String[]{"JNE", "TiKi"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, shippings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void showRecyclerProduct() {
        rvProduct.setHasFixedSize(true);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        ProductPaymentAdapter productPaymentAdapter =
                new ProductPaymentAdapter(Data.currentUser.getWaitingCartProducts());
        rvProduct.setAdapter(productPaymentAdapter);
    }

    private void moveToPaymentAlert(boolean isSuccess) {
        Intent intent = new Intent(this, AlertActivity.class);
        if(isSuccess) {
            intent.putExtra(AlertActivity.keyIcon, "success");
            intent.putExtra(AlertActivity.keyTitleAlert, getString(R.string.alert_payment_success));
        } else {
            intent.putExtra(AlertActivity.keyIcon, "failed");
            intent.putExtra(AlertActivity.keyTitleAlert, getString(R.string.alert_payment_failed));
        }
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_back_toolbar:
                onBackPressed();
                break;
            case R.id.container_btn_cash_payment:
                containerBtnCash.setAlpha(1);
                containerBtnDebit.setAlpha(0.5f);

                containerDebitId.setVisibility(View.GONE);
                isDebit = false;
                setTotalPayment();
                break;
            case R.id.container_btn_debit_payment:
                containerBtnCash.setAlpha(0.5f);
                containerBtnDebit.setAlpha(1);

                containerDebitId.setVisibility(View.VISIBLE);
                isDebit = true;
                setTotalPayment();
                break;
            case R.id.tv_btn_pay:
                address = etAddress.getText().toString().trim();
                debitId = etDebitId.getText().toString().trim();

                if(isDebit) {
                    if(TextUtils.isEmpty(address) || TextUtils.isEmpty(shipping) ||
                       debitId.length() < 16) {
                        Toast.makeText(this, R.string.alert_data_incorrect, Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        boolean isPaymentSuccess = false;
                        if(shipping.equalsIgnoreCase("jne")) {
                            isPaymentSuccess =
                                    Data.store.buy(Data.currentUser, Data.jne, Data.debit);
                        } else if(shipping.equalsIgnoreCase("tiki")) {
                            isPaymentSuccess =
                                    Data.store.buy(Data.currentUser, Data.tiki, Data.debit);
                        }

                        moveToPaymentAlert(isPaymentSuccess);
                    }
                } else {
                    if(TextUtils.isEmpty(address) || TextUtils.isEmpty(shipping)) {
                        Toast.makeText(this, R.string.alert_data_incorrect, Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        boolean isPaymentSuccess = false;
                        if(shipping.equalsIgnoreCase("jne")) {
                            isPaymentSuccess =
                                    Data.store.buy(Data.currentUser, Data.jne, Data.cash);
                        } else if(shipping.equalsIgnoreCase("tiki")) {
                            isPaymentSuccess =
                                    Data.store.buy(Data.currentUser, Data.tiki, Data.cash);
                        }

                        moveToPaymentAlert(isPaymentSuccess);
                    }
                }

                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        shipping = adapterView.getItemAtPosition(i).toString();
        setTotalPayment();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}