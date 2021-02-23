package com.example.unaiza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.unaiza.Buyers.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class LogoutActivity extends AppCompatActivity {

    private TextView logout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        logout = findViewById(R.id.LogOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().destroy();

                firebaseAuth.getInstance().signOut();
                onDestroy();

                Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
                //Intent intent = new Intent(getActivity().getApplication(), MainActivity.class);
                // startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);


            }
        });
    }
}