package br.com.alura.alurafy.modelos;

public class MinhasPreferidas {
    public void inclui(Audio audio) {
        if (audio.getClassificacao() == 10) {
            System.out.println("Essa musica é top");
        } else {
            System.out.println("Não curto muito");
        }
    }
}
