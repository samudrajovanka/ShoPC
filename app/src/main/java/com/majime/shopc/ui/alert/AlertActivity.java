package com.majime.shopc.ui.alert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.ui.main.MainActivity;

public class AlertActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String keyIcon = "ICON";
    public static final String keyTitleAlert = "ALERT";
    private String icon, alert;
    ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        initiateUi();
    }

    private void initiateUi() {
        ivIcon = findViewById(R.id.iv_icon_alert);
        MaterialTextView tvAlert = findViewById(R.id.tv_alert);
        Button btnOk = findViewById(R.id.btn_ok);

        icon = getIntent().getStringExtra(AlertActivity.keyIcon);
        alert = getIntent().getStringExtra(AlertActivity.keyTitleAlert);

        setIcon();
        tvAlert.setText(alert);

        btnOk.setOnClickListener(this);
    }

    private void setIcon() {
        if(icon.equals("success")) {
            ivIcon.setImageResource(R.drawable.ic_success);
        } else if (icon.equals("failed")) {
            ivIcon.setImageResource(R.drawable.ic_cross);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
             case R.id.btn_ok:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

}