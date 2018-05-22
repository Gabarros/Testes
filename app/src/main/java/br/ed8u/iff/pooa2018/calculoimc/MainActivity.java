package br.ed8u.iff.pooa2018.calculoimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Float.parseFloat;


public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;

    private TextView tvResultado;
    private TextView tvImc;

    private Button btLimpar;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);

        btCalcular = (Button) findViewById(R.id.btCalIMC);
        btLimpar = (Button) findViewById(R.id.btLimpar);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvImc = (TextView) findViewById(R.id.tvImc);

        btCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                calcular();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAltura.setText("");
                etPeso.setText("");
            }
        });


    }


            public void calcular() {

                float imc;
                float peso;
                float altura;


                peso = Float.parseFloat(etPeso.getText().toString());
                altura = Float.parseFloat(etAltura.getText().toString());

                imc = peso/(altura*altura);

                mostra_mensagem(imc);
            }

            public void mostra_mensagem(float imc){
                   String msg = "";


                    if (imc < 17.0){
                        msg = "Você está muito abaixo do Peso!";
                    }
                    if (imc > 17.0 && imc < 18.49){
                        msg = "Você está abaixo do Peso!";
                    }
                    if (imc >18.50 && imc < 24.99){
                        msg = "Você está no Peso normal!";
                    }
                    if (imc > 25.0 && imc < 29.99){
                        msg = "Você está acima do Peso!";
                    }
                    if (imc > 30.0 && imc < 34.99){
                        msg = "Você está em Obesidade Grau I!";
                    }
                    if (imc > 35.0 && imc < 39.99 ){
                        msg = "Você está em Obesidade Grau II!";
                    }
                    if (imc > 40.0){
                        msg = "Você está em Obesidade Grau III CUIDADO!";
                    }


                    tvResultado.setText(msg);
                    tvImc.setText(String.valueOf(imc));
                }
    }



