package com.example.practical14;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ViewOrderActivity extends AppCompatActivity {

    ListView listView;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        listView=findViewById(R.id.listView);
        db=new DBHelper(this);

        Cursor c=db.getOrders();
        ArrayList<String> list=new ArrayList<>();

        while(c.moveToNext()){
            list.add(
                    c.getString(1)+" - "+
                            c.getString(2)+" - Qty:"+
                            c.getString(3)
            );
        }

        listView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        ));
    }
}