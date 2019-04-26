package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DisciplinaAdapter  extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {
    private final List<Disciplina> items;
    private DisciplinaAdapter.OnItemClickListener listener;

    public DisciplinaAdapter(List<Disciplina> items) { this.items = items; }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.layout_disciplina, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Disciplina d = items.get(i);
        TextView itemNome = viewHolder.itemNome;
        TextView itemHoras  = viewHolder.itemHoras;
        TextView itemArea = viewHolder.itemArea;


        itemNome.setText(String.valueOf(d.getNome()));
        itemHoras.setText(String.valueOf(d.getHoras()));
        itemArea.setText(String.valueOf(d.getArea()));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView itemNome, itemHoras, itemArea;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemNome = itemView.findViewById(R.id.textDiscNome);
            itemHoras = itemView.findViewById(R.id.textDiscHoras);
            itemArea = itemView.findViewById(R.id.textDiscArea);


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
