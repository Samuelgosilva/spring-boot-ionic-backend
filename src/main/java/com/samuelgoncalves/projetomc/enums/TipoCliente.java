package com.samuelgoncalves.projetomc.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");


    private Integer code;
    private String descricao;

    TipoCliente(Integer code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public Integer getCode(){
        return code;
    }

    public String getDescricao(){
        return descricao;
    }

    public static TipoCliente toEnum(Integer code){

            if(code == null) {
                return null;
            }

            for(TipoCliente x : TipoCliente.values()){
                if(code.equals(x.getCode())) {
                    return x;
                }
            }
            throw new IllegalArgumentException("Id inválido: " + code);
    }
}
