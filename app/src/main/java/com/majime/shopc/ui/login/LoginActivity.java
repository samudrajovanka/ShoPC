package com.majime.shopc.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.model.User;
import com.majime.shopc.ui.main.MainActivity;
import com.majime.shopc.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText etUsername, etPassword;
    private ImageButton btnTogglePassword;
    private boolean isClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initiateUi();
    }

    private void initiateUi() {
        etUsername = findViewById(R.id.et_username_input_login);
        etPassword = findViewById(R.id.et_password_input_login);
        Button btnLogin = findViewById(R.id.btn_login);
        MaterialTextView tvRegister = findViewById(R.id.tv_here_register);
        btnTogglePassword = findViewById(R.id.ib_toggle_password_login);

        // mengeset listener untuk dapat diklik
        btnTogglePassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ib_toggle_password_login:
                if(isClick) {
                    // memunculkan password
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().length());
                    btnTogglePassword.setImageResource(R.drawable.ic_hide_password);
                    isClick = false;
                } else {
                    // merahasiakan password
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().length());
                    btnTogglePassword.setImageResource(R.drawable.ic_show_password);
                    isClick = true;
                }
                break;
            case R.id.btn_login:
                String textUsername = etUsername.getText().toString().toLowerCase().trim();
                String textPassword = etPassword.getText().toString().trim();

                if(TextUtils.isEmpty(textUsername) || TextUtils.isEmpty((textPassword))) {
                    // alert jika salah satu edit text kosong
                    Toast.makeText(this, R.string.alert_login, Toast.LENGTH_SHORT).show();
                } else {
                    boolean isValid = false;
                    for(User user : Data.users) {
                        // cek email dan password apakah ada di data
                        if(user.getUsername().equals(textUsername) &&
                           user.getPassword().equals(textPassword)) {
                            Data.currentUser = user;
                            isValid = true;
                            break;
                        }
                    }

                    if(isValid) {
                        // login berhasil, masuk ke dashboard
                        Data.isLogged = true;
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        // username atau password salah
                        Toast.makeText(this, R.string.alert_failed_login, Toast.LENGTH_SHORT)
                                .show();
                    }

                }
                break;
            case R.id.tv_here_register:
                // ke halaman register
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
        }
    }

}