/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.OrderFurniture;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.DateMyFormat;

/**
 *
 * @author jvm
 */
@Stateless
public class OrderFurnitureFacade extends AbstractFacade<OrderFurniture> {

    @PersistenceContext(unitName = "WebFurniturePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFurnitureFacade() {
        super(OrderFurniture.class);
    }
    public List<OrderFurniture> oderByTodey() {
//      Вычисляем номер текущей недели (week) и года (year)
//        Date curentDate = new Date();
//        SimpleDateFormat dateFormat=null;
//        dateFormat = new SimpleDateFormat("w");
//        Integer week=Integer.decode(dateFormat.format(curentDate));
//        dateFormat = new SimpleDateFormat("yyyy");//Уточнить формат года в сущности OrderDate
//        Integer year=Integer.decode(dateFormat.format(curentDate));
        
//      Если напишем свой класс работы с датой, то можно воспользоваться им
        DateMyFormat dateMyFormat = new DateMyFormat();
        Integer week = dateMyFormat.getCurentWeek();
        Integer year = dateMyFormat.getCurentYear();
//      Делаем выборку заказов в базе на текущую неделю года
        Query query = getEntityManager().createQuery("SELECT o FROM OrderFurniture o WHERE o.orderDate.week_=:week AND o.orderDate.year_=:year");
        query.setParameter("week", week);
        query.setParameter("year", year);
        
        return query.getResultList();
    }
    
}
