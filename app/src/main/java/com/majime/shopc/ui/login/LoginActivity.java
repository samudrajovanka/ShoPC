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
    private String textUsername, textPassword;
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

        btnTogglePassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ib_toggle_password_login:
                if(isClick) {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().length());
                    btnTogglePassword.setImageResource(R.drawable.ic_hide_password);
                    isClick = false;
                } else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().length());
                    btnTogglePassword.setImageResource(R.drawable.ic_show_password);
                    isClick = true;
                }
                break;
            case R.id.btn_login:
                textUsername = etUsername.getText().toString().toLowerCase().trim();
                textPassword = etPassword.getText().toString().toLowerCase().trim();

                if(TextUtils.isEmpty(textUsername) || TextUtils.isEmpty((textPassword))) {
                    Toast.makeText(this, R.string.alert_login, Toast.LENGTH_SHORT).show();
                } else {
                    // masuk ke screen main (dashboard)
                    for(User user: Data.users) {
                        if(user.getUsername().equals(textUsername) && user.getPassword().equals(textPassword)) {
                            startActivity(new Intent(this, MainActivity.class));
                        }
                    }
                    Toast.makeText(this, R.string.alert_failed_login, Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.tv_here_register:
                // pindah ke screen register
                Intent moveIntent = new Intent(this, RegisterActivity.class);
                startActivity(moveIntent);
                break;
        }
    }

}