package com.project.meetme.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.R;
import com.project.meetme.model.User;
import com.project.meetme.repos.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etName;
    EditText etPhone;
    EditText etPassword;
    EditText etConfirmPassword;
    Button register;

    private FirebaseAuth firebaseAuth;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userRepository = new UserRepository();

        etEmail = findViewById(R.id.etEmailRegister);
        etName = findViewById(R.id.etNameRegister);
        etPhone = findViewById(R.id.etPhoneRegister);
        etPassword = findViewById(R.id.etPasswordRegister);
        etConfirmPassword = findViewById(R.id.etConfirmPasswordRegister);
        register = findViewById(R.id.buttonRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = etEmail.getText().toString();
                final String name = etName.getText().toString();
                final String phoneStr = etPhone.getText().toString();
                final Long phone = Long.parseLong(phoneStr);
                final String password = etPassword.getText().toString();
                final String confirmPassword = etConfirmPassword.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful() && password.equals(confirmPassword)) {
                                    User user = new User(name, email, password, phone);
                                    userRepository.create(user);
                                    startActivity(new Intent(RegisterActivity.this, ProfileActivity.class));
                                } else {
                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                );
            }
        });
    }
}
