package com.example.practical14;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TakeOrderActivity extends AppCompatActivity {

    EditText phone,item,qty;
    Button saveBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_order);

        phone=findViewById(R.id.phone);
        item=findViewById(R.id.item);
        qty=findViewById(R.id.qty);
        saveBtn=findViewById(R.id.saveBtn);

        db=new DBHelper(this);

        saveBtn.setOnClickListener(v -> {

            db.insertOrder(
                    phone.getText().toString(),
                    item.getText().toString(),
                    qty.getText().toString()
            );

            Toast.makeText(this,"Order Saved",Toast.LENGTH_SHORT).show();
        });
    }
}