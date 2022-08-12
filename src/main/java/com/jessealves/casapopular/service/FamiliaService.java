package com.jessealves.casapopular.service;

import com.jessealves.casapopular.model.criterios.RendaTotalFamilia;
import com.jessealves.casapopular.model.Familia;
import com.jessealves.casapopular.model.Pessoa;
import com.jessealves.casapopular.model.criterios.QuantidadeDependentesFamilia;

import java.math.BigDecimal;
import java.util.*;

public class FamiliaService {

    public BigDecimal calculaRendaTotal(Familia familia) {
        BigDecimal rendaTotal = BigDecimal.valueOf(0.0);

        rendaTotal = rendaTotal.add(familia.getPretendente().getRenda());
        rendaTotal = rendaTotal.add(familia.getConjuge().getRenda());

        for (Pessoa dependente : familia.getDependentes()) {
            rendaTotal = rendaTotal.add(dependente.getRenda());
        }

        return rendaTotal;
    }

    public int retornaQuantidadeDependentesMaiorDeIdade(Familia familia) {
        int contador = 0;

        for (Pessoa dependente : familia.getDependentes()) {
            if (dependente.getDataNascimento().after(retornaDataBaseParaCalculo())) contador++;
        }

        return contador;
    }

    private Date retornaDataBaseParaCalculo() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -18);
        return c.getTime();
    }
}
