package com.majime.shopc.ui.profile;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.majime.shopc.R;

public class EditProfileActivity extends AppCompatActivity{

    private EditText etName, etAddress, etCurrentPassword, etNewPassword, etConfirmPassword;
    private String textName, textAddress, textCurrentPassword, textNewPassword, textConfirmPassword;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initiateUI();
    }

    private void initiateUI() {
        etName = findViewById(R.id.et_name_change_data_profile);
        etAddress = findViewById(R.id.et_address_change_data_profile);
        etCurrentPassword = findViewById(R.id.et_current_password_change_password);
        etNewPassword = findViewById(R.id.et_new_password_change_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password_change_password);
        btn_save = findViewById(R.id.btn_save_edit_profile);

        btn_save.setOnClickListener(view -> {
            textName = etName.getText().toString().toLowerCase().trim();
            textAddress = etAddress.getText().toString().toLowerCase().trim();
            textCurrentPassword = etCurrentPassword.getText().toString().toLowerCase().trim();
            textNewPassword = etNewPassword.getText().toString().toLowerCase().trim();
            textConfirmPassword = etConfirmPassword.getText().toString().toLowerCase().trim();

            if (TextUtils.isEmpty(textName) || TextUtils.isEmpty(textAddress) || TextUtils.isEmpty(textCurrentPassword)
                    || TextUtils.isEmpty(textNewPassword) || TextUtils.isEmpty(textConfirmPassword)){
                Toast.makeText(EditProfileActivity.this, "One or more field is blank.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(EditProfileActivity.this, "Profile edit successful.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
