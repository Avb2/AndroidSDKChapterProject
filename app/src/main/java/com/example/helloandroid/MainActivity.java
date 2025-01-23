package com.example.helloandroid;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clearButton), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initDisplayButton();
    }


    private void initDisplayButton() {
        // Assign widget to Object by id
        Button displayButton = findViewById(R.id.buttonDisplay);

        // Set listener to display button
        displayButton.setOnClickListener(l -> {
            EditText editName = findViewById(R.id.editTextName);
            TextView textDisplay = findViewById(R.id.textViewDisplay);

            // !!! Injecting string defined in xml to resource
            Resources res = getResources();
            String msg = res.getString(R.string.welcome_message, editName.getText());

            textDisplay.setText(msg);
        });
    }
}


