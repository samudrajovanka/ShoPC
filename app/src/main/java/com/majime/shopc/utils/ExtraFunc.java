package com.majime.shopc.utils;

import android.view.View;
import android.widget.ImageView;

public class ExtraFunc {

    public static String convertPrice(int price) {
        String strPrice = "";

        if(price == 0) {
            return "0";
        }

        do {
            if(price % 1000 == 0) {
                strPrice = ".000" + strPrice;
            } else {
                if(price % 1000 < 100) {
                    if(price % 1000 < 10) {
                        strPrice = ".00" + price % 1000 + strPrice;
                    } else {
                        strPrice = ".0" + price % 1000 + strPrice;
                    }
                } else {
                    strPrice = "." + price % 1000 + strPrice;
                }

            }
            price /= 1000;
        } while(price / 1000 != 0);
        strPrice = price % 1000 + strPrice;

        return  strPrice;
    }

    public static String convertSize(int size) {
        String strSize = "";
        strSize += size/1000;

        if(size % 1000 != 0 ) {
            strSize += "." + size%1000;
        }

        return strSize;
    }

    public static void setStarRating(int rating, ImageView iv1, ImageView iv2, ImageView iv3, ImageView iv4, ImageView iv5) {
        switch(rating) {
            case 1:
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.GONE);
                iv3.setVisibility(View.GONE);
                iv4.setVisibility(View.GONE);
                iv5.setVisibility(View.GONE);
                break;
            case 2:
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.GONE);
                iv4.setVisibility(View.GONE);
                iv5.setVisibility(View.GONE);
                break;
            case 3:
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.VISIBLE);
                iv4.setVisibility(View.GONE);
                iv5.setVisibility(View.GONE);
                break;
            case 4:
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.VISIBLE);
                iv4.setVisibility(View.VISIBLE);
                iv5.setVisibility(View.GONE);
                break;
            case 5:
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.VISIBLE);
                iv4.setVisibility(View.VISIBLE);
                iv5.setVisibility(View.VISIBLE);
                break;
        }
    }
}
