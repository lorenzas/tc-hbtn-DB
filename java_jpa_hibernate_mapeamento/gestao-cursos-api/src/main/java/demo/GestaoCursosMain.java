package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();

        Endereco endereco1 = new Endereco();
        endereco1.setLogradouro("Avenida");
        endereco1.setEndereco("Borges de Medeiros");
        endereco1.setNumero("267");
        endereco1.setBairro("Lajes");
        endereco1.setCidade("Porto Alegre");
        endereco1.setEstado("RS");
        endereco1.setCep("98920134");

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua");
        endereco2.setEndereco("Pedras");
        endereco2.setNumero("512");
        endereco2.setBairro("Industrial");
        endereco2.setCidade("Três Passos");
        endereco2.setEstado("RS");
        endereco2.setCep("97843901");

        Telefone telefone1 = new Telefone();
        telefone1.setDdd("51");
        telefone1.setNumero("996271969");

        Telefone telefone2 = new Telefone();
        telefone2.setDdd("55");
        telefone2.setNumero("996504731");

        Aluno aluno1 = new Aluno();
        aluno1.setNomeCompleto("André Paes");
        aluno1.setMatricula("8123");
        aluno1.setNascimento(Date.valueOf(LocalDate.of(1998, 8, 19)));
        aluno1.setEmail("andre.paes@gmail.com");
        aluno1.setEnderecos(List.of(endereco1));
        aluno1.setTelefones(List.of(telefone1));

        Aluno aluno2 = new Aluno();
        aluno2.setNomeCompleto("Carolina de Oliveira");
        aluno2.setMatricula("7791");
        aluno2.setNascimento(Date.valueOf(LocalDate.of(1995, 10, 5)));
        aluno2.setEmail("carolina.oliveira@outlook.com");
        aluno2.setEnderecos(List.of(endereco2));
        aluno2.setTelefones(List.of(telefone2));

        //1) Criando aluno
        alunoModel.create(aluno1);
        alunoModel.create(aluno2);

        //2) Buscando todos os alunos na base de dados
        List<Aluno> alunos = alunoModel.findAll();
        System.out.println("Qtde de alunos encontrados : " + alunos.size());

        //3) Atualizando aluno
        aluno2.setNascimento(Date.valueOf(LocalDate.of(2000, 5, 10)));
        alunoModel.update(aluno2);

        //4) Buscando aluno por Id
        alunoModel.findById(1L);

        //5) Deletando aluno
        alunoModel.delete(aluno1);

        Professor professor1 = new Professor();
        professor1.setNomeCompleto("Margarete de Jesus");
        professor1.setMatricula("1528");
        professor1.setEmail("margarete.jesus@outlook.com");

        MaterialCurso materialCurso1 = new MaterialCurso();
        materialCurso1.setUrl("https://www.youtube.com/watch?v=tEoiTK03F08");

        Curso curso1 = new Curso();
        curso1.setNome("Confeitaria para Iniciantes");
        curso1.setSigla("Confeitaria");
        curso1.setProfessor(professor1);
        curso1.setMaterialCurso(materialCurso1);
        curso1.setAlunos(List.of(aluno1));

        Professor professor2 = new Professor();
        professor2.setNomeCompleto("Juliana Medeiros");
        professor2.setMatricula("1536");
        professor2.setEmail("juliana.medeiros@yahoo.com");

        MaterialCurso materialCurso2 = new MaterialCurso();
        materialCurso2.setUrl("https://www.youtube.com/watch?v=te-csy7xxNw");

        Curso curso2 = new Curso();
        curso2.setNome("Jardinagem para Iniciantes");
        curso2.setSigla("jardinageminic");
        curso2.setProfessor(professor2);
        curso2.setMaterialCurso(materialCurso2);
        curso2.setAlunos(List.of(aluno2));


        CursoModel cursoModel = new CursoModel();

        //1) Criando curso
        cursoModel.create(curso1);
        cursoModel.create(curso2);

        //2) Buscando todos os cursos na base de dados
        List<Curso> cursos = cursoModel.findAll();
        System.out.println("Qtde de cursos encontrados : " + cursos.size());

        //3) Atualizando curso
        curso2.setSigla("jardinagem");
        cursoModel.update(curso2);

        //4) Buscando curso por Id
        cursoModel.findById(1L);

        //5) Deletando curso
        cursoModel.delete(curso1);
    }
}
