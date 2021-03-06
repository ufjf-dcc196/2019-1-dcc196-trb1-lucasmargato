package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
    public static final int DISCIPLINAS_CURSADAS = 2;
    PlanejamentoAdapter adapter;

    public List<Planejamento> plans = new ArrayList<Planejamento>() {{
        add(new Planejamento(2018, 1, 25, 50, 0, 25));
        add(new Planejamento(2018, 2, 40, 20, 20, 20));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);
        RecyclerView rv = findViewById(R.id.rvPlanejamentos);
        Button btnNovo = findViewById(R.id.buttonNovo);

        plans.get(0).addDisciplina(new Disciplina("Cálculo", 60, Area.EXATAS));
        plans.get(0).addDisciplina(new Disciplina("Física", 60, Area.EXATAS));
        plans.get(0).addDisciplina(new Disciplina("Geografia", 20, Area.HUMANIDADES));
        plans.get(0).addDisciplina(new Disciplina("Inglês", 60, Area.LINGUAS));
        plans.get(0).addDisciplina(new Disciplina("Farmacologia", 60, Area.SAUDE));


        plans.get(1).addDisciplina(new Disciplina("Português", 40, Area.LINGUAS));
        plans.get(1).addDisciplina(new Disciplina("Matemática", 30, Area.EXATAS));
        plans.get(1).addDisciplina(new Disciplina("Anatomia", 10, Area.SAUDE));
        plans.get(1).addDisciplina(new Disciplina("História", 20, Area.HUMANIDADES));


        adapter = new PlanejamentoAdapter(this.plans);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new PlanejamentoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                intent.putExtra("plan", plans.get(position));
                intent.putExtra("pos", position);

                startActivityForResult(intent, DISCIPLINAS_CURSADAS);
            }
        });

        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
                startActivityForResult(intent, NOVO_PLANEJAMENTO);
            }
        });

        adapter.setOnItemLongClickListener(new PlanejamentoAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View itemView, final int position) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                plans.remove(position);
                                adapter.notifyItemRemoved(position);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(PlanejamentosActivity.this);
                builder.setMessage("Remover o planejamento " + plans.get(position).getAno() + " - " + plans.get(position).getSemestre() + "?")
                        .setPositiveButton("Sim", dialogClickListener).setNegativeButton("Não", dialogClickListener).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            switch (requestCode) {
                case NOVO_PLANEJAMENTO:
                    if (resultCode == Activity.RESULT_OK) {
                        plans.add((Planejamento) data.getParcelableExtra("novoPlanejamento"));
                        adapter.notifyDataSetChanged();
                    }
                    break;
                case DISCIPLINAS_CURSADAS:
                    int t = data.getIntExtra("pos", -1);
                    if (t != -1) {
                        plans.set(t, (Planejamento) data.getParcelableExtra("plan"));
                        adapter.notifyDataSetChanged();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
