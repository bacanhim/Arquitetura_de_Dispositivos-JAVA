import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        TVShow PesadeloNaCozinha = new TVShow("TVi", "Portuguesa", "1975", "Pesadelo na Cozinha", 2.5, 1, 2017);
        Documentary MiguelOliveiraMotoGP = new Documentary("Motogp", "English", "1975", "Percurso ate motogp", 10, 1, 2015, "LifeStory", 1);
        MiniSeries YOU = new MiniSeries("John Mackfin", "American", "1954", "YOU", 9, 2, 2010, 5);
        System.out.println(PesadeloNaCozinha.toString());
        System.out.println(MiguelOliveiraMotoGP.toString());
        System.out.println(YOU.toString());
        ShowList lista = new ShowList();
        lista.add(PesadeloNaCozinha);
        lista.add(MiguelOliveiraMotoGP);
        lista.add(YOU);
        lista.ordenar();
        System.out.println(lista.getTVshowList());
    }
}
