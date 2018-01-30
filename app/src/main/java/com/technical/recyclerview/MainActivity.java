package com.technical.recyclerview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> names;
    ArrayList<String> names2;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mlayoutManager;
    RecyclerView.Adapter mAdapter;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        names = new ArrayList<String>();
        names2 = new ArrayList<String>();



        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        try {

            SQLiteDatabase It = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);


            //  It.execSQL("CREATE TABLE IF NOT EXISTS nUsers (name VARCHAR, roll INTEGER(3), id INTEGER PRIMARY KEY)");

            // It.execSQL("INSERT INTO nUsers (name, roll) VALUES ('Kirsten', 1)");

            //  It.execSQL("INSERT INTO nUsers (name, roll) VALUES ('Ralphie', 2)");

            //  It.execSQL("INSERT INTO nUsers (name, roll) VALUES ('Rob', 3)");

            //  It.execSQL("INSERT INTO nUsers (name, roll) VALUES ('Kennny', 4)");

            //  It.execSQL("DELETE FROM newUsers WHERE id = 1");

            Cursor c = It.rawQuery("SELECT * FROM nUsers", null);

            int nameIndex = c.getColumnIndex("name");
            int rollIndex = c.getColumnIndex("roll");
            // int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while (c != null) {

                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(rollIndex)));
                //Log.i("UserResults - id", Integer.toString(c.getInt(idIndex)));

                names2.add("" + c.getString(nameIndex));

                c.moveToNext();
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

        for (int i = 1; i <= names2.size(); i++) {

            names.add("" + i);

        }


        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);

        mAdapter = new MainAdapter(names, names2);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.next) {

            startActivity(new Intent(this, Login.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
