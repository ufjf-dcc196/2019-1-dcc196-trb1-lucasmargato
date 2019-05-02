package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlanejamentoAdapter extends RecyclerView.Adapter<PlanejamentoAdapter.ViewHolder> {
    private final List<Planejamento> items;
    private OnItemClickListener listener;

    public PlanejamentoAdapter(List<Planejamento> items) { this.items = items; }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.layout_planejamento, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Planejamento p = items.get(i);
        TextView itemAnoSem = viewHolder.itemAnoSem;
        TextView itemLinguas = viewHolder.itemLinguas;
        TextView itemExatas = viewHolder.itemExatas;
        TextView itemSaude = viewHolder.itemSaude;
        TextView itemHumanidades = viewHolder.itemHumanidades;

        itemAnoSem.setText(String.valueOf(p.getAno()) + " - " + String.valueOf(p.getSemestre()));
        itemLinguas.setText(String.valueOf(p.getLinguas()));
        itemExatas.setText(String.valueOf(p.getExatas()));
        itemSaude.setText(String.valueOf(p.getSaude()));
        itemHumanidades.setText(String.valueOf(p.getHumanidades()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView itemAnoSem, itemLinguas, itemExatas, itemSaude, itemHumanidades;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemAnoSem = itemView.findViewById(R.id.textAnoSem);
            itemLinguas = itemView.findViewById(R.id.textLinguas);
            itemExatas = itemView.findViewById(R.id.textExatas);
            itemSaude = itemView.findViewById(R.id.textSaude);
            itemHumanidades = itemView.findViewById(R.id.textHumanidades);


            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position !=RecyclerView.NO_POSITION){
                listener.onItemClick(v, position);
            }
        }
    }



}
