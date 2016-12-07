package entities;

import entities.Model;
import entities.OrderDate;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T17:16:25")
@StaticMetamodel(OrderFurniture.class)
public class OrderFurniture_ { 

    public static volatile ListAttribute<OrderFurniture, Model> models;
    public static volatile SingularAttribute<OrderFurniture, Date> createOrderFurniture;
    public static volatile SingularAttribute<OrderFurniture, String> name;
    public static volatile SingularAttribute<OrderFurniture, Long> id;
    public static volatile SingularAttribute<OrderFurniture, OrderDate> orderDate;

}