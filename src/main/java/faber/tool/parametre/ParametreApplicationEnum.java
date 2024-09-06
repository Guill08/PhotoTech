package faber.tool.parametre;

/*
RSI
21/08/2023
08:24
*/public enum ParametreApplicationEnum {
    COUTSUPPLEMENTAIRE("coutSupplementaire"),
    PORTTHEORIQUE("portTheorique");
    private String libelle = "";

    ParametreApplicationEnum(String libelle) {
        this.libelle = libelle;

    }


    public String toString() {
        return libelle;
    }

}
