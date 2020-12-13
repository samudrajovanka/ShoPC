package com.majime.shopc.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.model.User;
import com.majime.shopc.ui.login.LoginActivity;
import com.majime.shopc.utils.CustomTextWacther;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText etName,etAddress, etAge , etUsername, etPassword, etConfirmPassword;
    private RadioGroup rg_gender;
    private ImageButton btnTogglePassword;
    private ImageButton btnToggleConfirmPassword;
    private Button btnRegister;
    private boolean isClickPass = false;
    private boolean isClickConfirmPass = false;
    private String textName = "";
    private String textAddress = "";
    private String textAge = "";
    private String textGender = "";
    private String textUsername = "";
    private String textPassword = "";
    private String textConfirmPassword = "";
    private final int minLengthPassword = 4;

    private TextWatcher registerTextWatcher = new CustomTextWacther() {

        @Override
        public void afterTextChanged(Editable editable) {
            textName = etName.getText().toString().trim();
            textAddress = etAddress.getText().toString().trim();
            textAge = etAge.getText().toString().trim();
            textUsername = etUsername.getText().toString().trim();
            textPassword = etPassword.getText().toString().trim();
            textConfirmPassword = etConfirmPassword.getText().toString().trim();

            getRadioText();
            checkEditText();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initiateUi();
    }

    private void initiateUi(){
        ImageButton btnBack = findViewById(R.id.btn_back_toolbar);
        etName = findViewById(R.id.et_name_input_register);
        etAddress = findViewById(R.id.et_address_input_register);
        etAge = findViewById(R.id.et_age_input_register);
        etUsername = findViewById(R.id.et_username_input_register);
        etPassword = findViewById(R.id.et_password_input_register);
        etConfirmPassword = findViewById(R.id.et_confirm_password_input_register);
        btnRegister = findViewById(R.id.btn_register);
        MaterialTextView titleToolbar = findViewById(R.id.tv_toolbar);
        btnTogglePassword = findViewById(R.id.ib_toggle_password_register);
        btnToggleConfirmPassword = findViewById(R.id.ib_toggle_confirm_password_register);
        rg_gender = findViewById(R.id.rg_radio_gender);

        titleToolbar.setText(getString(R.string.register_title));

        btnTogglePassword.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnToggleConfirmPassword.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        etName.addTextChangedListener(registerTextWatcher);
        etAddress.addTextChangedListener(registerTextWatcher);
        etAge.addTextChangedListener(registerTextWatcher);
        etName.addTextChangedListener(registerTextWatcher);
        etPassword.addTextChangedListener(registerTextWatcher);
        etConfirmPassword.addTextChangedListener(registerTextWatcher);

    }

    private void getRadioText() {
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                textGender = radioButton.getText().toString().trim();
                checkEditText();
            }
        });
    }

    private void checkEditText() {
        if(TextUtils.isEmpty(textName) || TextUtils.isEmpty(textAddress) || TextUtils.isEmpty(textAge) ||
           TextUtils.isEmpty(textGender) || TextUtils.isEmpty(textUsername) ||
           TextUtils.isEmpty(textPassword) || TextUtils.isEmpty(textConfirmPassword) ||
           textPassword.length() < minLengthPassword || textConfirmPassword.length() < minLengthPassword) {
            btnRegister.setEnabled(false);
        } else {
            btnRegister.setEnabled(true);
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_back_toolbar:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.ib_toggle_password_register:
                if(isClickPass) {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().length());
                    btnTogglePassword.setImageResource(R.drawable.ic_hide_password);
                    isClickPass = false;
                } else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().length());
                    btnTogglePassword.setImageResource(R.drawable.ic_show_password);
                    isClickPass = true;
                }
                break;
            case R.id.ib_toggle_confirm_password_register:
                if(isClickConfirmPass){
                    etConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etConfirmPassword.setSelection(etConfirmPassword.getText().length());
                    btnToggleConfirmPassword.setImageResource(R.drawable.ic_hide_password);
                    isClickConfirmPass = false;
                } else {
                    etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etConfirmPassword.setSelection(etConfirmPassword.getText().length());
                    btnToggleConfirmPassword.setImageResource(R.drawable.ic_show_password);
                    isClickConfirmPass = true;
                }
                break;

            case R.id.btn_register:
                if(!textPassword.equals(textConfirmPassword)) {
                    Toast.makeText(this, R.string.alert_confirm_password, Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(textUsername, textPassword, textName, textAddress,
                                         textGender, Integer.parseInt(textAge), 0);
                    Data.users.add(user);
                    Toast.makeText(this, R.string.alert_success_register, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
        }
    }
}