package com.example.passingdata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

    public class SecondActivity extends MainActivity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            // Get the data passed in using getStringExtra()
            Toast.makeText(this, getIntent().getStringExtra("str1"),
                    Toast.LENGTH_SHORT).show();

            // Get the data passed in using getIntExtra
            Toast.makeText(this, Integer.toString(
                    getIntent().getIntExtra("age1", 0)),
                    Toast.LENGTH_SHORT).show();

            // Get the bundle object passed in
            Bundle bundle = getIntent().getExtras();

            // Get the data using the getString()
            Toast.makeText(this, bundle.getString("str2"),
                    Toast.LENGTH_SHORT).show();

            // Get the data using the getInt method
            Toast.makeText(this, Integer.toString(bundle.getInt("age2")),
                    Toast.LENGTH_SHORT).show();
        }

        public void onClick(View view) {
            // Use an Intent object to return data
            Intent i = new Intent();
            // Use the putExtra method to return some value
            i.putExtra("age3", 45);
            // Use the setData() method to return some value
            i.setData(Uri.parse("Something passed back to main activity"));
            // Set the result with Ok and the Intent object
            setResult(RESULT_OK, i);
            // Destroy the current activity
            finish();

        }
    }



