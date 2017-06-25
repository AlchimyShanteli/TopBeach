package com.topbeach.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.topbeach.R;
import com.topbeach.adapters.BeachAdapter;
import com.topbeach.parsers.FileParser;
import com.topbeach.repository.DbRepository;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Alchimy on 4/25/2017.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final DbRepository repository = new DbRepository(this);
        BeachAdapter beachAdapter = new BeachAdapter(repository.getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(beachAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_bar:
                Log.e("", "onOptionsItemSelected: ");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    private String createBeachModelList() throws
            IOException {
        FileParser fileParser = new FileParser();
        return fileParser.loadFile(this);
    }

    public enum Fields {
        ID(0),
        COUNTRY_NAME(1);

        Fields(int i) {
            this.fieldCode = i;
        }

        public int getFieldCode() {
            return fieldCode;
        }

        private int fieldCode;
    }



}





