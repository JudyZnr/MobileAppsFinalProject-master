package com.example.kamran.eleganttheme;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by administorzz on 2017/5/10.
 */

public class FarmerList extends Activity {
    ArrayList<String[]> farmerlist = new ArrayList<>();
    ArrayList<Farmer> farmer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.farmer_list);

        MyCsvFileReader csvFileReader = new MyCsvFileReader(getApplicationContext());
        farmerlist= csvFileReader.readCsvFile(R.raw.farmers);
        for(int i=0; i< farmerlist.size();i++) {
            String[] str = farmerlist.get(i);
            Farmer farmer1 = new Farmer(getApplicationContext(), str[0], str[1], str[2]);
            farmer.add(farmer1);
        }

            FarmerAdapter adpater = new FarmerAdapter(FarmerList.this,R.layout.activity_faprofile, farmer);
            ListView farmersList = (ListView)findViewById(R.id.farmers_list);
            farmersList.setAdapter(adpater);

            farmersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Farmer farmer_1 = farmer.get(position);
                    String phoneNum = farmer_1.getFarmerPhone();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+ phoneNum));
                    startActivity(intent);

                }
            });





    }

}
