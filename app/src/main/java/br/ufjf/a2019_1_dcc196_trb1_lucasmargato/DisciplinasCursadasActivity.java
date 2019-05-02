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


public class DisciplinasCursadasActivity extends AppCompatActivity {

    public static final int NOVA_DISCIPLINA = 1;
    public static final int DETALHES_PLANEJAMENTO = 2;

    DisciplinaAdapter adapter;
    Planejamento p;
    int pos;
    Intent resultado;



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
            pos = bundle.getInt("pos");

            adapter  = new DisciplinaAdapter(p.getDisciplinas());
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(this));



            if (p.getDisciplinas().isEmpty()) {
                Toast.makeText(DisciplinasCursadasActivity.this, "Sem disciplinas", Toast.LENGTH_SHORT).show();
            }

            resultado = new Intent();
            resultado.putExtra("pos", pos);

        } else {
            finish();
        }



        adapter.setOnItemLongClickListener(new DisciplinaAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View itemView, final int position) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                p.getDisciplinas().remove(position);
                                resultado.putExtra("plan", p);
                                setResult(RESULT_CANCELED, resultado);
                                adapter.notifyDataSetChanged();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(DisciplinasCursadasActivity.this);
                builder.setMessage("Remover a disciplina " + p.getDisciplina(position).getNome() + "?").setPositiveButton("Sim", dialogClickListener).setNegativeButton("Não", dialogClickListener).show();

            }
        });

        btnNovaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisciplinasCursadasActivity.this, NovaDisciplinaCursadaActivity.class);
                startActivityForResult(intent, NOVA_DISCIPLINA);
            }
        });

        btnDetalhesPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                intent.putExtra("plan", p);
                startActivityForResult(intent, DETALHES_PLANEJAMENTO);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case NOVA_DISCIPLINA:
                    p.addDisciplina((Disciplina) data.getParcelableExtra("novaDisciplina"));
                    resultado.putExtra("plan", p);
                    setResult(RESULT_CANCELED, resultado);
                    adapter.notifyDataSetChanged();
                    break;
                case DETALHES_PLANEJAMENTO:
                    p = (Planejamento) data.getParcelableExtra("planAtualizado");
                    resultado.putExtra("plan", p);
                    setResult(RESULT_CANCELED, resultado);
                    adapter.notifyDataSetChanged();
                default:
                    break;
            }
        }
    }
}
