package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        //Produto
        ProdutoModel produtoModel = new ProdutoModel();

        Produto produto1 = new Produto();
        produto1.setNome("TV");
        produto1.setPreco(300.0);
        produto1.setQuantidade(100);
        produto1.setStatus(true);

        Produto produto2 = new Produto();
        produto2.setNome("XBox 360");
        produto2.setPreco(1000.0);
        produto2.setQuantidade(80);
        produto2.setStatus(true);

        Produto produto3 = new Produto();
        produto3.setNome("Liquidificador");
        produto3.setPreco(200.0);
        produto3.setQuantidade(800);
        produto3.setStatus(true);

        //1) Criando produto
        produtoModel.create(produto1);
        produtoModel.create(produto2);
        produtoModel.create(produto3);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Atualizando um produto
        produto1.setNome("Geladeira");
        produto1.setPreco(2500.0);
        produto1.setQuantidade(8);
        produto1.setStatus(false);
        produtoModel.update(produto1);

        //4) Deletando um produto
        produtoModel.delete(produto2);

        //5) Buscando produto por Id
        produtoModel.findById(produto3);

        //Pessoa
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Jéssica Ribeiro");
        pessoa1.setEmail("jessica@gmail.com.br");
        pessoa1.setIdade(42);
        pessoa1.setCpf("11111111111");
        pessoa1.setDataDeNascimento(Date.valueOf(LocalDate.of(1979, 06, 30)));

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("André Paes");
        pessoa2.setEmail("andre@gmail.com.br");
        pessoa2.setIdade(22);
        pessoa2.setCpf("22222222222");
        pessoa2.setDataDeNascimento(Date.valueOf(LocalDate.of(2000, 05, 10)));

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Amanda Passos");
        pessoa3.setEmail("amanda@gmail.com.br");
        pessoa3.setIdade(21);
        pessoa3.setCpf("33333333333");
        pessoa3.setDataDeNascimento(Date.valueOf(LocalDate.of(2000, 10, 10)));

        //1) Criando pessoa
        pessoaModel.create(pessoa1);
        pessoaModel.create(pessoa2);
        pessoaModel.create(pessoa3);

        //2) Buscando todas as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        //3) Atualizando uma pessoa
        pessoa1.setIdade(44);
        pessoaModel.update(pessoa1);

        //4) Deletando uma pessoa
        pessoaModel.delete(pessoa2);

        //5) Buscando pessoa por Id
        pessoaModel.findById(pessoa3);
    }
}

