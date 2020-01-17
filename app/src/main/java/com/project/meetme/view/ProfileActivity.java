package com.project.meetme.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.meetme.R;
import com.project.meetme.repos.UserRepository;

import org.w3c.dom.Text;

public class ProfileActivity  extends AppCompatActivity {

    ImageView profile;
    ImageView updateInfos;
    ImageView logout;
    TextView account;
    UserRepository userRepository = new UserRepository();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        account = findViewById(R.id.about);
        account.setText(LoginActivity.loggedUser.toString());
        updateInfos = findViewById(R.id.update_info);
        logout = findViewById(R.id.logout);
        profile = findViewById(R.id.profile);
        profile.animate();

        updateInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ProfileActivity.this, UpdateUserDetailsActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });


    }
}
