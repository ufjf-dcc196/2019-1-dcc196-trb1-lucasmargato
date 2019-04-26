package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NovaDisciplinaCursadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina_cursada);

        final EditText nome = findViewById(R.id.editNovaDiscNome);
        final EditText horas = findViewById(R.id.editNovaDiscHoras);
        final Spinner area = findViewById(R.id.spinnerNovaDiscArea);
        Button btnConfirmar = findViewById(R.id.buttonNovaDiscConfirma);

        area.setAdapter(new ArrayAdapter<Area>(this, android.R.layout.simple_selectable_list_item, Area.values()));


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                Disciplina d = new Disciplina(
                        nome.getText().toString(),
                        Integer.parseInt(horas.getText().toString()),
                        Area.getArea(area.getSelectedItem().toString())
                );

                resultado.putExtra("novaDisciplina", d);
                setResult(RESULT_OK, resultado);
                finish();
            }
        });
    }
}
