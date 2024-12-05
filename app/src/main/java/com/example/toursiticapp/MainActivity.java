package com.example.toursiticapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView likeCounter;
    private Button likeButton;
    private Button likeClearButton;
    private EditText email;
    private EditText password_1;
    private EditText password_2;
    private Button saveDataButton;
    private Button showButton;
    private TextView info;
    private int count = 0;
    private String tempUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Licznik
        likeCounter = findViewById(R.id.likeCounter);
        likeCounter = findViewById(R.id.likeCounter);
        likeButton = findViewById(R.id.likeButton);
        likeClearButton = findViewById(R.id.likeClearButton);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                likeCounter.setText(String.valueOf(count) + " polubień");
            }
        });

        likeClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count!=0){
                    count--;
                    likeCounter.setText(String.valueOf(count) + " polubień");
                }
            }
        });

        //Formularz

        email = findViewById(R.id.email);
        password_1 = findViewById(R.id.pas1);
        password_2 = findViewById(R.id.pas2);
        saveDataButton = findViewById(R.id.saveDataButton);
        showButton = findViewById(R.id.showButton);
        info = findViewById(R.id.info);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int validatePoint = 0;

                if(email.getText().toString().contains("@")){
                    validatePoint++;
                } else {
                    info.setText("Nieprawidłowy adres e-mai");
                }

                if(password_1.getText().toString().equals(password_2.getText().toString())) {
                    validatePoint++;
                }else{
                    info.setText("Hasła się różnią");
                }

                if(validatePoint==2){
                    info.setText("Zarejestrowano: " + email.getText().toString());
                    tempUser = email.getText().toString();
                }
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(tempUser);
            }
        });

    }
}