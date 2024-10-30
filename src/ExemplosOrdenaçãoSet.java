import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ExemplosOrdenaçãoSet {
    public static void main(String[] args) {

        System.out.println("--\tOrdem Aletória\t--");
        Set<Serie> minhasSeries1 = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};

        for (Serie serie : minhasSeries1) System.out.println(serie.getNome() + " - "
             + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem Natural (TempoEpisodio)\t--");
        Set<Serie> minhaSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie : minhaSeries2) System.out.println(serie.getNome() + " - "
             + serie.getGenero() + " - " + serie.getTempoEpisodio());
        System.out.println(minhaSeries2);
            
        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhaSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhaSeries3.addAll(minhasSeries1);
        for (Serie serie : minhaSeries3) System.out.println(serie.getNome() + " - "
             + serie.getGenero() + " - " + serie.getTempoEpisodio());
        System.out.println(minhaSeries3);
        
        System.out.println("--\tOrdem de Genêro\t--");
        Set<Serie> minhaSerie4 = new TreeSet<>(new CompararGenero());
        minhaSerie4.addAll(minhasSeries1);
        for (Serie serie : minhaSerie4) System.out.println(serie.getGenero() + " - "
             + serie.getNome() + " - " + serie.getTempoEpisodio());
        System.out.println(minhaSerie4);
        
        System.out.println("--\tOrdem de Tempo de Episodio\t--");
        Set<Serie> minhaSerie5 = new TreeSet<>(new CompararTempo());
        minhaSerie5.addAll(minhasSeries1);
        for (Serie serie : minhaSerie5) System.out.println(serie.getTempoEpisodio() + " - "
             + serie.getNome() + " - " + serie.getGenero());
        System.out.println(minhaSerie5);    

    }
}

class Serie implements Comparable <Serie> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }
    @Override
    public String toString() {
        return "{nome = " + nome + ", genero = " + genero + 
        ", tempoEpisodio = " + tempoEpisodio + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());

    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;
        
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }

}

class CompararGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareTo(s2.getGenero());    
    }

    


}

class CompararTempo implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());    
    }

}