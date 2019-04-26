package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisciplinasCursadasActivity extends AppCompatActivity {

    public static final int NOVA_DISCIPLINA = 1;
    public static final int DETALHES_PLANEJAMENTO = 2;

    DisciplinaAdapter adapter;
    Planejamento p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);
        RecyclerView rv = findViewById(R.id.rvDisciplinas);
        Button btnNovaDisciplina = findViewById(R.id.buttonNovaDisciplina);
        Button btnDetalhesPlanejamento = findViewById(R.id.buttonDetalhesPlanejamento);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            p = bundle.getParcelable("plan");
            if (!p.getDisciplinas().isEmpty()) {
                adapter  = new DisciplinaAdapter(p.getDisciplinas());
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(this));
            } else {
                Toast.makeText(DisciplinasCursadasActivity.this, "Sem disciplinas", Toast.LENGTH_SHORT).show();
            }
        } else {
            finish();
        }



        btnNovaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(DisciplinasCursadasActivity.this, NovoPlanejamentoActivity.class);
                //startActivityForResult(intent, NOVA_DISCIPLINA);
            }
        });

        btnDetalhesPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(DisciplinasCursadasActivity.this, NovoPlanejamentoActivity.class);
                //startActivityForResult(intent, DETALHES_PLANEJAMENTO);
            }
        });
    }
}
