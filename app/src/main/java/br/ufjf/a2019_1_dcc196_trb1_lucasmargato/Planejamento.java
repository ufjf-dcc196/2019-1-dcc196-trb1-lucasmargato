package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

import android.os.Parcel;
import android.os.Parcelable;

public class Planejamento implements Parcelable {
    protected int ano, semestre;
    protected float linguas, exatas, saude, humanidades;

    public Planejamento(int ano, int semestre, float linguas, float exatas, float saude, float humanidades) {
        this.ano = ano;
        this.semestre = semestre;
        this.linguas = linguas;
        this.exatas = exatas;
        this.saude = saude;
        this.humanidades = humanidades;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public float getLinguas() {
        return linguas;
    }

    public void setLinguas(float linguas) {
        this.linguas = linguas;
    }

    public float getExatas() {
        return exatas;
    }

    public void setExatas(float exatas) {
        this.exatas = exatas;
    }

    public float getSaude() {
        return saude;
    }

    public void setSaude(float saude) {
        this.saude = saude;
    }

    public float getHumanidades() {
        return humanidades;
    }

    public void setHumanidades(float humanidades) {
        this.humanidades = humanidades;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ano);
        dest.writeInt(this.semestre);
        dest.writeFloat(this.linguas);
        dest.writeFloat(this.exatas);
        dest.writeFloat(this.saude);
        dest.writeFloat(this.humanidades);
    }

    public static final Parcelable.Creator<Planejamento> CREATOR = new Parcelable.Creator<Planejamento>() {
        public Planejamento createFromParcel(Parcel in) {
            return new Planejamento(in);
        }

        public Planejamento[] newArray(int size) {
            return new Planejamento[size];
        }
    };


    private Planejamento(Parcel in) {
        this.ano = in.readInt();
        this.semestre = in.readInt();
        this.linguas = in.readFloat();
        this.exatas = in.readFloat();
        this.saude = in.readFloat();
        this.humanidades = in.readFloat();
    }
}
