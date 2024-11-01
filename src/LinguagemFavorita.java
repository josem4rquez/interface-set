/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção; - 
b) Ordem natural(nome); -
c) IDE; -
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LinguagemFavorita {
    public static void main(String[] args) {
        Set<Linguagem> linguagensFavoritas = new LinkedHashSet<>() {{

            add(new Linguagem("python", 1989, "intellij"));
            add(new Linguagem("java", 1995, "vscode"));
            add(new Linguagem("swift", 2010, "Eclipse"));
        }};
        
        System.out.println("Ordem de Inserção: ");
        for (Linguagem linguagem : linguagensFavoritas) {
            System.out.println(linguagem);
        }

        System.out.println("Ordem Natural(Nome): ");
        Set<Linguagem> linguagensFavoritas2 = new TreeSet<>(linguagensFavoritas);
        for (Linguagem linguagem : linguagensFavoritas2) System.out.println(linguagem.getNome() + " - "
             + linguagem.getAnoDeCriacao() + " - " + linguagem.getIde());
        System.out.println(linguagensFavoritas2);
        
        System.out.println("Ordem de IDE: ");
        Set<Linguagem> linguagensFavoritas3 = new TreeSet<Linguagem>(new ComparatorIde());
        linguagensFavoritas3.addAll(linguagensFavoritas);
        for (Linguagem linguagem : linguagensFavoritas3) System.out.println(linguagem);
        
        System.out.println("Ordem Ano de Criação e Nome");
        Set<Linguagem> linguagensFavoritas4 = new TreeSet<Linguagem>(new ComparatorAnoDeCriacaoENome());
        linguagensFavoritas4.addAll(linguagensFavoritas);
        for (Linguagem linguagem : linguagensFavoritas4) System.out.println(linguagem);
            
        System.out.println("Ordem Nome, Ano de Criação e Ide");
        Set<Linguagem> linguagensFavoritas5 = new TreeSet<Linguagem>(new ComparatorNomeAnoDeCriacaoEIde());
        linguagensFavoritas5.addAll(linguagensFavoritas);
        for (Linguagem linguagem : linguagensFavoritas5) System.out.println(linguagem);
    
    }
    
}

class Linguagem implements Comparable<Linguagem> {
    protected String nome;
    protected Integer anoDeCriacao;
    protected String ide;
    
    
    
    public Linguagem(String nome, Integer anoDeCriacao, String ide) {
        this.nome =  nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }
    
    
    public String getNome() {
        return nome;
    }
    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }
    public String getIde() {
        return ide;
    }
    
    @Override
    public String toString() {
        return "{Nome = " + nome + 
        ", anoDeCriacao = " + anoDeCriacao + ", ide = " + ide + "}";
    }


    @Override
    public int compareTo(Linguagem linguagensFavoritas) {
        return this.nome.compareTo(linguagensFavoritas.nome);
    }
}

class ComparatorIde implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem lf1, Linguagem lf2) {
        return lf1.ide.compareToIgnoreCase(lf2.ide);
    }
    
}

class ComparatorAnoDeCriacaoENome implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem lf1, Linguagem lf2) {
        int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
        if (anoDeCriacao != 0) return anoDeCriacao;
        return lf1.nome.compareToIgnoreCase(lf2.nome);
    }

}

class ComparatorNomeAnoDeCriacaoEIde implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem lf1, Linguagem lf2) {
        int nome = lf1.nome.compareToIgnoreCase(lf2.nome);
        int anoDeCriacao = Integer.compare(lf1.anoDeCriacao,lf2.anoDeCriacao);
        if (nome != 0) return nome;
        if (anoDeCriacao != 0) return anoDeCriacao;
        return lf1.ide.compareToIgnoreCase(lf2.ide);
    }

}
