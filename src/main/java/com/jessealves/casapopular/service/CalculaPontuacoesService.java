package com.jessealves.casapopular.service;

import com.jessealves.casapopular.model.Familia;
import com.jessealves.casapopular.model.criterios.QuantidadeDependentesFamilia;
import com.jessealves.casapopular.model.criterios.RendaTotalFamilia;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class CalculaPontuacoesService {

    private RendaTotalFamilia criterioRendaTotalFamilia;
    private QuantidadeDependentesFamilia criterioQuantidadeDependentesFamilia;

    public CalculaPontuacoesService() {
        criterioRendaTotalFamilia = new RendaTotalFamilia();
        criterioQuantidadeDependentesFamilia = new QuantidadeDependentesFamilia();
    }

    public List<Familia> ordenaFamiliasPorCriterios(List<Familia> familias) {
        TreeMap<Familia, Integer> listaOrdenada = new TreeMap<>(Collections.reverseOrder());

        for (Familia familia : familias ) {
            int criterioRendaTotal = criterioRendaTotalFamilia.calculaPontuacao(familia);
            int criterioQuantidadeDependentes = criterioQuantidadeDependentesFamilia.calculaPontuacao(familia);

            listaOrdenada.put(familia, criterioRendaTotal + criterioQuantidadeDependentes);
        }

        return familias;
    }
}
