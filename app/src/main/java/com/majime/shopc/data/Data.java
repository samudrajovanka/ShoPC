package com.majime.shopc.data;

import com.majime.shopc.R;
import com.majime.shopc.model.Game;
import com.majime.shopc.model.OperatingSystem;
import com.majime.shopc.model.Product;
import com.majime.shopc.model.Store;
import com.majime.shopc.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    public static final ArrayList<User> users = new ArrayList<>();

    private static final ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Game("Cyberpunk 2077", 700000, 5, 21, R.drawable.game_cyberpunk, "V1.04", 102000, "Action RPG", "CD Projekt"),
            new Game("WWE 2K20", 740000, 2, 109, R.drawable.game_wwe2k20, "v3.10", 50000, "Sport", "Visual Concepts"),
            new Game("Subnautica", 120000, 4, 37, R.drawable.game_subnautica, "v11", 20, "Survival game", "Unknown Worlds Entertainment"),
            new Game("Left 4 Dead 2",70000, 4, 14, R.drawable.game_left_4_dead_2, "v2.2.0.9", 13000, "Survival horror", "Valve Corporation"),
            new Game("Phasmophobia", 90000, 5, 7, R.drawable.game_phasmophobia, "v11.5", 15000, "Survival horror", "Kinetic Games")
    ));
    public static final Store store = new Store("ShoPC", "Jln. Sesama Bahagia", products);
}
