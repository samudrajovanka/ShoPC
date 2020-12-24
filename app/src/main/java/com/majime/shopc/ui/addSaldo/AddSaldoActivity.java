package com.majime.shopc.ui.addSaldo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.alert.AlertActivity;

public class AddSaldoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAmount, etDebitId;
    private ConstraintLayout containerCash, containerDebit, containerDebitId;
    private boolean isDebit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_saldo);
        initiateUI();
    }

    public void initiateUI() {
        //this is for giving every variable an id
        MaterialTextView titleToolbar = findViewById(R.id.tv_toolbar);
        ImageButton btnBack = findViewById(R.id.btn_back_toolbar);
        containerCash = findViewById(R.id.container_cash);
        containerDebit = findViewById(R.id.container_debit);
        Button confirm = findViewById(R.id.btn_add_saldo);
        etAmount = findViewById(R.id.et_amount);
        containerDebitId = findViewById(R.id.container_debit_id_add_saldo);
        etDebitId = findViewById(R.id.et_debit_id);

        titleToolbar.setText(getString(R.string.add_saldo_title));

        // memberi listener untuk dapat di klik
        btnBack.setOnClickListener(this);
        containerCash.setOnClickListener(this);
        containerDebit.setOnClickListener(this);
        confirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_back_toolbar:
                onBackPressed();
                break;
            case R.id.btn_add_saldo:
                String amountStr = etAmount.getText().toString();
                if(amountStr.length() > 7) {
                    Toast.makeText(this, R.string.alert_digit_saldo, Toast.LENGTH_SHORT).show();
                } else if(amountStr.length() != 0) {
                    if(isDebit) {
                        String debitId = etDebitId.getText().toString().trim();
                        if(debitId.length() != 16) {
                            Toast.makeText(
                                    this,
                                    R.string.alert_debit_id_invalid,
                                    Toast.LENGTH_SHORT
                            ).show();
                        } else {
                            if(Data.currentUser.getSaldo() < 9999999) {
                                Data.currentUser.setSaldo(
                                        Data.currentUser.getSaldo() + Integer.parseInt(amountStr));

                                Intent intent = new Intent(this, AlertActivity.class);
                                intent.putExtra(AlertActivity.keyIcon, "success");
                                intent.putExtra(
                                        AlertActivity.keyTitleAlert,
                                        getString(R.string.alert_add_saldo_successful)
                                );

                                startActivity(intent);
                            } else {
                                Toast.makeText(
                                        this,
                                        R.string.alert_saldo_maximum,
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        }
                    } else {
                        if(Data.currentUser.getSaldo() < 9999999) {
                            Data.currentUser.setSaldo(
                                    Data.currentUser.getSaldo() + Integer.parseInt(amountStr));

                            Intent intent = new Intent(this, AlertActivity.class);
                            intent.putExtra(AlertActivity.keyIcon, "success");
                            intent.putExtra(
                                    AlertActivity.keyTitleAlert,
                                    getString(R.string.alert_add_saldo_successful)
                            );

                            startActivity(intent);
                        } else {
                            Toast.makeText(this, R.string.alert_saldo_maximum, Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                } else {
                    Toast.makeText(this, R.string.alert_empty_amount, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.container_debit:
                isDebit = true;
                containerDebitId.setVisibility(View.VISIBLE);
                containerDebit.setAlpha(1);
                containerCash.setAlpha(0.5f);
                break;
            case R.id.container_cash:
                isDebit = false;
                containerDebitId.setVisibility(View.GONE);
                containerDebit.setAlpha(0.5f);
                containerCash.setAlpha(1);
                break;
        }
    }

}