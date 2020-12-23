package com.majime.shopc.ui.productDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.majime.shopc.R;
import com.majime.shopc.adapter.SpecificProductAdapter;
import com.majime.shopc.data.Data;
import com.majime.shopc.model.Antivirus;
import com.majime.shopc.model.Frequency;
import com.majime.shopc.model.Game;
import com.majime.shopc.model.Hardware;
import com.majime.shopc.model.LicensedSoftware;
import com.majime.shopc.model.Memory;
import com.majime.shopc.model.Motherboard;
import com.majime.shopc.model.OperatingSystem;
import com.majime.shopc.model.Processor;
import com.majime.shopc.model.Product;
import com.majime.shopc.model.Ram;
import com.majime.shopc.model.Socket;
import com.majime.shopc.model.Software;
import com.majime.shopc.model.Storage;
import com.majime.shopc.utils.ExtraFunc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener{
    public final static String key_name = "NAME";
    private Product product;
    private RecyclerView rvSpecificProduct;
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initiateUi();
    }

    private void initiateUi() {
        ImageButton btnBack = findViewById(R.id.btn_back_button_detail);
        Button btnAddToCart = findViewById(R.id.btn_add_to_cart);
        ImageView ivProduct = findViewById(R.id.iv_image_product_detail);
        MaterialTextView tvNameProduct = findViewById(R.id.tv_name_product_detail);
        MaterialTextView tvComponentProduct = findViewById(R.id.tv_product_component_detail);
        MaterialTextView tvPriceProduct = findViewById(R.id.tv_price_product_detail);
        ImageView ivRating1 = findViewById(R.id.iv_star_1_detail);
        ImageView ivRating2 = findViewById(R.id.iv_star_2_detail);
        ImageView ivRating3 = findViewById(R.id.iv_star_3_detail);
        ImageView ivRating4 = findViewById(R.id.iv_star_4_detail);
        ImageView ivRating5 = findViewById(R.id.iv_star_5_detail);
        MaterialTextView tvAmountProduct = findViewById(R.id.tv_amount_product);
        rvSpecificProduct = findViewById(R.id.rv_specific_detail);

        String nameProduct = this.getIntent().getStringExtra(ProductDetailActivity.key_name);

        product = Data.store.getProduct(nameProduct);

        ivProduct.setImageResource(product.getPhoto());
        tvNameProduct.setText(product.getName());
        tvComponentProduct.setText(product.getClass().getSimpleName());
        tvPriceProduct.setText("Rp. " + ExtraFunc.convertPrice(product.getPrice()));
        ExtraFunc.setStarRating(product.getRating(), ivRating1, ivRating2, ivRating3, ivRating4, ivRating5);
        tvAmountProduct.setText(String.valueOf(product.getAmount()));
        getData(product);
        showSpecificDetailProduct();

        btnBack.setOnClickListener(this);
        btnAddToCart.setOnClickListener(this);
    }

    private void getData(Product product) {
        if(product instanceof Hardware) {
            titles.add(getString(R.string.merk_product));
            values.add(((Hardware) product).getMerk());
            titles.add(getString(R.string.type_product));
            values.add(((Hardware) product).getType());
            titles.add(getString(R.string.weight_product));
            values.add(((Hardware) product).getWeight() + " gr");
            titles.add(getString(R.string.length_product));
            values.add(((Hardware) product).getLength() + " cm");
            titles.add(getString(R.string.width_product));
            values.add(((Hardware) product).getWidth() + " cm");

            if(product instanceof Socket) {
                titles.add(getString(R.string.pin_product));
                values.add(String.valueOf(((Socket) product).getPinAmount()));
                titles.add(getString(R.string.socket_product));
                values.add(((Socket) product).getSupportedCpu());
            }

            if(product instanceof Frequency) {
                titles.add(getString(R.string.frequency_product));
                values.add(((Frequency) product).getFrequency() + " GHz");
            }

            if(product instanceof Memory) {
                titles.add(getString(R.string.memory_product));
                values.add(((Memory) product).getSizeMemory() + " GB");
            }

            if(product instanceof Motherboard) {
                titles.add(getString(R.string.slot_product));
                values.add(String.valueOf(((Motherboard) product).getSlotAmount()));
            }

            if(product instanceof Processor) {
                titles.add(getString(R.string.core_product));
                values.add(String.valueOf(((Processor) product).getCoreAmount()));
            }

            if(product instanceof Ram) {
                titles.add(getString(R.string.ddr_type_product));
                values.add(((Ram) product).getDdrType());
            }

            if(product instanceof Storage) {
                titles.add(getString(R.string.connection_product));
                values.add(((Storage) product).getConnection());
            }
        } else if(product instanceof Software) {
            titles.add(getString(R.string.version_soft_product));
            values.add(((Software) product).getVersion());
            titles.add(getString(R.string.size_soft_product));
            values.add(ExtraFunc.convertSize(((Software) product).getSize()) + " Gb");

            if(product instanceof Game) {
                titles.add(getString(R.string.genre_product));
                values.add(((Game) product).getGenre());
                titles.add(getString(R.string.developer_product));
                values.add(((Game) product).getDeveloper());
            }

            if(product instanceof LicensedSoftware) {
                titles.add(getString(R.string.key_product));
                values.add(((LicensedSoftware) product).getKey());

                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                titles.add(getString(R.string.expiration_date_product));
                values.add(dateFormat.format(((LicensedSoftware) product).getExpiration()));
            }

            if(product instanceof OperatingSystem) {
                titles.add(getString(R.string.type_os_product));
                values.add(((OperatingSystem) product).getType());
            }

            if(product instanceof Antivirus) {
                titles.add(getString(R.string.developer_product));
                values.add(((Antivirus) product).getDeveloper());
            }
        }
    }

    private void showSpecificDetailProduct() {
        rvSpecificProduct.setHasFixedSize(true);
        rvSpecificProduct.setLayoutManager(new LinearLayoutManager(this));
        SpecificProductAdapter specificProductAdapter = new SpecificProductAdapter(titles, values);
        rvSpecificProduct.setAdapter(specificProductAdapter);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_fragment_main, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_back_button_detail:
                onBackPressed();
                break;
            case R.id.btn_add_to_cart:
                onBackPressed();
                Toast.makeText(this, "masuk", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}