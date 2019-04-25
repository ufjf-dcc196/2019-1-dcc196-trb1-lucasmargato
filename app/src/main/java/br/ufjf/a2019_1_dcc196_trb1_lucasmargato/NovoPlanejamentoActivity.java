package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Intent resultado = new Intent();
                Planejamento p = new Planejamento(
                        Integer.parseInt(ano.getText().toString()),
                        Integer.parseInt(semestre.getText().toString()),
                        Integer.parseInt(linguas.getText().toString()),
                        Integer.parseInt(exatas.getText().toString()),
                        Integer.parseInt(saude.getText().toString()),
                        Integer.parseInt(humanidades.getText().toString())
                );

                resultado.putExtra("novoPlanejamento", p);
                setResult(RESULT_OK, resultado);
                finish();
            }
        });
    }


}
