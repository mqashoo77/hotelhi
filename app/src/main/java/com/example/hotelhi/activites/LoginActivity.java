package com.example.hotelhi.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotelhi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    private Button login;
    private Button dontHaveAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.editTextEmailLogin);
        password = findViewById(R.id.editTextPasswordLogin);
        login = findViewById(R.id.buttonLogin);
        dontHaveAccount = findViewById(R.id.buttonNoAccount);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(view -> {
            String txt_email = email.getText().toString();
            String txt_password = password.getText().toString();
            if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(LoginActivity.this, "Empty Credentials!", Toast.LENGTH_SHORT).show();
            } else {
                loginUser(txt_email, txt_password);
            }
        });


        dontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
            System.out.println(authResult.getUser().getEmail());
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        });
    }
}