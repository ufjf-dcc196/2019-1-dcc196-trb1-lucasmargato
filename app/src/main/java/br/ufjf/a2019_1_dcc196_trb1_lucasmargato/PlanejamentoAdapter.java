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

    private static final int RED = 0xFFAA0000;
    private static final int YELLOW = 0xFFAAAA00;
    private static final int GREEN = 0xFF00AA00;

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
        TextView itemLinguasP = viewHolder.itemLinguasP;
        TextView itemExatasP = viewHolder.itemExatasP;
        TextView itemSaudeP = viewHolder.itemSaudeP;
        TextView itemHumanidadesP = viewHolder.itemHumanidadesP;

        int tl, te, ts, th, total, rl, re, rs, rh;
        tl = p.totalLinguas();
        te = p.totalExatas();
        ts = p.totalSaude();
        th = p.totalHumanidades();
        total = tl + te + ts + th;

        float pl, pe, ps, ph;
        if (tl == 0) {
            pl = 0;
        } else {
            pl = ((float) tl / (float) total) * 100;
        }

        if (te == 0) {
            pe = 0;
        } else {
            pe = ((float) te / (float) total) * 100;
        }

        if (ts == 0) {
            ps = 0;
        } else {
            ps = ((float) ts / (float) total) * 100;
        }

        if (th == 0) {
            ph = 0;
        } else {
            ph = ((float) th / (float) total) * 100;
        }

        rl = Math.round(pl-p.getLinguas());
        re = Math.round(pe-p.getExatas());
        rs = Math.round(ps-p.getSaude());
        rh = Math.round(ph-p.getHumanidades());

        itemAnoSem.setText(String.valueOf(p.getAno()) + " - " + String.valueOf(p.getSemestre()));
        itemLinguas.setText(String.valueOf(p.getLinguas()) + "%");
        itemExatas.setText(String.valueOf(p.getExatas()) + "%");
        itemSaude.setText(String.valueOf(p.getSaude()) + "%");
        itemHumanidades.setText(String.valueOf(p.getHumanidades()) + "%");

        String txt;

        txt = tl + "h (";
        if (rl>0) {
            txt += "+" + rl + "%)";
        } else if (rl<0) {
            txt += rl + "%)";
        } else {
            txt += "OK)";
        }

        if (Math.abs(rl) > 20) {
            itemLinguasP.setTextColor(RED);
        } else if (Math.abs(rl) > 10) {
            itemLinguasP.setTextColor(YELLOW);
        } else {
            itemLinguasP.setTextColor(GREEN);
        }
        itemLinguasP.setText(txt);

        txt = te + "h (";
        if (re>0) {
            txt += "+" + re + "%)";
        } else if (re<0) {
            txt += re + "%)";
        } else {
            txt += "OK)";
        }

        if (Math.abs(re) > 20) {
            itemExatasP.setTextColor(RED);
        } else if (Math.abs(re) > 10) {
            itemExatasP.setTextColor(YELLOW);
        } else {
            itemExatasP.setTextColor(GREEN);
        }
        itemExatasP.setText(txt);

        txt = ts + "h (";
        if (rs>0) {
            txt += "+" + rs + "%)";
        } else if (rs<0) {
            txt += rs + "%)";
        } else {
            txt += "OK)";
        }

        if (Math.abs(rs) > 20) {
            itemSaudeP.setTextColor(RED);
        } else if (Math.abs(rs) > 10) {
            itemSaudeP.setTextColor(YELLOW);
        } else {
            itemSaudeP.setTextColor(GREEN);
        }
        itemSaudeP.setText(txt);

        txt = th + "h (";
        if (rh>0) {
            txt += "+" + rh + "%)";
        } else if (rh<0) {
            txt += rh + "%)";
        } else {
            txt += "OK)";
        }

        if (Math.abs(rh) > 20) {
            itemHumanidadesP.setTextColor(RED);
        } else if (Math.abs(rh) > 10) {
            itemHumanidadesP.setTextColor(YELLOW);
        } else {
            itemHumanidadesP.setTextColor(GREEN);
        }
        itemHumanidadesP.setText(txt);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView itemAnoSem, itemLinguas, itemExatas, itemSaude, itemHumanidades, itemLinguasP, itemExatasP, itemSaudeP, itemHumanidadesP;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemAnoSem = itemView.findViewById(R.id.textAnoSem);
            itemLinguas = itemView.findViewById(R.id.textLinguas);
            itemExatas = itemView.findViewById(R.id.textExatas);
            itemSaude = itemView.findViewById(R.id.textSaude);
            itemHumanidades = itemView.findViewById(R.id.textHumanidades);

            itemLinguasP = itemView.findViewById(R.id.textLinguasP);
            itemExatasP = itemView.findViewById(R.id.textExatasP);
            itemSaudeP = itemView.findViewById(R.id.textSaudeP);
            itemHumanidadesP = itemView.findViewById(R.id.textHumanidadesP);

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
