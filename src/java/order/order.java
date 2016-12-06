
package order;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class order {
   @Id
   private Long id;
   private String descripition;
   private Long count;
    
}
