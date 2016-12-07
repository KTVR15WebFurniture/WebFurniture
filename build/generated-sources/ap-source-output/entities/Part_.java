package entities;

import entities.Model;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T15:13:02")
@StaticMetamodel(Part.class)
public class Part_ { 

    public static volatile SingularAttribute<Part, Integer> price;
    public static volatile SingularAttribute<Part, String> name;
    public static volatile SingularAttribute<Part, String> description;
    public static volatile SingularAttribute<Part, Model> model;
    public static volatile SingularAttribute<Part, Long> id;
    public static volatile SingularAttribute<Part, Integer> time;

}