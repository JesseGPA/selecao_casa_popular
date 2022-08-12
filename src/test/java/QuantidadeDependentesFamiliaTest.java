import com.jessealves.casapopular.model.Familia;
import com.jessealves.casapopular.model.Pessoa;
import com.jessealves.casapopular.model.criterios.QuantidadeDependentesFamilia;
import commom.PessoaFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuantidadeDependentesFamiliaTest {

    private QuantidadeDependentesFamilia criterioQuantidadeDependentes;

    @BeforeEach
    void setUp() {
        criterioQuantidadeDependentes = new QuantidadeDependentesFamilia();
    }

    @Test
    @DisplayName("Teste criterio Quantidade Dependentes Familia")
    public void calculaPontuacaoHappyDay() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date dataNascimento = formatter.parse("01/01/1980");
            Pessoa pretendente = PessoaFactory.criaPretendente(dataNascimento, BigDecimal.valueOf(350.00));

            dataNascimento = formatter.parse("01/01/1975");
            Pessoa conjuge = PessoaFactory.criaConjuge(dataNascimento, BigDecimal.valueOf(500.00));

            Familia familia = new Familia(pretendente, conjuge);

            int resultado = criterioQuantidadeDependentes.calculaPontuacao(familia);

            assertEquals(0, resultado, "Criterio rentaTotalFamilia deveria ser 0");

            dataNascimento = formatter.parse("01/01/2005");
            Pessoa primeiroDependente = PessoaFactory.criaDependente("FILHO 1", dataNascimento, BigDecimal.valueOf(200));
            familia.adicionaDependente(primeiroDependente);

            resultado = criterioQuantidadeDependentes.calculaPontuacao(familia);

            assertEquals(2, resultado, "Criterio rentaTotalFamilia deveria ser 2");

            dataNascimento = formatter.parse("01/01/2006");
            Pessoa segundoDependente = PessoaFactory.criaDependente("FILHO 2", dataNascimento, BigDecimal.valueOf(800));

            familia.adicionaDependente(segundoDependente);

            resultado = criterioQuantidadeDependentes.calculaPontuacao(familia);

            assertEquals(2, resultado, "Criterio rentaTotalFamilia deveria ser 2");

            dataNascimento = formatter.parse("01/01/2008");
            Pessoa terceiroDependente = PessoaFactory.criaDependente("FILHO 3", dataNascimento, BigDecimal.valueOf(0));

            familia.adicionaDependente(terceiroDependente);

            resultado = criterioQuantidadeDependentes.calculaPontuacao(familia);

            assertEquals(3, resultado, "Criterio rentaTotalFamilia deveria ser 3");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
