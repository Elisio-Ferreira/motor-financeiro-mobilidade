package mobilidade;

public class MotoristaIniciante extends Motorista {

    private static final double TAXA_PLATAFORMA = 0.25;
    private static final int MINIMO_CORRIDAS_SEM_PENALIDADE = 5;
    private static final double TAXA_INATIVIDADE = 50.0;

    public MotoristaIniciante(String nome, String placaVeiculo) {
        super(nome, placaVeiculo);
    }

    @Override
    public double calcularPagamentoLiquido() {
        double pagamento = calcularValorAposTaxa(TAXA_PLATAFORMA);
        if (getQuantidadeCorridas() < MINIMO_CORRIDAS_SEM_PENALIDADE) {
            pagamento -= TAXA_INATIVIDADE;
        }
        return pagamento;
    }
}
