package com.example.kamran.eleganttheme;

import android.content.Context;

/**
 * Created by administorzz on 2017/5/10.
 */

public class Farmer {
    public String farmerName;
    public String farmerPhone;
    public String farmerPhoto;
    Context context;

    public Farmer(Context context,String farmerName,String farmerPhone,String farmerPhoto){
        this.context = context;

        this.farmerName = farmerName;
        this.farmerPhone = farmerPhone;
        this.farmerPhoto = farmerPhoto;
    }
    public String getFarmerName(){
        return farmerName;
    }
    public String getFarmerPhone(){
        return farmerPhone;
    }
    public String getFarmerPhoto(){
        return farmerPhoto;
    }
    public int getImageId(){

        int imageId = context.getResources().getIdentifier(farmerPhoto, "drawable", "com.example.kamran.eleganttheme");
        return imageId;
    }


}
