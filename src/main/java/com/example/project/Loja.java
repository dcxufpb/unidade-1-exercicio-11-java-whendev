package com.example.project;

public class Loja {

    private String nomeLoja;
    private Endereco endereco;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, Endereco endereco, String telefone,
                String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.endereco = endereco;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static Boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public void validarCamposObrigatorio(){
        if (isNullOrEmpty(this.getNomeLoja())){
            throw new RuntimeException("O campo nome da loja é obrigatório");
        }

        if (isNullOrEmpty(endereco.getLogradouro())){
            throw new RuntimeException("O campo logradouro do endereço é obrigatório");
        }

        if (isNullOrEmpty(endereco.getMunicipio())){
            throw new RuntimeException("O campo município do endereço é obrigatório");
        }

        if (isNullOrEmpty(endereco.getEstado())){
            throw new RuntimeException("O campo estado do endereço é obrigatório");
        }

        if (isNullOrEmpty(this.getCnpj())){
            throw new RuntimeException("O campo cnpj da loja é obrigatório");
        }

        if (isNullOrEmpty(this.getInscricaoEstadual())) {
            throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
        }
    }


    public String dadosLoja() {
		// Implemente aqui

        validarCamposObrigatorio();
        String _COMPLEMENTO = "";
        if (!isNullOrEmpty(endereco.getComplemento())){
            _COMPLEMENTO = " " + endereco.getComplemento();
        }

        String _BAIRRO = "";
        if (!isNullOrEmpty(endereco.getBairro())) {
            _BAIRRO = endereco.getBairro() + " - ";
        }

        String _CEP = "";
        String _TELEFONE = "";

        if (!isNullOrEmpty(endereco.getCep())) {
            _CEP = "CEP:" + endereco.getCep();
            if (!isNullOrEmpty(this.getTelefone())){
                _TELEFONE = " Tel " + this.getTelefone();
            }
        } else {
            _CEP = "";
            if (!isNullOrEmpty(this.getTelefone())){
                _TELEFONE = "Tel " + this.getTelefone();
            }
        }

        String _OBSERVACAO = "";
        if (!isNullOrEmpty(this.getObservacao())){
            _OBSERVACAO = this.getObservacao();
        }

        String _texto = "";
        _texto = String.format("%s\r\n",this.getNomeLoja());
        if (endereco.getNumero() == 0){
            _texto += String.format("%s, %s%s\r\n",endereco.getLogradouro(),"s/n",_COMPLEMENTO);
        } else {
            _texto += String.format("%s, %d%s\r\n",endereco.getLogradouro(),endereco.getNumero(),_COMPLEMENTO);
        }
        _texto += String.format("%s%s - %s\r\n",_BAIRRO,endereco.getMunicipio(),endereco.getEstado());
        _texto += String.format("%s%s\r\n",_CEP,_TELEFONE);
        _texto += String.format("%s\r\n",_OBSERVACAO);
        _texto += String.format("CNPJ: %s\r\n",this.getCnpj());
        _texto += String.format("IE: %s\r\n",this.getInscricaoEstadual());
        return _texto;
    }

}