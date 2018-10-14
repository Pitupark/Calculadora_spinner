package com.example.user.calculadora_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private Spinner spn;
    private Button btnc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv1 = (TextView)findViewById(R.id.tv1);
        spn = (Spinner)findViewById(R.id.spn);
        btnc = (Button)findViewById(R.id.btnc);
        btnc.setOnClickListener(this);
        //spn.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        String[] operaciones = {"Operaciones","Sumar","Restar","Multiplicar","Dividir"};
        ArrayAdapter<String> opera = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operaciones);
        spn.setAdapter(opera);
    }

    @Override
    public void onClick(View view) {
        String text, text2;
        String seleccion = spn.getSelectedItem().toString();

        Double resultado = 0.;

        text = String.valueOf(et1.getText());
        text2 = String.valueOf(et2.getText());

        switch (seleccion) {
            case "Sumar":
                resultado = Double.valueOf(text) + Double.valueOf(text2);
                tv1.setText(String.valueOf(resultado));
                break;
            case "Restar":
                resultado = Double.valueOf(text) - Double.valueOf(text2);
                tv1.setText(String.valueOf(resultado));
                break;
            case "Multiplicar":
                resultado = Double.valueOf(text) * Double.valueOf(text2);
                tv1.setText(String.valueOf(resultado));
                break;
            case "Dividir":
                if(Double.valueOf(text2) == 0){
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_LONG).show();
                }else {
                    resultado = Double.valueOf(text) / Double.valueOf(text2);
                    tv1.setText(String.valueOf(resultado));
                    break;
                }
        }
        tv1.setText(String.format("%.2f", resultado));
    }

}
