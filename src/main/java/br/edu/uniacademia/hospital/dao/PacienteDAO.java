/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gabriel.moreira
 */
public class PacienteDAO {
    public static PacienteDAO pacientesDao;
    public static PacienteDAO getInstance() {
        if (pacientesDao == null) {
            pacientesDao = new PacienteDAO();
        }
        return pacientesDao;
    }

    public Enderecos buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Pacientes a where a.nomePaciente =:nome ");
        query.setParameter("nome", nome);

        List<Enderecos> categoria = query.getResultList();
        if (categoria != null && categoria.size() > 0) {
            return categoria.get(0);
        }

        return null;
    }

    public List<Pacientes> buscarTodos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Pacientes As a");
        return query.getResultList();
    }

    public void remover(Pacientes pacientes) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(pacientes)) {
            pacientes = em.merge(pacientes);
        }
        em.remove(pacientes);
        em.getTransaction().commit();
    }

    public Pacientes persistir(Pacientes pacientes) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            pacientes = em.merge(pacientes);
            em.getTransaction().commit();
            System.out.println("Registro Paciente gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Pacientes ");
        query.executeUpdate();
        em.getTransaction().commit();
    }
    
    public Pacientes findById(Long id){
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Pacientes a where a.idPaciente =:id ");
        query.setParameter("id", id);

        List<Pacientes> end = query.getResultList();
        if (end != null && end.size() > 0) {
            return end.get(0);
        }

        return null;
    }
}
