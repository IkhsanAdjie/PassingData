package com.example.passingdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent i = new Intent("com.example.passingdata.SecondActivity");

        // Use putExtra() to add new name/value pairs
        i.putExtra("str1","This is a string");
        i.putExtra("age1",25);

        // Use a bundle object to add new name/values pairs
        Bundle extras = new Bundle();
        extras.putString("str2","This is another string");
        extras.putInt("age2",35);

        // Attach the bundle object to the Intent object
        i.putExtras(extras);

        // Start the activity to get a result back
        startActivityForResult(i,1);
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        // Check if the request code is 1
        if(requestCode == 1){
            //if the result is OK
            if(resultCode == RESULT_OK){
                // Get the result using getIntExtra()
                Toast.makeText(this,Integer.toString(data.getIntExtra("age3",0)),
                        Toast.LENGTH_SHORT).show();
                //Get the result using getData()
                Toast.makeText(this,data.getData().toString(),
                        Toast.LENGTH_SHORT).show();

            }
        }
    }
}