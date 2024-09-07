package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button cButton;
    private Button fButton;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.edit_Text);
        cButton = findViewById(R.id.c_button);
        fButton = findViewById(R.id.f_button);
        textView = findViewById(R.id.text_view);
        textView2 = findViewById(R.id.text_view2);

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editText.getText().toString();
                if (!input.isEmpty()) {
                    double fahrenheit = Double.parseDouble(input);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    textView.setText(String.format("%.0f", celsius)+"°C");
                } else {
                    showToast("Please enter a value.");
                }
            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editText.getText().toString();
                if (!input.isEmpty()) {
                    double celsius = Double.parseDouble(input);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    textView.setText(String.format("%.0f", fahrenheit)+"°F");
                } else {
                    showToast("Please enter a value.");
                }
            }
        });
    }



    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
