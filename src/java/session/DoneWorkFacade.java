/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.DoneWork;
import entities.Model;
import entities.OrderFurniture;
import entities.Part;
import entities.Worker;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pupil
 */
@Stateless
public class DoneWorkFacade extends AbstractFacade<DoneWork> {

    @PersistenceContext(unitName = "KTVR15WebFurniture_KurtsanovPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoneWorkFacade() {
        super(DoneWork.class);
    }
    public List<DoneWork> doneWorkByWorkerAndDate(Integer week, Integer month, Integer year, Worker worker){
        Query query = getEntityManager().createQuery("Select d from DoneWork d Where d.week = :week AND d.month = :month AND d.year = :year AND d.worker = :worker")
                .setParameter("week", week)
                .setParameter("month", month)
                .setParameter("year", year)
                .setParameter("worker", worker);
        
        return query.getResultList();
    }
    
    public Integer countProfitForMonth(Integer month, Integer year, Worker worker){
        Query query = getEntityManager().createQuery("Select SUM(d.done * d.part.price) d from DoneWork d Where d.week = :week AND d.month = :month AND d.year = :year AND d.worker = :worker")
                .setParameter("month", month)
                .setParameter("year", year)
                .setParameter("worker", worker);
        
        return (Integer) query.getSingleResult();
    }
    
    public List<DoneWork> listDoneWork(OrderFurniture order, Model model, Part part){
        Query query = getEntityManager().createQuery("SELECT d from DoneWork d WHERE d.orderFurniture = :order AND d.model = model AND d.part = :part")
                .setParameter("order", order)
                .setParameter("model", model)
                .setParameter("part", part);
        return  query.getResultList();
        
    }
    
}
