package br.ed8u.iff.pooa2018.calculoimc;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Float.parseFloat;


public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private Button btCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);

        btCalcular = (Button) findViewById(R.id.btCalIMC);

        tvResultado = (TextView)  findViewById(R.id.tvResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.O)
            @RequiresApi(api = Build.VERSION_CODES.O)

            public void calcular(){

                float imc;
                float peso;
                float altura;
                String msg;

                peso = Float.parseFloat(etPeso.getText().toString());
                altura = Float.parseFloat(etAltura.getText().toString());

                imc = peso / altura * altura;


                msg = "";

                tvResultado.setText((String.valueOf(imc).concat(msg)));


                if (imc < 17.0){

                }
                if (imc > 17.0 && imc < 18.49){

                }
                if (imc >18.50 && imc < 24.99){

                }





            }

            @TargetApi(Build.VERSION_CODES.O)
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                calcular();
            }


        });



    }
}
