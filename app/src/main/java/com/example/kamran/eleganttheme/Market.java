package com.example.kamran.eleganttheme;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by administorzz on 2017/5/10.
 */

public class Market extends Activity {

    private DBHelper dbHelper;
    ListView vegeList;
    EditText vegeListName;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_farmers);

        vegeList = (ListView) findViewById(R.id.vegeList);
        vegeListName = (EditText) findViewById(R.id.edit_vegename);
        dbHelper = new DBHelper(getApplicationContext());
        vegeListName.setText("");

        Button market_btn = (Button) findViewById(R.id.jumpMarket_btn);
        market_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Market.this,FarmerList.class);
                startActivity(it);
            }
        });

        populateListView();


    }
    private void populateListView() {
        //Get names of all the fields of the table Books
        String[] fields = dbHelper.getTableFields("Users");

        //Get all the book entries from the table Books
        Cursor cursor = dbHelper.getAllEntries("Users", fields);

        //Get ids of all the widgets in the custom layout for the listview
        int[] item_ids = new int[] {R.id.vege_id,R.id.vegeListName};

        //Create the cursor that is going to feed information to the listview
        SimpleCursorAdapter vegeCursor;

        //The adapter for the listview gets information and attaches it to appropriate elements
        vegeCursor = new SimpleCursorAdapter(getBaseContext(),
                R.layout.farmer_item, cursor, fields, item_ids, 0);
        vegeList.setAdapter(vegeCursor);
    }
    public void fn_insert(View view) {
        String username = String.valueOf(vegeListName.getText());
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.COL_NAME, username);
        dbHelper.insertData("Users", contentValues);
        vegeListName.setText("");
        // booktext.setText(dbHelper.getString());
        populateListView();

    }
    public void fn_delete(View view) {
        String vegeId = String.valueOf(vegeListName.getText());
        dbHelper.deleteData("User", " _id = ?", Integer.parseInt(vegeId));
        vegeListName.setText("");
        // booktext.setText(dbHelper.getString());
        populateListView();
    }




}
