package edu.cnm.deepdive.temperaturechanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  private EditText fET, cET, kET;
  private Button but1, but2, but3, but4, but5, but6, but7;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
    initButton();
  }

  private void initView() {
    fET = findViewById(R.id.editTextF);
    cET = findViewById(R.id.editTextC);
    kET = findViewById(R.id.editTextK);
  }

  private void initButton() {
    but1 = findViewById(R.id.button1);
    but1.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(fET.getText().toString());
        value = (value - 32) * 5 / 9;
        cET.setText(Double.toString(value));
      }
    });

    but2 = findViewById(R.id.button2);
    but2.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(fET.getText().toString());
        value = ((value - 32) * 5 / 9) + 273.15;
        kET.setText(Double.toString(value));
      }
    });

    but3 = findViewById(R.id.button3);
    but3.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(cET.getText().toString());
        value = (value * 9 / 5) + 32;
        fET.setText(Double.toString(value));
      }
    });

    but4 = findViewById(R.id.button4);
    but4.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(cET.getText().toString());
        value = value + 273.15;
        kET.setText(Double.toString(value));
      }
    });

    but5 = findViewById(R.id.button5);
    but5.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(kET.getText().toString());
        value = ((value - 273.15) * 9 / 5 + 32);
        fET.setText(Double.toString(value));
      }
    });

    but6 = findViewById(R.id.button6);
    but6.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(kET.getText().toString());
        value = value - 273.15;
        cET.setText(Double.toString(value));
      }
    });

    but7 = findViewById(R.id.button7);
    but7.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        fET.setText(null);
        cET.setText(null);
        kET.setText(null);
      }
    });
  }
}
