import br.com.alura.alurafy.modelos.MinhasPreferidas;
import br.com.alura.alurafy.modelos.Musica;
import br.com.alura.alurafy.modelos.Podcast;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, mundo!");

        Musica primeiraMusica = new Musica();
        primeiraMusica.setTitulo("Shots");
        primeiraMusica.curtir();
        for (int i = 0; i < 101; i++) {
            primeiraMusica.reproduzir();
        }

        Podcast primeiroPodcast = new Podcast();
        primeiroPodcast.setHost("Altay de Souza");
        for (int i = 0; i < 90; i++) {
            primeiroPodcast.getCurtidas();
        }

        MinhasPreferidas preferida = new MinhasPreferidas();
        preferida.inclui(primeiraMusica);
        preferida.inclui(primeiroPodcast);

        System.out.println(primeiraMusica.getReproducoes());
    }
}
