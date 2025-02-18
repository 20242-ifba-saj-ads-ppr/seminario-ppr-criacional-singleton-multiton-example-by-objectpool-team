package clipboard_singleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Obtém a instância única do ClipBoardSingleton
        DiagramClipBoardSingleton clipboard = DiagramClipBoardSingleton.getInstance();
        Scanner s = new Scanner(System.in);

        System.out.println("Texto para copiar: ");
        String textoCopiado = s.nextLine();

        clipboard.copy(textoCopiado);

        System.out.println("Copiado, verifique o clip do SO, substitua caso queira, tecle enter para continuar.");
        s.nextLine();

        clipboard.paste().ifPresentOrElse(
            pasted -> System.out.println("Conteúdo colado com sucesso (XML Interno): " + pasted),
            () -> System.out.println("Nenhum conteúdo válido encontrado na área de transferência.")
        );

    }
}
