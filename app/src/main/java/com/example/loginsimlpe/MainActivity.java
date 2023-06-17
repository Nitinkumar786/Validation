package com.example.loginsimlpe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText nametext,passtext;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametext = findViewById(R.id.gmail);
        passtext = findViewById(R.id.password);
        loginbtn = findViewById(R.id.btn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String  email = nametext.getText().toString();
               String pass = passtext.getText().toString();


                if (email.isEmpty()){
                   Toast.makeText(MainActivity.this, "Please Enter Email Id", Toast.LENGTH_SHORT).show();
               }
               else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();

               }
               else if (pass.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter Password ", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}