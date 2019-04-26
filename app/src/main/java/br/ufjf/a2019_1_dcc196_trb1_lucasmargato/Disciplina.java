package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.os.Parcel;
import android.os.Parcelable;

public class Disciplina implements Parcelable {
    protected String nome;
    protected int horas;
    protected Area area;

    public Disciplina (String nome, int horas, Area area) {
        this.nome = nome;
        this.horas = horas;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Disciplina> CREATOR = new Parcelable.Creator<Disciplina>() {
        public Disciplina createFromParcel(Parcel in) {
            return new Disciplina(in);
        }

        public Disciplina[] newArray(int size) {
            return new Disciplina[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeInt(this.horas);
        dest.writeInt(this.area.ordinal());
    }

    private Disciplina (Parcel in){
        this.nome = in.readString();
        this.horas = in.readInt();
        this.area = Area.values()[in.readInt()];
    }
}
