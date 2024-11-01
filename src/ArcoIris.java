/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra; -
b) A quantidade de cores que o arco-íris tem; -
c) Exiba as cores em ordem alfabética; - 
d) Exiba as cores na ordem inversa da que foi informada; - 
e) Exiba todas as cores que começam com a letra ”v”; -
f) Remova todas as cores que não começam com a letra “v”; -
g) Limpe o conjunto; -
h) Confira se o conjunto está vazio; - 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ArcoIris {
    public static void main(String[] args) {
        
        System.out.println("Cores do Arco-Iris: ");
        Set<String> coresDoArcoIris = new HashSet<>();
        
            coresDoArcoIris.add("violeta");
            coresDoArcoIris.add("anil");
            coresDoArcoIris.add("azul");
            coresDoArcoIris.add("verde");
            coresDoArcoIris.add("amarelo");
            coresDoArcoIris.add("laranja");
            coresDoArcoIris.add("vermelho");
        
        System.out.println(coresDoArcoIris);

        System.out.println("Quantidade de cores que o ArcoIris tem: " + coresDoArcoIris.size());

        System.out.println("Exiba as cores do ArcoIris em Ordem Alfabética: ");
        Set<String> coresDoArcoIris2 = new TreeSet<>();
        coresDoArcoIris2.addAll(coresDoArcoIris);
        System.out.println(coresDoArcoIris2);

        System.out.println("Exiba as cores na ordem inversa que foram colocadas: ");
        Set<String> coresDoArcoIris3 = new LinkedHashSet<>(
            Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        ArrayList<String> inverçãoDasCores = new ArrayList<>(coresDoArcoIris3);
        Collections.reverse(inverçãoDasCores);
        System.out.println(inverçãoDasCores);

        System.out.println("Cores que começam com V: ");

        String primeiraLetra = "v";

        for (String coresV : coresDoArcoIris2)
          if (coresV.startsWith(primeiraLetra)) {
            System.out.println(coresV);
          }
        
        System.out.println("remova as cores que começam com V: ");

        Iterator<String> interator =  coresDoArcoIris.iterator();
        while (interator.hasNext()) {
            String coresComV = interator.next();
            if (coresComV.startsWith(primeiraLetra)) {
                interator.remove();
            }
        }
        System.out.println(coresDoArcoIris);

        coresDoArcoIris.clear();

        System.out.println("Confira se o conjunto está vazio: " + coresDoArcoIris.isEmpty());

    }
}