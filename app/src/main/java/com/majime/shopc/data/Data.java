package com.majime.shopc.data;

import com.majime.shopc.R;
import com.majime.shopc.model.Antivirus;
import com.majime.shopc.model.Cash;
import com.majime.shopc.model.Debit;
import com.majime.shopc.model.Game;
import com.majime.shopc.model.Jne;
import com.majime.shopc.model.Motherboard;
import com.majime.shopc.model.OperatingSystem;
import com.majime.shopc.model.Processor;
import com.majime.shopc.model.Product;
import com.majime.shopc.model.Ram;
import com.majime.shopc.model.Storage;
import com.majime.shopc.model.Store;
import com.majime.shopc.model.Tiki;
import com.majime.shopc.model.User;
import com.majime.shopc.model.Vga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Data {
    public static final ArrayList<User> users = new ArrayList<>();
    public static User currentUser = new User();
    public static boolean isLogged = false;

    private static final ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Game("Cyberpunk 2077", 700000, 5, 21, R.drawable.game_cyberpunk, "V1.04", 102000, "Action RPG", "CD Projekt"),
            new Game("Phasmophobia", 90000, 5, 7, R.drawable.game_phasmophobia, "v11.5", 15000, "Survival horror", "Kinetic Games"),
            new Processor("Intel Core i7 10700K", 5779000, 5, 20, R.drawable.processor_intel_core, 42, 3, 1, 3, "Intel", "i7 10700K", 1200, 5, 8, "FCLGA1200"),
            new OperatingSystem("Windows 10 Pro", 2831290, 5, 82, R.drawable.os_microsoft_windows_10_pro, "v2020", 15000,"qwertyuiop", new Date(2030-1900,5,15), "Microsoft"),
            new Antivirus("Smadav", 43000, 3, 55, R.drawable.av_smadav, "v14.4", 1000, "987654321", new Date(2021-1900,5,12), "Zainuddin Nafarin"),
            new Antivirus("McAfee", 820000, 1, 66, R.drawable.av_mcafee, "v22.1", 1000, "456789123", new Date(2021-1900,6,12), "NitroSecurity"),
            new Vga("RTX 3090" , 24000000, 5, 3, R.drawable.vga_rtx, 300, 100, 50, 150, "NVIDIA", "3090", 4, 24),
            new Motherboard("TRX40 AORUS Master", 9528000, 4, 3, R.drawable.motherboard_aorus, 2721, 31, 4, 26, "GIGABYTE", "TRX40", 4094, 8, "sTRX4"),
            new Storage("Seagate BarraCuda", 3000000, 2, 10, R.drawable.storage_barracuda,200, 150, 100, 200,"Seagate", "HDD", 2, "SATA", 5000),
            new Game("WWE 2K20", 740000, 2, 109, R.drawable.game_wwe2k20, "v3.10", 50000, "Sport", "Visual Concepts"),
            new Ram("Corsair Vengeance Pro", 3000000, 4, 5, R.drawable.ram_vengeance_pro, 50, 20, 30, 50, "Corsair", "RGB", 4, "DDR 6", 16),
            new OperatingSystem("Windows 10 Home", 1967746, 4, 22, R.drawable.os_windows_10_home, "v2020", 15000, "asdfghjkl", new Date(2030-1900,5,15), "Microsoft"),
            new Storage("SAMSUNG V-NAND SSD", 2000000, 5, 2, R.drawable.storage_v_nand_ssd,150, 200, 300, 200, "SAMSUNG" , "980 PRO", 4, "PCIe 4.0 NVMe M.2", 1000),
            new Vga("GTX 1080 Ti",11000000, 3, 20, R.drawable.vga_gtx, 200, 100 ,150, 150, "NVIDIA", "1080 Ti", 4-1900, 11),
            new Processor("Intel Xeon E-2288G", 5779000, 4, 5, R.drawable.processor_xeon, 65, 4, 1, 4, "Intel", "E-2288G", 1151, 5, 8, "FCLGA1151"),
            new Game("Subnautica", 120000, 4, 37, R.drawable.game_subnautica, "v11", 20000, "Survival game", "Unknown Worlds Entertainment"),
            new Game("Left 4 Dead 2",70000, 4, 14, R.drawable.game_left_4_dead_2, "v2.2.0.9", 13000, "Survival horror", "Valve Corporation"),
            new OperatingSystem("Windows 8 Pro", 1967746, 3, 6, R.drawable.os_microsoft_windows_8, "v8.1", 6000, "zxcvbnm", new Date(2030-1900,5,15), "Microsoft"),
            new Antivirus("Kaspersky Anti-virus", 308000, 4, 55, R.drawable.av_kaspersky, "v10.15", 1000, "123456789", new Date(2021-1900,4,25), "Kaspersky"),
            new Processor("AMD Ryzen Threadripper 3990X", 73655000, 5, 2, R.drawable.processor_amd_ryzen_threadripper, 902, 5, 1, 7, "AMD", "Threadripper 3990X", 4094, 4,64, "sTRX4"),
            new Processor("AMD Ryzen 9 5900x", 7850000, 4, 7, R.drawable.processor_amd_ryzen, 52, 2, 1, 2, "AMD", "9 5900x", 1331, 5, 12, "AM4"),
            new Motherboard("ASUS PRIME X299", 8110000, 5, 5, R.drawable.motherboard_prime, 2041, 30, 3, 25, "ASUS", "X299", 2066, 8, "LGA2066")
    ));
    public static final Store store = new Store("ShoPC", "Jln. Sesama Bahagia", products);
    public static final  Jne jne = new Jne(1000, true);
    public static final Tiki tiki = new Tiki(2000, "Same Day");
    public static final Cash cash = new Cash(1500);
    public static final Debit debit = new Debit(2500);
}
