package rh.javapleno.usuario.enums;

public enum Situacao{

    INATIVO("INATIVO"), ATIVO("ATIVO");

    private String descricao;

    private Situacao(String descricao){

        this.descricao = descricao;
    }
    public String getDescricao(){

        return descricao;
    }
}
