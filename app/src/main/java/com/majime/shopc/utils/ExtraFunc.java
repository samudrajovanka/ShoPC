package com.majime.shopc.utils;

public class ExtraFunc {

    public static String convertPrice(int price) {
        String strPrice = "";
        do {
            if(price % 1000 == 0) {
                strPrice = ".000" + strPrice;
            } else {
                strPrice = "." + price % 1000 + strPrice;
            }
            price /= 1000;
        } while(price / 1000 != 0);
        strPrice = price % 1000 + strPrice;

        return  strPrice;
    }
}
