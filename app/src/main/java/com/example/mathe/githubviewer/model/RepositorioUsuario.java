package com.example.mathe.githubviewer.model;

public class RepositorioUsuario {

    private String nomeRepositorio,tipoLinguagem;

    public RepositorioUsuario(String nomeRepositorio, String tipoLinguagem) {
        this.nomeRepositorio = nomeRepositorio;
        this.tipoLinguagem = tipoLinguagem;
    }

    public String getNomeRepositorio() {
        return nomeRepositorio;
    }

    public void setNomeRepositorio(String nomeRepositorio) {
        this.nomeRepositorio = nomeRepositorio;
    }

    public String getTipoLinguagem() {
        return tipoLinguagem;
    }

    public void setTipoLinguagem(String tipoLinguagem) {
        this.tipoLinguagem = tipoLinguagem;
    }
}
