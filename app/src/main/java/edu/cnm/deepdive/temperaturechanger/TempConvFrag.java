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

    but3 = view.findViewById(R.id.button3);
    but3.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(cET.getText().toString());
        value = (value * 9 / 5) + 32;
        fET.setText(Double.toString(value));
      }
    });

    but4 = view.findViewById(R.id.button4);
    but4.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(cET.getText().toString());
        value = value + 273.15;
        kET.setText(Double.toString(value));
      }
    });

    but5 = view.findViewById(R.id.button5);
    but5.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(kET.getText().toString());
        value = ((value - 273.15) * 9 / 5 + 32);
        fET.setText(Double.toString(value));
      }
    });

    but6 = view.findViewById(R.id.button6);
    but6.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        double value = Double.valueOf(kET.getText().toString());
        value = value - 273.15;
        cET.setText(Double.toString(value));
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
