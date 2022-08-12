package com.jessealves.casapopular.model.criterios;

import com.jessealves.casapopular.service.FamiliaService;
import com.jessealves.casapopular.model.Familia;

public class QuantidadeDependentesFamilia implements ICriterio {
    private String descricao = "Cálculo de pontuação da família de acordo com a quantidade de dependentes";
    private FamiliaService familiaService = new FamiliaService();

    @Override
    public int calculaPontuacao(Familia familia) {
        int quantidadeDependentes = familiaService.retornaQuantidadeDependentesMaiorDeIdade(familia);

        if (quantidadeDependentes >= 3) return 3;
        if (quantidadeDependentes > 0 && quantidadeDependentes <= 2) return 2;

        return 0;
    }
}
