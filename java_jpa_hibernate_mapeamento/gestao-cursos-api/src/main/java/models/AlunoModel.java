package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno " + aluno.getId() + " atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o aluno " + aluno.getId() + " !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Aluno a = em.find(Aluno.class, aluno.getId());
            em.remove(a);
            em.getTransaction().commit();
            System.out.println("Aluno " + a.getId() + " deletado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao deletar o aluno " + aluno.getId() + " !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Aluno a = em.find(Aluno.class, id);
            System.out.println("Aluno " + a.getId() + " encontrado com sucesso !!!");
            return a;
        } catch (Exception e) {
            System.err.println("Erro ao buscar o aluno " + id + " !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            alunos = em.createNativeQuery("SELECT * FROM " + Aluno.class.getSimpleName()).getResultList();
            System.out.println("Alunos encontrados com sucesso !!!");
            return alunos;
        } catch (Exception e) {
            System.err.println("Erro ao buscar alunos !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }
}
