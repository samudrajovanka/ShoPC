package com.majime.shopc.ui.addSaldo;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.model.User;
import com.majime.shopc.ui.login.LoginActivity;
import com.majime.shopc.utils.CustomTextWacther;
import com.majime.shopc.utils.ExtraFunc;

public class addSaldoActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialTextView mTextView, debitID_tittle;
    private EditText debitID, amount;
    private String amount_str;
    private Button confirm;
    private ConstraintLayout container_cash, container_debit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_saldo);
        initiateUI();

        //this is for giving every variable an id
        mTextView = (MaterialTextView) findViewById(R.id.text);
        debitID_tittle = (MaterialTextView) findViewById(R.id.tv_debitID_title);
        debitID = (EditText) findViewById(R.id.et_debit_id);
        container_cash = findViewById(R.id.container_cash);
        container_debit = findViewById(R.id.container_debit);
        confirm = (Button) findViewById(R.id.btn_add_saldo);
        amount = (EditText) findViewById(R.id.et_amount);

        //this for making them have job to do and thats a click
        container_cash.setOnClickListener(this);
        container_debit.setOnClickListener(this);
        confirm.setOnClickListener(this);

        //this for making default debit id input didnt appear
        debitID_tittle.setVisibility(View.GONE);
        debitID.setVisibility(View.GONE);
    }

    public void initiateUI(){
        MaterialTextView titleToolbar = findViewById(R.id.tv_toolbar);
        titleToolbar.setText(getString(R.string.add_saldo));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            //when clicked confirm
            case R.id.btn_add_saldo:
                amount_str = amount.getText().toString();
                Toast.makeText(this,"RP " + amount_str, Toast.LENGTH_SHORT).show();
                break;

                //when clicked debit button
            case R.id.container_debit:
                debitID_tittle.setVisibility(View.VISIBLE);
                debitID.setVisibility(View.VISIBLE);
                container_debit.setAlpha(1);
                container_cash.setAlpha(0.5f);
                break;
                //when clicked cash button
            case R.id.container_cash:
                debitID_tittle.setVisibility(View.GONE);
                debitID.setVisibility(View.GONE);
                container_debit.setAlpha(0.5f);
                container_cash.setAlpha(1);
                break;
            case R.id.btn_back_toolbar:
                onBackPressed();
                break;
        }
    }
}