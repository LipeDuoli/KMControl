package com.kmcontrol.dao;

import com.kmcontrol.arquivos.DadosRelatorio;
import com.kmcontrol.entities.Atendimento;
import com.kmcontrol.entities.Usuario;
import com.kmcontrol.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AtendimentoDao implements IDao {

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
            Query query = session.createQuery("FROM Atendimento");
            return query.list();
        } catch (HibernateException he) {
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Atendimento> listarAtendimento(Usuario usuario, Date dataInicial, Date dataFinal, String ordem) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Atendimento.class);
            criteria.add(Restrictions.eq("usuario", usuario));
            if (dataInicial != null) {
                criteria.add(Expression.ge("data", dataInicial));
            }
            if (dataFinal != null) {
                criteria.add(Expression.le("data", dataFinal));
            }
            criteria.addOrder(Order.asc(ordem));
            return criteria.list();
        } catch (HibernateException he) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<DadosRelatorio> listaRelatorio(Date dataInicial, Date dataFinal) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT NEW com.kmcontrol.arquivos.DadosRelatorio(sum(a.kmfinal - a.kminicial), "
                    + "sum( (a.qtdHospedagem * a.valorHospedagem) + (a.qtdPedagio * a.valorPedagio) + (a.qtdEstacionamento * a.valorEstacionamento) + (a.qtdAlimentacao * a.valorAlimentacao)), "
                    + "a.usuario.nome, "
                    + "a.usuario.nomeBanco, "
                    + "a.usuario.conta, "
                    + "a.usuario.agencia) "
                    + "FROM Atendimento a "
                    + "WHERE a.data BETWEEN :datainicial AND :datafinal "
                    + "GROUP BY a.usuario.id "
                    + "ORDER BY a.usuario.nome ASC");
            query.setParameter("datainicial", dataInicial);
            query.setParameter("datafinal", dataFinal);
            return query.list();
        } catch (HibernateException he) {
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }

    }

}
