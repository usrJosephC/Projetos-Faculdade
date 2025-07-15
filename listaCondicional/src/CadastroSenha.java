import java.util.*;

public class CadastroSenha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senha;
        boolean senhaValida, temMaiuscula, temNumero;

        System.out.print("Cadastre uma senha: ");
        senha = sc.nextLine();

        senhaValida = true;

        if (senha.length() < 8) {
            System.out.println("A senha deve ter pelo menos 8 caracteres.");
            senhaValida = false;
        }

        temMaiuscula = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                temMaiuscula = true;
                break;
            }
        }

        if (!temMaiuscula) {
            System.out.println("A senha deve conter pelo menos uma letra maiúscula.");
            senhaValida = false;
        }

        temNumero = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                temNumero = true;
                break;
            }
        }

        if (!temNumero) {
            System.out.println("A senha deve conter pelo menos um número.");
            senhaValida = false;
        }

        if (senhaValida) {
            System.out.println("Senha válida!");
        } else {
            System.out.println("Senha inválida.");
        }

        sc.close();
    }
}
