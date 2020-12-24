package com.majime.shopc.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.addSaldo.AddSaldoActivity;
import com.majime.shopc.ui.login.LoginActivity;
import com.majime.shopc.utils.ExtraFunc;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initiateUi(view);

        return view;
    }

    private void initiateUi(View view) {
        MaterialTextView tvProfileName = view.findViewById(R.id.tv_profile_name);
        MaterialTextView tvProfileUsername = view.findViewById(R.id.tv_profile_username);
        MaterialTextView tvAmountSaldo = view.findViewById(R.id.tv_amount_saldo_profile);
        ConstraintLayout containerBtnAddSaldo = view.findViewById(R.id.container_btn_add_saldo);
        ConstraintLayout containerBtnEditProfile =
                view.findViewById(R.id.container_btn_edit_profile);
        ConstraintLayout containerBtnLogOut = view.findViewById(R.id.container_btn_log_out_account);
        ConstraintLayout containerBtnDeleteAccount =
                view.findViewById(R.id.container_btn_delete_account);

        tvProfileName.setText(Data.currentUser.getName());
        tvProfileUsername.setText(Data.currentUser.getUsername());
        tvAmountSaldo.setText("Rp. " + ExtraFunc.convertPrice(Data.currentUser.getSaldo()));

        containerBtnAddSaldo.setOnClickListener(this);
        containerBtnEditProfile.setOnClickListener(this);
        containerBtnLogOut.setOnClickListener(this);
        containerBtnDeleteAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.container_btn_add_saldo:
                getActivity().startActivity(new Intent(getContext(), AddSaldoActivity.class));
                break;
            case R.id.container_btn_edit_profile:
                getActivity().startActivity(new Intent(getContext(), EditProfileActivity.class));
                break;
            case R.id.container_btn_log_out_account:
                Data.isLogged = false;
                getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
                break;
            case R.id.container_btn_delete_account:
                Toast.makeText(getActivity(), R.string.delete_account_success, Toast.LENGTH_SHORT)
                        .show();
                Data.users.remove(Data.currentUser);
                getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
                break;
        }
    }

}