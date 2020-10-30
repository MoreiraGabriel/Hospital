/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gabriel.moreira
 */
public class FuncionarioDAO {
    public static FuncionarioDAO funcionariosDAO;

    public static FuncionarioDAO getInstance() {
        if (funcionariosDAO == null) {
            funcionariosDAO = new FuncionarioDAO();
        }
        return funcionariosDAO;
    }

    public Funcionarios buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Funcionarios a where a.nomeFuncionarios =:nome ");
        query.setParameter("nome", nome);

        List<Funcionarios> categoria = query.getResultList();
        if (categoria != null && categoria.size() > 0) {
            return categoria.get(0);
        }

        return null;
    }

    public List<Funcionarios> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Funcionarios As a");
        return query.getResultList();
    }

    public void remover(Funcionarios funcionarios) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        
        if (!em.contains(funcionarios)) {
            funcionarios = em.merge(funcionarios);
        }
        em.remove(funcionarios);
        em.getTransaction().commit();
    }
    
//    public void remover(Long id) {
//        EntityManager em = PersistenceUtil.getEntityManager();
//        em.getTransaction().begin();
//
//        try {
//            em.remove(em.getReference(Funcionarios.class, id));
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//        
//    }

    public Funcionarios persistir(Funcionarios funcionarios) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            funcionarios = em.merge(funcionarios);
            em.getTransaction().commit();
            System.out.println("Registro Funcionarios gravado com sucesso");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return funcionarios;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Funcionarios ");
        query.executeUpdate();
        em.getTransaction().commit();
    }
    
    public Funcionarios findById(Long id){
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Funcionarios a where a.idFuncionario =:id ");
        query.setParameter("id", id);

        List<Funcionarios> end = query.getResultList();
        if (end != null && end.size() > 0) {
            return end.get(0);
        }

        return null;
    }
}
