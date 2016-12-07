package entities;

import entities.Model;
import entities.OrderDate;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T15:13:02")
@StaticMetamodel(OrderFurniture.class)
public class OrderFurniture_ { 

    public static volatile ListAttribute<OrderFurniture, Model> models;
    public static volatile SingularAttribute<OrderFurniture, String> name;
    public static volatile SingularAttribute<OrderFurniture, Long> id;
    public static volatile SingularAttribute<OrderFurniture, OrderDate> orderDate;
    public static volatile SingularAttribute<OrderFurniture, Date> addDate;

}