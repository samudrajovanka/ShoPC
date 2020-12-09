package com.majime.shopc.ui.Register;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText etName,etAddress, etAge , etUsername, etPassword, etConfirmPassword;
    private TextView mTextView;
    private ImageButton btnTogglePassword;
    private ImageButton btnToggleConfirmPassword;
    private boolean isClickPass = false;
    private boolean isClickConfirmPass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initiateUi();
    }

    private void initiateUi(){
        etPassword = findViewById(R.id.et_password_input_register);
        etConfirmPassword = findViewById(R.id.et_confirm_password_input_register);

        ImageButton btnBack = findViewById(R.id.btn_back_toolbar);
        Button btnRegister = findViewById(R.id.btn_register);
        MaterialTextView titleToolbar = findViewById(R.id.tv_toolbar);
        btnTogglePassword = findViewById(R.id.ib_toggle_password_register);
        btnToggleConfirmPassword = findViewById(R.id.ib_toggle_confirm_password_register);

        titleToolbar.setText(getString(R.string.register_title));

        btnTogglePassword.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnToggleConfirmPassword.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_back_toolbar:
                Toast.makeText(this, "sumpah jopan banyak mau :>", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "btn register bisa cok", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}