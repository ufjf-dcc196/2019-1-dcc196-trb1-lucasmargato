package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlanejamentosActivity extends AppCompatActivity {

    public static final int NOVO_PLANEJAMENTO = 1;
    PlanejamentoAdapter adapter;

    public List<Planejamento> plans = new ArrayList<Planejamento>(){{
        add(new Planejamento(2018, 1, 25, 25, 25, 25));
        add(new Planejamento(2018, 2, 40, 20, 20, 20));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);
        RecyclerView rv = findViewById(R.id.rvPlanejamentos);
        Button btnNovo = findViewById(R.id.buttonNovo);

        plans.get(0).addDisciplina(new Disciplina("Portuga", 30, Area.LINGUAS));


        adapter  = new PlanejamentoAdapter(this.plans);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new PlanejamentoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                intent.putExtra("plan", plans.get(position));

                startActivity(intent);

                //Toast.makeText(PlanejamentosActivity.this, String.valueOf(plans.get(position).getAno()+" - "+plans.get(position).getSemestre()), Toast.LENGTH_SHORT).show();
            }
        });

        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
                startActivityForResult(intent, NOVO_PLANEJAMENTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case NOVO_PLANEJAMENTO:
                    plans.add((Planejamento) data.getParcelableExtra("novoPlanejamento"));
                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    }
}
