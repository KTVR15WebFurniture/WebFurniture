package entities;

import entities.Model;
import entities.OrderDate;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T14:59:40")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile ListAttribute<Order, Model> models;
    public static volatile SingularAttribute<Order, String> name;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SingularAttribute<Order, OrderDate> orderDate;
    public static volatile SingularAttribute<Order, Date> addDate;

}