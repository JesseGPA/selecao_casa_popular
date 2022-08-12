package com.jessealves.casapopular.model.criterios;

import com.jessealves.casapopular.model.Familia;
import com.jessealves.casapopular.service.FamiliaService;
import java.math.BigDecimal;

public class RendaTotalFamilia implements ICriterio {
    private String descricao = "Cálculo de pontuação da família de acordo com a renda total";
    private FamiliaService familiaService = new FamiliaService();

    @Override
    public int calculaPontuacao(Familia familia) {
        BigDecimal rendaTotal = familiaService.calculaRendaTotal(familia);

        if (rendaTotal.doubleValue() <= 900.0) return 5;
        if (rendaTotal.doubleValue() > 900.0 && rendaTotal.doubleValue() <= 1500.0) return 3;

        return 0;
    }
}
