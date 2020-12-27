package com.majime.shopc.ui.alert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.login.LoginActivity;

public class AlertDeleteAccountActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        initiateUi();
    }

    private void initiateUi() {
        MaterialTextView tvTitle = findViewById(R.id.tv_title_alert_dialog);
        MaterialTextView tvSubtitle = findViewById(R.id.tv_subtitle_alert_dialog);
        Button btnCancel = findViewById(R.id.btn_cancel_log_out);
        Button btnOk = findViewById(R.id.btn_log_out_alert);

        tvTitle.setText(getString(R.string.delete_account_title));
        tvSubtitle.setText(R.string.alert_sub_title_delete_account);

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
                Data.users.remove(Data.currentUser);
                Toast.makeText(this, R.string.delete_account_success, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

}