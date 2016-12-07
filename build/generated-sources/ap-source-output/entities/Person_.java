package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import util.ParseCode;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T15:13:02")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> firstname;
    public static volatile SingularAttribute<Person, String> isikukood;
    public static volatile SingularAttribute<Person, String> mail;
    public static volatile SingularAttribute<Person, ParseCode> parseCode;
    public static volatile SingularAttribute<Person, String> telefon;
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, String> lastname;

}