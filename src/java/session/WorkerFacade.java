/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Worker;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Melnikov
 */
@Stateless
public class WorkerFacade extends AbstractFacade<Worker> {

    @PersistenceContext(unitName = "WebFurniturePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkerFacade() {
        super(Worker.class);
    }
    
}
