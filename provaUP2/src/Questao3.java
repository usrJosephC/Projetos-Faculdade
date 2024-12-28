import java.util.*;

enum Cor {
    VERMELHO,
    AZUL,
    PRETO,
    BRANCO,
    PRATA
}

enum Acessorio {
    AR_CONDICIONADO,
    VIDRO_ELETRICO,
    SOM_MULTIMIDIA,
    RODA_LIGA,
    TETO_SOLAR
}

class Automovel {
    private Cor cor;
    private List<Acessorio> acessorios;

    public Automovel(Cor cor, List<Acessorio> acessorios) {
        this.cor = cor;
        this.acessorios = acessorios;
    }

    public Cor getCor() {
        return cor;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }
}

public class Questao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha a cor do automóvel:");
        for (int i = 0; i < Cor.values().length; i++) {
            System.out.println((i + 1) + ". " + Cor.values()[i]);
        }
        
        int corEscolhida = sc.nextInt() - 1;
        Cor cor = Cor.values()[corEscolhida];

        System.out.println("\nEscolha os acessórios (separe por vírgula):");
        for (int i = 0; i < Acessorio.values().length; i++) {
            System.out.println((i + 1) + ". " + Acessorio.values()[i]);
        }
        
        sc.nextLine();
        String inputAcessorios = sc.nextLine();
        String[] indicesAcessorios = inputAcessorios.split(",");

        List<Acessorio> acessoriosEscolhidos = new ArrayList<>();
        for (String indice : indicesAcessorios) {
            int index = Integer.parseInt(indice.trim()) - 1;
            acessoriosEscolhidos.add(Acessorio.values()[index]);
        }

        Automovel automovel = new Automovel(cor, acessoriosEscolhidos);

        System.out.println("\nConfiguração escolhida:");
        System.out.println("Cor: " + automovel.getCor());
        System.out.print("Acessórios: ");
        
        for (Acessorio acessorio : automovel.getAcessorios()) {
            System.out.print(acessorio + " ");
        }

        sc.close();
    }
}