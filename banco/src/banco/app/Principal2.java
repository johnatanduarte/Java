package banco.app;

import banco.modelo.Pessoa;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal2 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Johnatan Duarte", "54181623");
        Pessoa pessoa2 = new Pessoa("Julia pinha", "58415233");

        //List é uma classe e ArrayList é uma interface
        //List<Pessoa> pessoas = new ArrayList<>();
        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        //System.out.println(pessoas.toString());

//        for(int i = 0; i < pessoas.size(); i++){
//            System.out.println(pessoas.get(i).getNome());
//        }

        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa.getNome());
        }

        Pessoa pessoa4 = new Pessoa("Johnatan Duarte", "54181623");

        boolean existe = pessoas.contains(pessoa4);
        System.out.println(existe);

        System.out.println(pessoa1.equals(pessoa4));

    }

}
