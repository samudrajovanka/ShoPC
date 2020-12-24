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

    private TextInputEditText etName, etAddress, etAge, etUsername, etPassword, etConfirmPassword;
    private MaterialTextView tvAlertUsername, tvAlertPassword, tvAlertConfirmPassword;
    private RadioGroup rg_gender;
    private ImageButton btnTogglePassword;
    private ImageButton btnToggleConfirmPassword;
    private Button btnRegister;
    private boolean isClickPass = false;
    private boolean isClickConfirmPass = false;
    private boolean isAlreadyUsername = false;
    private String textName = "";
    private String textAddress = "";
    private String textAge = "";
    private String textGender = "";
    private String textUsername = "";
    private String textPassword = "";
    private String textConfirmPassword = "";
    private final int minLengthPassword = 4;
    private final int minLengthUsername = 5;
    private final int maxLengthUsername = 30;

    private TextWatcher usernameTextWatcher = new CustomTextWacther() {

        @Override
        public void afterTextChanged(Editable editable) {
            textUsername = etUsername.getText().toString().trim();

            // mengecek username apakah sudah dipakai user lain
            for(User user : Data.users) {
                if(user.getUsername().equalsIgnoreCase(textUsername)) {
                    isAlreadyUsername = true;
                    break;
                } else isAlreadyUsername = false;
            }

            // validasi username
            if(TextUtils.isEmpty(textUsername)) {
                tvAlertUsername.setVisibility(View.GONE);
            } else if(textUsername.length() < minLengthUsername) {
                usernameWarnCase(getString(R.string.alert_username_minimal_characters));
            } else if(textUsername.length() > maxLengthUsername) {
                usernameWarnCase(getString(R.string.alert_username_maximal_characters));
            } else if(textUsername.trim().contains(" ")) {
                usernameWarnCase(getString(R.string.alert_username_start_and_end_with_space));
            } else if(isAlreadyUsername) {
                usernameWarnCase(getString(R.string.alert_username_already));
            } else {
                tvAlertUsername.setVisibility(View.GONE);
            }

            getRadioText();
            checkEditText();
        }
    };

    private TextWatcher registerTextWatcher = new CustomTextWacther() {

        @Override
        public void afterTextChanged(Editable editable) {
            textName = etName.getText().toString().trim();
            textAddress = etAddress.getText().toString().trim();
            textAge = etAge.getText().toString().trim();
            textPassword = etPassword.getText().toString().trim();
            textConfirmPassword = etConfirmPassword.getText().toString().trim();

            // validasi password
            if(TextUtils.isEmpty(textPassword)) {
                tvAlertPassword.setVisibility(View.GONE);
            } else if(textPassword.length() < minLengthPassword) {
                tvAlertPassword.setVisibility(View.VISIBLE);
            } else {
                tvAlertPassword.setVisibility(View.GONE);
            }

            // validasi confirm password
            if(TextUtils.isEmpty(textConfirmPassword)) {
                tvAlertConfirmPassword.setVisibility(View.GONE);
            } else if(!textPassword.equals(textConfirmPassword)) {
                tvAlertConfirmPassword.setVisibility(View.VISIBLE);
            } else {
                tvAlertConfirmPassword.setVisibility(View.GONE);
            }

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

    private void initiateUi() {
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
        tvAlertUsername = findViewById(R.id.tv_alert_username_already);
        tvAlertPassword = findViewById(R.id.tv_alert_length_password);
        tvAlertConfirmPassword = findViewById(R.id.tv_alert_confirm_password);

        // mengeset title pada toolbar
        titleToolbar.setText(getString(R.string.register_title));

        // mengeset listener agar dapat diklik
        btnTogglePassword.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnToggleConfirmPassword.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        // mengeset text listener agar dapat mengecek edit text
        etName.addTextChangedListener(registerTextWatcher);
        etAddress.addTextChangedListener(registerTextWatcher);
        etAge.addTextChangedListener(registerTextWatcher);
        etName.addTextChangedListener(registerTextWatcher);
        etUsername.addTextChangedListener(usernameTextWatcher);
        etPassword.addTextChangedListener(registerTextWatcher);
        etConfirmPassword.addTextChangedListener(registerTextWatcher);
    }

    // fungsi untuk memunculkan pesan username
    private void usernameWarnCase(String alert) {
        tvAlertUsername.setText(alert);
        tvAlertUsername.setVisibility(View.VISIBLE);
    }

    // mengambil text dari pilihan radio text
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

    // fungsi untuk mengecek semua edit text sesuai ketentuan
    private void checkEditText() {
        if(TextUtils.isEmpty(textName) || TextUtils.isEmpty(textAddress) ||
           TextUtils.isEmpty(textAge) || TextUtils.isEmpty(textGender) ||
           TextUtils.isEmpty(textUsername) || TextUtils.isEmpty(textPassword) ||
           TextUtils.isEmpty(textConfirmPassword) || textPassword.length() < minLengthPassword ||
           !textPassword.equals(textConfirmPassword) || isAlreadyUsername) {

            btnRegister.setEnabled(false);
        } else {
            btnRegister.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_back_toolbar:
                // pindah ke tampilan login
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.ib_toggle_password_register:
                // melihat/menutup isi password
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
                // melihat/menutup isi confirm password
                if(isClickConfirmPass) {
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
                // membuat akun sesuai data yang diisi
                User user = new User(
                        textUsername,
                        textPassword,
                        textName,
                        textAddress,
                        textGender,
                        Integer.parseInt(textAge),
                        0
                );
                Data.users.add(user);
                Toast.makeText(this, R.string.alert_success_register, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

}