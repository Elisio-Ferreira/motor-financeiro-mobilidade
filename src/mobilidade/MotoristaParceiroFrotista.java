package mobilidade;

public class MotoristaParceiroFrotista extends Motorista {

    private static final double TAXA_PLATAFORMA = 0.20;
    private static final double ALUGUEL_VEICULO = 800.0;

    public MotoristaParceiroFrotista(String nome, String placaVeiculo) {
        super(nome, placaVeiculo);
    }

    @Override
    public double calcularPagamentoLiquido() {
        double pagamento = calcularValorAposTaxa(TAXA_PLATAFORMA) - ALUGUEL_VEICULO;
        return Math.max(pagamento, 0.0);
    }
}
