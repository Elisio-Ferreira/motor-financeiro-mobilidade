package mobilidade;

public abstract class Motorista {

    private final String nome;
    private final String placaVeiculo;
    private int quantidadeCorridas;
    private double valorBrutoTotal;

    protected Motorista(String nome, String placaVeiculo) {
        validarTextoPreenchido(nome, "Nome");
        validarTextoPreenchido(placaVeiculo, "Placa");
        this.nome = nome;
        this.placaVeiculo = placaVeiculo;
        this.quantidadeCorridas = 0;
        this.valorBrutoTotal = 0.0;
    }

    public void registrarCorrida(double valorCorrida) {
        validarValorCorrida(valorCorrida);
        quantidadeCorridas++;
        valorBrutoTotal += valorCorrida;
    }

    public abstract double calcularPagamentoLiquido();

    protected double calcularValorAposTaxa(double percentualTaxaPlataforma) {
        double percentualRecebido = 1.0 - percentualTaxaPlataforma;
        return valorBrutoTotal * percentualRecebido;
    }

    public String getNome() {
        return nome;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public int getQuantidadeCorridas() {
        return quantidadeCorridas;
    }

    public double getValorBrutoTotal() {
        return valorBrutoTotal;
    }

    protected void validarValorCorrida(double valorCorrida) {
        if (valorCorrida <= 0) {
            throw new IllegalArgumentException("O valor da corrida deve ser maior que zero.");
        }
    }

    private void validarTextoPreenchido(String texto, String nomeCampo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(nomeCampo + " não pode ser vazio.");
        }
    }
}
