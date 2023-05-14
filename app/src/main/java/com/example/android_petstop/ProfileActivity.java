package com.example.android_petstop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android_petstop.Adapter.RecyclerViewAdapter;
import com.example.android_petstop.Adapter.SpinnerAdapter;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "ProfileActivity";

    //posts on profile photo
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    //navigation/spinner bar
    Spinner customSpinner;
    private ArrayList<DropDownItem> dropDownList;

    //drawable array for profile page
    int []arr = {R.drawable.postone, R.drawable.posttwo, R.drawable.postthree, R.drawable.postfour, R.drawable.postfive, R.drawable.postsix, R.drawable.postseven, R.drawable.posteight};


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //posts
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(arr);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        //spinner
        customSpinner = findViewById(R.id.spinnerIcon);
        dropDownList = getDropDownList();
        SpinnerAdapter adapter = new SpinnerAdapter(this, dropDownList());
        customSpinner.setAdapter(adapter);
        customSpinner.setOnItemSelectedListener(this);
    }

    private ArrayList<DropDownItem> dropDownList() {
        dropDownList = new ArrayList<>();
        dropDownList.add(new DropDownItem("Profile", R.drawable.ic_profile));
        dropDownList.add(new DropDownItem("Post", R.drawable.ic_post));
        dropDownList.add(new DropDownItem("Settings", R.drawable.ic_settings));
        return dropDownList;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        DropDownItem item = (DropDownItem)adapterView.getSelectedItem();
        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<DropDownItem> getDropDownList() {
        return dropDownList;
    }

    public void setDropDownList(ArrayList<DropDownItem> dropDownList) {
        this.dropDownList = dropDownList;
    }
}