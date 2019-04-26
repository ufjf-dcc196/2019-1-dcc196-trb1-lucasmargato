package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetalhesPlanejamentoActivity extends AppCompatActivity {

    Planejamento p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_planejamento);

        final EditText ano = findViewById(R.id.editDetAno);
        final EditText semestre = findViewById(R.id.editDetSemestre);
        final EditText linguas = findViewById(R.id.editDetLinguas);
        final EditText exatas = findViewById(R.id.editDetExatas);
        final EditText saude = findViewById(R.id.editDetSaude);
        final EditText humanidades = findViewById(R.id.editDetHumanidades);
        Button btnAtualizar = findViewById(R.id.buttonDetAtualiza);

        p = getIntent().getParcelableExtra("plan");

        ano.setText(String.valueOf(p.getAno()));
        semestre.setText(String.valueOf(p.getSemestre()));
        linguas.setText(String.valueOf(p.getLinguas()));
        exatas.setText(String.valueOf(p.getExatas()));
        saude.setText(String.valueOf(p.getSaude()));
        humanidades.setText(String.valueOf(p.getHumanidades()));

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();

                p.setAno(Integer.parseInt(ano.getText().toString()));
                p.setSemestre(Integer.parseInt(semestre.getText().toString()));
                p.setLinguas(Float.parseFloat(linguas.getText().toString()));
                p.setExatas(Float.parseFloat(exatas.getText().toString()));
                p.setSaude(Float.parseFloat(saude.getText().toString()));
                p.setHumanidades(Float.parseFloat(humanidades.getText().toString()));

                resultado.putExtra("planAtualizado", p);
                setResult(RESULT_OK, resultado);
                finish();
            }
        });
    }
}
