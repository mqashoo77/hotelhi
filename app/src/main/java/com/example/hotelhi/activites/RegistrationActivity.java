package com.example.hotelhi.activites;

//import static com.hbb20.countrypicker.dialog.CPDialogExtensionKt.launchCountryPickerDialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
//import com.hbb20.CountryPickerView;
//import com.hbb20.countrypicker.models.CPCountry;

public class RegistrationActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference mRootRef;
    private EditText userFirstName;
    private EditText userLastName;
    private EditText userPhoneNumber;
    private EditText userEmail;
    private EditText userPassword;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        userFirstName = findViewById(R.id.editTextFirstName);
        userLastName = findViewById(R.id.editTextLastName);
        userPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        userEmail = findViewById(R.id.editTextEmail);
        userPassword = findViewById(R.id.editTextPassword);
        register = findViewById(R.id.buttonRegister);
        auth = FirebaseAuth.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtUserFirstName = userFirstName.getText().toString();
                String txtUserLastName = userLastName.getText().toString();
                String txtUserPhoneNumber = userPhoneNumber.getText().toString();
                String txtUserEmail = userEmail.getText().toString();
                String txtUserPassword = userPassword.getText().toString();

                if (TextUtils.isEmpty(txtUserFirstName) || TextUtils.isEmpty(txtUserLastName)
                        || TextUtils.isEmpty(txtUserPhoneNumber) || TextUtils.isEmpty(txtUserEmail)
                        || TextUtils.isEmpty(txtUserPassword)){
                    Toast.makeText(RegistrationActivity.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txtUserPassword.length() < 6){
                    Toast.makeText(RegistrationActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txtUserFirstName , txtUserLastName , txtUserPhoneNumber , txtUserEmail,txtUserPassword);
                }
            }
        });

    }
    private void registerUser(final String firstName, final String lastName, final String phoneNumber, final String email, String password) {

        auth.createUserWithEmailAndPassword(email , password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                HashMap<String , Object> map = new HashMap<>();
                map.put("First Name" , firstName);
                map.put("Last Name", lastName);
                map.put("Phone Number", phoneNumber);
                map.put("Email", email);
                map.put("Password",password);
                map.put("id" , auth.getCurrentUser().getUid());


                mRootRef.child("Users").child(auth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this,
                                    "Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegistrationActivity.this , LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(RegistrationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}