package com.ftninformatika.glumciapp.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ftninformatika.glumciapp.R;
import com.ftninformatika.glumciapp.db.DatabaseHelper;
import com.ftninformatika.glumciapp.db.model.Glumac;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);



        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }



        try {
            List<Glumac> list = getDatabaseHelper().getGlumacDao().queryForAll();

            adapter = new ArrayAdapter<>(this, R.layout.list_item, list);

            final ListView listView = (ListView)this.findViewById(R.id.glumci);

            // Assign adapter to ListView
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Posto radimo sa bazom podataka, svaki element ima jedinstven id
                    // pa je potrebno da vidimo na koji tacno element smo kliknuli.
                    // To mozemo uraditi tako sto izvucemo proizvod iz liste i dobijemo njegov id
                    Glumac g = (Glumac) listView.getItemAtPosition(position);

                    //listener.onProductSelected(p.getmId());
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public DatabaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}
