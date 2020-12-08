package com.majime.shopc.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;

public class HomeFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initiateUi(view);

        return view;
    }

    private void initiateUi(View view) {
        ImageButton btnBack = view.findViewById(R.id.btn_back_toolbar);
        ImageView ivLogoToolbar = view.findViewById(R.id.iv_logo_toolbar);
        MaterialTextView titleToolbar = view.findViewById(R.id.tv_toolbar);

        // mengubah btn back menjadi logo pada toolbar
        btnBack.setVisibility(View.INVISIBLE);
        ivLogoToolbar.setVisibility(View.VISIBLE);

        // mengubah text pada toolbar
        titleToolbar.setText(getString(R.string.app_name));

    }

}