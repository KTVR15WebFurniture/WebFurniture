package entities;

import entities.Order;
import entities.Part;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T14:59:40")
@StaticMetamodel(Model.class)
public class Model_ { 

    public static volatile SingularAttribute<Model, String> name;
    public static volatile ListAttribute<Model, Part> parts;
    public static volatile SingularAttribute<Model, Long> id;
    public static volatile SingularAttribute<Model, Order> order;

}