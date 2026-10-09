package mobilidade;

import java.util.Locale;

public class Main {

    private static final Locale LOCALE_BRASIL = Locale.forLanguageTag("pt-BR");

    public static void main(String[] args) {
        MotoristaIniciante iniciante = new MotoristaIniciante("Carlos Silva", "ABC-1234");
        registrarCorridas(iniciante, 30.0, 45.5, 22.0);

        MotoristaPremium premium = new MotoristaPremium("Ana Souza", "DEF-5678");
        registrarCorridas(premium, 50.0, 80.0, 35.0, 60.0, 42.0, 75.0, 90.0);

        MotoristaParceiroFrotista frotista = new MotoristaParceiroFrotista("Bruno Lima", "GHI-9012");
        registrarCorridas(frotista, 120.0, 95.0, 150.0, 80.0, 110.0, 70.0, 130.0, 100.0, 90.0, 85.0,
                140.0, 125.0, 60.0, 75.0, 105.0, 115.0, 95.0, 88.0, 132.0, 99.0,
                140.0, 160.0, 72.0, 84.0, 91.0, 110.0, 135.0, 145.0, 78.0, 66.0);

        Motorista[] motoristas = {iniciante, premium, frotista};
        for (Motorista motorista : motoristas) {
            imprimirHolerite(motorista);
        }
    }

    private static void registrarCorridas(Motorista motorista, double... valoresCorridas) {
        for (double valorCorrida : valoresCorridas) {
            motorista.registrarCorrida(valorCorrida);
        }
    }

    private static void imprimirHolerite(Motorista motorista) {
        System.out.println("==========================================");
        System.out.println("        EXTRATO DO MOTORISTA");
        System.out.println("==========================================");
        System.out.println("Categoria........: " + motorista.getClass().getSimpleName());
        System.out.println("Nome.............: " + motorista.getNome());
        System.out.println("Placa............: " + motorista.getPlacaVeiculo());
        System.out.println("Qtd. de corridas.: " + motorista.getQuantidadeCorridas());
        System.out.println("Valor bruto......: " + formatarMoeda(motorista.getValorBrutoTotal()));
        System.out.println("Valor liquido....: " + formatarMoeda(motorista.calcularPagamentoLiquido()));
        System.out.println("==========================================");
        System.out.println();
    }

    private static String formatarMoeda(double valor) {
        return String.format(LOCALE_BRASIL, "R$ %,.2f", valor);
    }
}
