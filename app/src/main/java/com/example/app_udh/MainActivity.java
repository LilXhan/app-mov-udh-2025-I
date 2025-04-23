package com.example.app_udh;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    Button btnSaludo, btnDespedida, btnSumar;


    EditText etNro1, etNro2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNro1 = findViewById(R.id.etnro1);
        etNro2 = findViewById(R.id.etnro2);
    }
    public void fijarAlarma(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Marcar salida")
                .putExtra(AlarmClock.EXTRA_HOUR, 8)
                .putExtra(AlarmClock.EXTRA_MINUTES, 5);

        startActivity(intent);
    }

    public void sumar(View view) {
        int nro1 = Integer.parseInt(etNro1.getText().toString());
        int nro2 = Integer.parseInt(etNro2.getText().toString());

        int suma = nro1 + nro2;

        Toast.makeText(MainActivity.this, "la suma es: " + suma, Toast.LENGTH_LONG).show();
    }
}