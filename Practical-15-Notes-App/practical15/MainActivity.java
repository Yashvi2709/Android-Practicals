package com.example.practical15;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText noteText;
    Button addBtn;
    RecyclerView recyclerView;

    DBHelper db;
    NotesAdapter adapter;
    ArrayList<String> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteText=findViewById(R.id.noteText);
        addBtn=findViewById(R.id.addBtn);
        recyclerView=findViewById(R.id.recyclerView);

        db=new DBHelper(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadNotes();

        addBtn.setOnClickListener(v -> {

            db.insertNote(noteText.getText().toString());
            noteText.setText("");
            loadNotes();
        });
    }

    private void loadNotes(){

        Cursor c=db.getNotes();
        notesList=new ArrayList<>();

        while(c.moveToNext()){
            notesList.add(c.getString(1));
        }

        adapter=new NotesAdapter(notesList);
        recyclerView.setAdapter(adapter);
    }
}