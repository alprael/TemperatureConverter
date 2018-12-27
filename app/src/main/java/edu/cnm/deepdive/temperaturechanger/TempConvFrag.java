package edu.cnm.deepdive.temperaturechanger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TempConvFrag extends Fragment {

  private EditText fET, cET, kET;
  private Button but1, but2, but3, but4, but5, but6, but7;
  private View view;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    view = inflater.inflate(R.layout.temp_conv, container, false);
    initView();
    initButton();
    return view;
  }

  private void initView() {
    fET = view.findViewById(R.id.editTextF);
    cET = view.findViewById(R.id.editTextC);
    kET = view.findViewById(R.id.editTextK);
  }

  private void initButton() {
    but1 = view.findViewById(R.id.button1);
    but1.setEnabled(false);
      but1.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          double value = Double.valueOf(fET.getText().toString());
          value = (value - 32) * 5 / 9;
          cET.setText(Double.toString(value));
        }
      });

    but2 = view.findViewById(R.id.button2);
    but2.setEnabled(false);
    but2.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(fET.getText().toString());
        value = ((value - 32) * 5 / 9) + 273.15;
        kET.setText(Double.toString(value));
      }
    });

    fET.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        String fahrenheit = fET.getText().toString().trim();
        but1.setEnabled(!fahrenheit.isEmpty());
        but2.setEnabled(!fahrenheit.isEmpty());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });

    but3 = view.findViewById(R.id.button3);
    but3.setEnabled(false);
    but3.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(cET.getText().toString());
        value = (value * 9 / 5) + 32;
        fET.setText(Double.toString(value));
      }
    });

    but4 = view.findViewById(R.id.button4);
    but4.setEnabled(false);
    but4.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(cET.getText().toString());
        value = value + 273.15;
        kET.setText(Double.toString(value));
      }
    });

    cET.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        String celsius = cET.getText().toString().trim();
        but3.setEnabled(!celsius.isEmpty());
        but4.setEnabled(!celsius.isEmpty());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });

    but5 = view.findViewById(R.id.button5);
    but5.setEnabled(false);
    but5.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(kET.getText().toString());
        value = ((value - 273.15) * 9 / 5 + 32);
        fET.setText(Double.toString(value));
      }
    });

    but6 = view.findViewById(R.id.button6);
    but6.setEnabled(false);
    but6.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(kET.getText().toString());
        value = value - 273.15;
        cET.setText(Double.toString(value));
      }
    });

    kET.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        String kelvin = kET.getText().toString().trim();
        but5.setEnabled(!kelvin.isEmpty());
        but6.setEnabled(!kelvin.isEmpty());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });

    but7 = view.findViewById(R.id.button7);
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
