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
    private Integer _week;// = OrderDate.getWeek();
    private Integer _month;// = OrderDate.getMonth();
    private Integer _year;// = OrderDate.getYear();
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private OrderFurniture orderFurniture;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Model model;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Part part;

    public DoneWork() {
    }

    public DoneWork(Integer _week, Integer _month, Integer _year, OrderFurniture orderFurniture, Model model, Part part) {
        this._week = _week;
        this._month = _month;
        this._year = _year;
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

    public Integer getWeek() {
        return _week;
    }

    public void setWeek(Integer _week) {
        this._week = _week;
    }

    public Integer getMonth() {
        return _month;
    }

    public void setMonth(Integer _month) {
        this._month = _month;
    }

    public Integer getYear() {
        return _year;
    }

    public void setYear(Integer _year) {
        this._year = _year;
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
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this._week);
        hash = 29 * hash + Objects.hashCode(this._month);
        hash = 29 * hash + Objects.hashCode(this._year);
        hash = 29 * hash + Objects.hashCode(this.orderFurniture);
        hash = 29 * hash + Objects.hashCode(this.model);
        hash = 29 * hash + Objects.hashCode(this.part);
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
        if (!Objects.equals(this._week, other._week)) {
            return false;
        }
        if (!Objects.equals(this._month, other._month)) {
            return false;
        }
        if (!Objects.equals(this._year, other._year)) {
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
    


    
}
