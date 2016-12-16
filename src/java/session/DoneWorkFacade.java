/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.DoneWork;
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
    
    public List<DoneWork> DoneWorkByWorkerForWeek(Integer week, Integer month, Integer year, Long id){
        
        Query query = getEntityManager().createQuery("SELECT d FROM DoneWork d WHERE d.worker.id = :id && d._week = :week && d._month = :month && d._year = :year", DoneWork.class)
                .setParameter("id", id)
                .setParameter("week", week)
                .setParameter("moth", month)
                .setParameter("year", year);
        List<DoneWork> doneWorkByWorkerForWeek = query.getResultList();
        
        return doneWorkByWorkerForWeek;
    }
    
    public Integer CountWorkersProfit(Long id){
        
        Query query = getEntityManager().createQuery("SELECT p SUM(p.orderFurniture.models.parts.price) FROM DoneWork p WHERE p.worker.id = :id ", DoneWork.class)
                .setParameter("id", id);
        Integer profit = (Integer) query.getSingleResult();
        
        return profit;
    }
}
