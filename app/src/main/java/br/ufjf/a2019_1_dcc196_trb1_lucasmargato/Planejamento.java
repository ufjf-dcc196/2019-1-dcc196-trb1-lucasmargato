package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

public class Planejamento {
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
}
