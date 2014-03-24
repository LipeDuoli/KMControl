package com.kmcontrol.dao;

import com.kmcontrol.entities.Usuario;
import com.kmcontrol.persistence.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UsuarioDao implements IDao {

    private Session session;
    private Transaction transaction;

    @Override
    public void salvar(Object obj) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            this.session.save(obj);
            this.transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            this.session.close();
        }
    }

    @Override
    public void alterar(Object obj) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            this.session.update(obj);
            this.transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            this.session.close();
        }
    }

    @Override
    public void excluir(Object obj) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Object> listarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Usuario");
            return query.list();
        } catch (HibernateException he) {
            return null;
        } finally {
            session.close();
        }
    }

    public Usuario buscaLogin(String login) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("login", login)).setMaxResults(1);
            Usuario u = (Usuario) criteria.uniqueResult();
            return u;
        } catch (HibernateException he) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Object> listarTecnicos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Usuario u WHERE u.coordenador = false");
            return query.list();
        } catch (HibernateException he) {
            return null;
        } finally {
            session.close();
        }
    }

}
