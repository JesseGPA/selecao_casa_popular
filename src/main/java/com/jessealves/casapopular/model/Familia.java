package com.jessealves.casapopular.model;

import java.util.ArrayList;
import java.util.List;

public class Familia {

    private int id;
    private Pessoa pretendente;
    private Pessoa conjuge;
    private List<Pessoa> dependentes;

    public Familia(Pessoa pretendente, Pessoa conjuge) {
        this.pretendente = pretendente;
        this.conjuge = conjuge;
        dependentes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPretendente() {
        return pretendente;
    }

    public void setPretendente(Pessoa pretendente) {
        this.pretendente = pretendente;
    }

    public Pessoa getConjuge() {
        return conjuge;
    }

    public void setConjuge(Pessoa conjuge) {
        this.conjuge = conjuge;
    }

    public List<Pessoa> getDependentes() {
        return dependentes;
    }

    public void adicionaDependente(Pessoa novoDependente) {
        dependentes.add(novoDependente);
    }

    public void adicionaDependentes(List<Pessoa> novosDependentes) {
        dependentes.addAll(novosDependentes);
    }

    public void removeDependente(Pessoa dependenteExcluido) {
        dependentes.remove(dependenteExcluido);
    }

    public void removeDependentes(List<Pessoa> dependentesExcluidos) {
        dependentes.removeAll(dependentesExcluidos);
    }
}
