package com.majime.shopc.ui.alert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.login.LoginActivity;

public class AlertLogOutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        initiateUi();
    }

    private void initiateUi() {
        Button btnCancel = findViewById(R.id.btn_cancel_log_out);
        Button btnOk = findViewById(R.id.btn_log_out_alert);

        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_cancel_log_out:
                onBackPressed();
                break;
            case R.id.btn_log_out_alert:
                Data.isLogged = false;
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

}