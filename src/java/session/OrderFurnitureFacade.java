/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.OrderFurniture;
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
public class OrderFurnitureFacade extends AbstractFacade<OrderFurniture> {

    @PersistenceContext(unitName = "KTVR15WebFurniture_KurtsanovPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFurnitureFacade() {
        super(OrderFurniture.class);
    }
    
    public List<OrderFurniture> ordersByDate(Integer week, Integer month, Integer year){
        Query query = getEntityManager().createQuery("Select o FROM OrderFurniture o WHERE o.orderDate._week = :week AND o.orderDate._month = :month AND o.orderDate._year = :year")
                .setParameter("week", week)
                .setParameter("month", month)
                .setParameter("year", year);
        
        return query.getResultList();
    }
}
