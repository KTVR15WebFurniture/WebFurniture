package entities;

import entities.Model;
import entities.OrderFurniture;
import entities.Part;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T17:16:25")
@StaticMetamodel(DoneWork.class)
public class DoneWork_ { 

    public static volatile SingularAttribute<DoneWork, Integer> _week;
    public static volatile SingularAttribute<DoneWork, Integer> _month;
    public static volatile SingularAttribute<DoneWork, OrderFurniture> orderFurniture;
    public static volatile SingularAttribute<DoneWork, Part> part;
    public static volatile SingularAttribute<DoneWork, Model> model;
    public static volatile SingularAttribute<DoneWork, Long> id;
    public static volatile SingularAttribute<DoneWork, Integer> _year;

}