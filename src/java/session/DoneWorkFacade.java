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
    
    
    public List<DoneWork> listDoneWork(OrderFurniture order, Model model, Part part){
        Query query = getEntityManager().createQuery("SELECT d from DoneWork d WHERE d.orderFurniture = :order AND d.model = model AND d.part = :part")
                .setParameter("order", order)
                .setParameter("model", model)
                .setParameter("part", part);
        return  query.getResultList();
        
    }
    
}
