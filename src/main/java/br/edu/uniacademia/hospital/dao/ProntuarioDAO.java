/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Prontuarios;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gabriel.moreira
 */
public class ProntuarioDAO {
    public static ProntuarioDAO prontuariosDAO;
    
    public static ProntuarioDAO getInstance() {
        if (prontuariosDAO == null) {
            prontuariosDAO = new ProntuarioDAO();
        }
        return prontuariosDAO;
    }

    public Prontuarios buscar(String descricao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Prontuarios a where a.descricao =:descricao ");
        query.setParameter("descricao", descricao);

        List<Prontuarios> categoria = query.getResultList();
        if (categoria != null && categoria.size() > 0) {
            return categoria.get(0);
        }

        return null;
    }

    public List<Prontuarios> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Prontuarios As a");
        return query.getResultList();
    }

    public void remover(Prontuarios prontuarios) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(prontuarios)) {
            prontuarios = em.merge(prontuarios);
        }
        em.remove(prontuarios);
        em.getTransaction().commit();
    }

    public Prontuarios persistir(Prontuarios prontuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            prontuario = em.merge(prontuario);
            em.getTransaction().commit();
            System.out.println("Registro Enderecos gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prontuario;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Prontuarios ");
        query.executeUpdate();
        em.getTransaction().commit();
    }
    
    public Prontuarios findById(Long id){
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Prontuarios a where a.idProntuario =:id ");
        query.setParameter("id", id);

        List<Prontuarios> end = query.getResultList();
        if (end != null && end.size() > 0) {
            return end.get(0);
        }
        return null;
    }
}