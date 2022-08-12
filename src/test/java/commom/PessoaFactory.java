package commom;

import com.jessealves.casapopular.model.Pessoa;

import java.math.BigDecimal;
import java.util.Date;

public class PessoaFactory {

    public static Pessoa criaPretendente(Date dataNascimento, BigDecimal renda) {
        Pessoa pretendente = new Pessoa();
        pretendente.setNome("PRETENDENTE");
        pretendente.setDataNascimento(dataNascimento);
        pretendente.setRenda(renda);

        return pretendente;
    }

    public static Pessoa criaConjuge(Date dataNascimento, BigDecimal renda) {
        Pessoa pretendente = new Pessoa();
        pretendente.setNome("CONJUGE");
        pretendente.setDataNascimento(dataNascimento);
        pretendente.setRenda(renda);

        return pretendente;
    }

    public static Pessoa criaDependente(String nome, Date dataNascimento, BigDecimal renda) {
        Pessoa pretendente = new Pessoa();
        pretendente.setNome(nome);
        pretendente.setDataNascimento(dataNascimento);
        pretendente.setRenda(renda);

        return pretendente;
    }
}
