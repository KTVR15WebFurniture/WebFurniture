/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.DoneWork;
import entities.OrderFurniture;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;

/**
 *
 * @author pupil
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

//    public List<OrderFurniture> OrdersByDate(Integer week, Integer month, Integer year) {
//
//        javax.persistence.Query query = getEntityManager().createQuery("Select o from OrderFurniture o where o.orderDate._week = :week && o.orderDate._month = :month && o.orderDate._year = :year", OrderFurniture.class)
//                .setParameter("week", week)
//                .setParameter("month", month)
//                .setParameter("year", year);
//        List<OrderFurniture> ordersByDate = query.getResultList();
//
//        return ordersByDate;
//    }
//
//    public List<DoneWork> DoneWorkByWorkerForWeek(Integer week, Integer month, Integer year, Long id) {
//
//        javax.persistence.Query query = getEntityManager().createQuery("SELECT d FROM DoneWork d WHERE d.worker.id = :id && d._week = :week && d._month = :month && d._year = :year", DoneWork.class)
//                .setParameter("id", id)
//                .setParameter("week", week)
//                .setParameter("moth", month)
//                .setParameter("year", year);
//        List<DoneWork> doneWorkByWorkerForWeek = query.getResultList();
//
//        return doneWorkByWorkerForWeek;
//    }
//
//    public Integer CountWorkersProfit(Long id) {
//
//        javax.persistence.Query query = getEntityManager().createQuery("SELECT p SUM(p.orderFurniture.models.parts.price) FROM DoneWork p WHERE p.worker.id = :id ", DoneWork.class)
//                .setParameter("id", id);
//        Integer profit = (Integer) query.getSingleResult();
//
//        return profit;
//    }
}
