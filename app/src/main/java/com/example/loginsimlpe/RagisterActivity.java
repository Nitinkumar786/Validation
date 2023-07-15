package com.example.loginsimlpe;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RagisterActivity extends AppCompatActivity {
    EditText gmaill,passwordd;
    Button bttn;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);
        gmaill = findViewById(R.id.gmaill);
        passwordd = findViewById(R.id.passwordd);
        bttn = findViewById(R.id.bttn1);
        mAuth = FirebaseAuth.getInstance();

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill,passs;
                emaill = String.valueOf(gmaill.getText());
                passs = String.valueOf(passwordd.getText());
                if (TextUtils.isEmpty(emaill)){
                    Toast.makeText(RagisterActivity.this, "Enter the Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passs)){
                    Toast.makeText(RagisterActivity.this, "Enter the Password", Toast.LENGTH_SHORT).show();
                }

                mAuth.createUserWithEmailAndPassword(emaill, passs)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RagisterActivity.this, "Account created",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Home.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RagisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }
}