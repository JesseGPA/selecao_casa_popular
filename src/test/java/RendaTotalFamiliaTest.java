import commom.PessoaFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jessealves.casapopular.model.Familia;
import com.jessealves.casapopular.model.Pessoa;
import com.jessealves.casapopular.model.criterios.RendaTotalFamilia;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RendaTotalFamiliaTest {

    private RendaTotalFamilia criterioRendaTotalFamilia;

    @BeforeEach
    void setUp() {
        criterioRendaTotalFamilia = new RendaTotalFamilia();
    }

    @Test
    @DisplayName("Teste criterio Renda Total Familia")
    public void calculaPontuacaoHappyDay() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date dataNascimento = formatter.parse("01/01/1980");
            Pessoa pretendente = PessoaFactory.criaPretendente(dataNascimento, BigDecimal.valueOf(350.00));

            dataNascimento = formatter.parse("01/01/1975");
            Pessoa conjuge = PessoaFactory.criaConjuge(dataNascimento, BigDecimal.valueOf(500.00));

            Familia familia = new Familia(pretendente, conjuge);

            int resultado = criterioRendaTotalFamilia.calculaPontuacao(familia);

            assertEquals(5, resultado, "Criterio rentaTotalFamilia deveria ser 5");

            dataNascimento = formatter.parse("01/01/2005");
            Pessoa primeiroDependente = PessoaFactory.criaDependente("FILHO 1", dataNascimento, BigDecimal.valueOf(200));
            familia.adicionaDependente(primeiroDependente);

            resultado = criterioRendaTotalFamilia.calculaPontuacao(familia);

            assertEquals(3, resultado, "Criterio rentaTotalFamilia deveria ser 3");

            dataNascimento = formatter.parse("01/01/2006");
            Pessoa segundoDependente = PessoaFactory.criaDependente("FILHO 2", dataNascimento, BigDecimal.valueOf(800));

            familia.adicionaDependente(segundoDependente);

            resultado = criterioRendaTotalFamilia.calculaPontuacao(familia);

            assertEquals(0, resultado, "Criterio rentaTotalFamilia deveria ser 0");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
