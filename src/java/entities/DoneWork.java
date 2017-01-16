/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author pupil
 */
@Entity
public class DoneWork implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer week_;// = OrderDate.getWeek();
    private Integer month_;// = OrderDate.getMonth();
    private Integer year_;// = OrderDate.getYear();
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private OrderFurniture orderFurniture;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Model model;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Part part;
    

    public DoneWork() {
    }

    public DoneWork(Integer week_, Integer month_, Integer year_, OrderFurniture orderFurniture, Model model, Part part) {
        this.week_ = week_;
        this.month_ = month_;
        this.year_ = year_;
        this.orderFurniture = orderFurniture;
        this.model = model;
        this.part = part;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWeek_() {
        return week_;
    }

    public void setWeek_(Integer week_) {
        this.week_ = week_;
    }

    public Integer getMonth_() {
        return month_;
    }

    public void setMonth_(Integer month_) {
        this.month_ = month_;
    }

    public Integer getYear_() {
        return year_;
    }

    public void setYear_(Integer year_) {
        this.year_ = year_;
    }

    public OrderFurniture getOrderFurniture() {
        return orderFurniture;
    }

    public void setOrderFurniture(OrderFurniture orderFurniture) {
        this.orderFurniture = orderFurniture;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.week_);
        hash = 79 * hash + Objects.hashCode(this.month_);
        hash = 79 * hash + Objects.hashCode(this.year_);
        hash = 79 * hash + Objects.hashCode(this.orderFurniture);
        hash = 79 * hash + Objects.hashCode(this.model);
        hash = 79 * hash + Objects.hashCode(this.part);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DoneWork other = (DoneWork) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.week_, other.week_)) {
            return false;
        }
        if (!Objects.equals(this.month_, other.month_)) {
            return false;
        }
        if (!Objects.equals(this.year_, other.year_)) {
            return false;
        }
        if (!Objects.equals(this.orderFurniture, other.orderFurniture)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.part, other.part)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DoneWork{" + "id=" + id + ", week_=" + week_ + ", month_=" + month_ + ", year_=" + year_ + ", orderFurniture=" + getOrderFurniture().getName() + ", model=" + getModel().getName() + ", part=" +getPart().getSerial()+". "+ getPart().getDescription() + '}';
    }

       
}
