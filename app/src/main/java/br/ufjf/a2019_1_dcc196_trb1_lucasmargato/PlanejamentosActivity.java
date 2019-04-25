package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlanejamentosActivity extends AppCompatActivity {

    public List<Planejamento> plans = new ArrayList<Planejamento>(){{
        add(new Planejamento(2018, 1, 25, 25, 25, 25));
        add(new Planejamento(2018, 2, 40, 20, 20, 20));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);

        RecyclerView rv = findViewById(R.id.rvPlanejamentos);
        PlanejamentoAdapter adapter = new PlanejamentoAdapter(this.plans);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new PlanejamentoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(PlanejamentosActivity.this, String.valueOf(plans.get(position).getAno()+" - "+plans.get(position).getSemestre()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}