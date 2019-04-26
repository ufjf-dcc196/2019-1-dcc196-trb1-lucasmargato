package br.ufjf.a2019_1_dcc196_trb1_lucasmargato;

public enum Area {
    LINGUAS, EXATAS, SAUDE, HUMANIDADES;

    public static Area getArea(String s){
        if (s == "LINGUAS") {
            return Area.LINGUAS;
        } else if (s == "EXATAS") {
            return Area.EXATAS;
        } else if (s == "SAUDE") {
            return Area.SAUDE;
        }else if (s == "HUMANIDADES") {
            return Area.HUMANIDADES;
        } else {
            return null;
        }
    }
}
