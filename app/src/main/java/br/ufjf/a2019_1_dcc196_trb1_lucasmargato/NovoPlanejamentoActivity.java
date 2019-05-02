package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NovoPlanejamentoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);

        final EditText ano = findViewById(R.id.editNovoAno);
        final EditText semestre = findViewById(R.id.editNovoSemestre);
        final EditText linguas = findViewById(R.id.editNovoLinguas);
        final EditText exatas = findViewById(R.id.editNovoExatas);
        final EditText saude = findViewById(R.id.editNovoSaude);
        final EditText humanidades = findViewById(R.id.editNovoHumanidades);
        Button btnConfirmar = findViewById(R.id.buttonNovoConfirma);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pano, psemestre;
                float plinguas, pexatas, psaude, phumanidades;

                pano = Integer.parseInt(ano.getText().toString());
                psemestre = Integer.parseInt(semestre.getText().toString());
                plinguas = Float.parseFloat(linguas.getText().toString());
                pexatas = Float.parseFloat(exatas.getText().toString());
                psaude = Float.parseFloat(saude.getText().toString());
                phumanidades = Float.parseFloat(humanidades.getText().toString());

                if (plinguas + pexatas + psaude + phumanidades != 100) {
                    Toast.makeText(NovoPlanejamentoActivity.this, "O planejamento das áreas precisa somar 100% !!!", Toast.LENGTH_LONG).show();
                } else {
                    Intent resultado = new Intent();
                    Planejamento p = new Planejamento(
                            pano,
                            psemestre,
                            plinguas,
                            pexatas,
                            psaude,
                            phumanidades
                    );

                    resultado.putExtra("novoPlanejamento", p);
                    setResult(RESULT_OK, resultado);
                    finish();
                }
            }
        });
    }


}
