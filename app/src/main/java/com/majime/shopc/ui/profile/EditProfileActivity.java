package com.majime.shopc.ui.profile;

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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.main.MainActivity;
import com.majime.shopc.utils.CustomTextWacther;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName, etAddress, etCurrentPassword, etNewPassword, etConfirmPassword;
    private MaterialTextView tvAlertNewPassword, tvAlertConfirmPassword;
    private ImageButton btnToggleCurrentPassword, btnToggleNewPassword, btnToggleConfirmPassword;
    private String textNewPassword, textConfirmPassword;
    private boolean isNewPasswordValid = false;
    private boolean isConfirmPasswordValid = false;
    private boolean isClickCurrentPass = false;
    private boolean isClickNewPass = false;
    private boolean isClickConfirmPass = false;

    private TextWatcher passwordTextWatcher = new CustomTextWacther() {

        @Override
        public void afterTextChanged(Editable editable) {
            textNewPassword = etNewPassword.getText().toString().trim();
            textConfirmPassword = etConfirmPassword.getText().toString().trim();

            if(TextUtils.isEmpty(textNewPassword)) {
                tvAlertNewPassword.setVisibility(View.GONE);
                isNewPasswordValid = false;
            } else if(textNewPassword.length() < 4) {
                tvAlertNewPassword.setVisibility(View.VISIBLE);
                isNewPasswordValid = false;
            } else {
                tvAlertNewPassword.setVisibility(View.GONE);
                isNewPasswordValid = true;
            }

            if(TextUtils.isEmpty(textConfirmPassword)) {
                tvAlertConfirmPassword.setVisibility(View.GONE);
                isConfirmPasswordValid = false;
            } else if(!textNewPassword.equals(textConfirmPassword)) {
                tvAlertConfirmPassword.setVisibility(View.VISIBLE);
                isConfirmPasswordValid = false;
            } else {
                tvAlertConfirmPassword.setVisibility(View.GONE);
                isConfirmPasswordValid = true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initiateUI();
    }

    private void initiateUI() {
        ImageButton btnBack = findViewById(R.id.btn_back_toolbar);
        MaterialTextView tvToolbar = findViewById(R.id.tv_toolbar);
        etName = findViewById(R.id.et_name_change_data_profile);
        etAddress = findViewById(R.id.et_address_change_data_profile);
        etCurrentPassword = findViewById(R.id.et_current_password_change_password);
        etNewPassword = findViewById(R.id.et_new_password_change_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password_change_password);
        Button btnSave = findViewById(R.id.btn_save_edit_profile);
        tvAlertNewPassword = findViewById(R.id.tv_alert_length_password_new_password);
        tvAlertConfirmPassword = findViewById(R.id.tv_alert_confirm_password_edit_profile);
        btnToggleCurrentPassword = findViewById(R.id.ib_toggle_current_password_edit_profile);
        btnToggleNewPassword = findViewById(R.id.ib_toggle_new_password_edit_profile);
        btnToggleConfirmPassword = findViewById(R.id.ib_toggle_confirm_new_password_edit_profile);

        tvToolbar.setText(getString(R.string.edit_profile_title));
        etName.setText(Data.currentUser.getName());
        etAddress.setText(Data.currentUser.getAddress());

        btnBack.setOnClickListener(this);
        btnToggleCurrentPassword.setOnClickListener(this);
        btnToggleNewPassword.setOnClickListener(this);
        btnToggleConfirmPassword.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        etNewPassword.addTextChangedListener(passwordTextWatcher);
        etConfirmPassword.addTextChangedListener(passwordTextWatcher);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_back_toolbar:
                onBackPressed();
                break;
            case R.id.ib_toggle_current_password_edit_profile:
                if(isClickCurrentPass) {
                    etCurrentPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etCurrentPassword.setSelection(etCurrentPassword.getText().length());
                    btnToggleCurrentPassword.setImageResource(R.drawable.ic_hide_password);
                    isClickCurrentPass = false;
                } else {
                    etCurrentPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etCurrentPassword.setSelection(etCurrentPassword.getText().length());
                    btnToggleCurrentPassword.setImageResource(R.drawable.ic_show_password);
                    isClickCurrentPass = true;
                }
                break;
            case R.id.ib_toggle_new_password_edit_profile:
                if(isClickNewPass) {
                    etNewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etNewPassword.setSelection(etNewPassword.getText().length());
                    btnToggleNewPassword.setImageResource(R.drawable.ic_hide_password);
                    isClickNewPass = false;
                } else {
                    etNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etNewPassword.setSelection(etNewPassword.getText().length());
                    btnToggleNewPassword.setImageResource(R.drawable.ic_show_password);
                    isClickNewPass = true;
                }
                break;
            case R.id.ib_toggle_confirm_new_password_edit_profile:
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
            case R.id.btn_save_edit_profile:
                String textName, textAddress, textCurrentPassword;
                boolean isNotBlank = false;
                boolean isPasswordValid = false;

                textName = etName.getText().toString().trim();
                textAddress = etAddress.getText().toString().trim();
                textCurrentPassword = etCurrentPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(textCurrentPassword) || !TextUtils.isEmpty(textNewPassword) ||
                   !TextUtils.isEmpty(textConfirmPassword)) {
                    if(TextUtils.isEmpty(textCurrentPassword) ||
                       TextUtils.isEmpty(textNewPassword) ||
                       TextUtils.isEmpty(textConfirmPassword)) {
                        isNotBlank = false;
                    } else {
                        if(isNewPasswordValid && isConfirmPasswordValid) {
                            if(textCurrentPassword.equals(Data.currentUser.getPassword())) {
                                isNotBlank = true;
                                Toast.makeText(
                                        this,
                                        R.string.success_edit_profile,
                                        Toast.LENGTH_SHORT
                                ).show();
                                Data.currentUser.setPassword(textNewPassword);
                                startActivity(new Intent(this, MainActivity.class));
                            } else {
                                isNotBlank = true;
                                Toast.makeText(this,
                                               R.string.alert_data_incorrect,
                                               Toast.LENGTH_SHORT
                                ).show();
                            }

                        } else {
                            isNotBlank = true;
                            Toast.makeText(this,
                                           R.string.alert_data_incorrect,
                                           Toast.LENGTH_SHORT
                            )
                                    .show();
                        }
                    }
                    isPasswordValid = true;
                }

                if(!isPasswordValid) {
                    if(!TextUtils.isEmpty(textName) && !TextUtils.isEmpty(textAddress)) {
                        if(!textName.equals(Data.currentUser.getName()) ||
                           !textAddress.equals(Data.currentUser.getAddress())) {
                            if(!textName.equals(Data.currentUser.getName())) {
                                Data.currentUser.setName(textName);
                            }

                            if(!textAddress.equals(Data.currentUser.getAddress())) {
                                Data.currentUser.setAddress(textAddress);
                            }

                            Toast.makeText(this, R.string.success_edit_profile, Toast.LENGTH_SHORT)
                                    .show();
                        }
                        isNotBlank = true;
                        startActivity(new Intent(this, MainActivity.class));
                    }
                }

                if(!isNotBlank) {
                    Toast.makeText(this,
                                   R.string.alert_blank_field_edit_profile,
                                   Toast.LENGTH_SHORT
                    )
                            .show();
                }
                break;
        }
    }

}
