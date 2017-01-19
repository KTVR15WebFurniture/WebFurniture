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
    private Integer week;// = OrderDate.getWeek();
    private Integer month;// = OrderDate.getMonth();
    private Integer year;// = OrderDate.getYear();
    @OneToOne(cascade = CascadeType.REFRESH)
    private OrderFurniture orderFurniture;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Model model;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Part part;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Worker worker;
    private Integer done = 0;

    public DoneWork() {
    }

    public DoneWork(Integer week, Integer month, Integer year, OrderFurniture orderFurniture, Model model, Part part, Worker worker) {
        this.week = week;
        this.month = month;
        this.year = year;
        this.orderFurniture = orderFurniture;
        this.model = model;
        this.part = part;
        this.worker = worker;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.week);
        hash = 31 * hash + Objects.hashCode(this.month);
        hash = 31 * hash + Objects.hashCode(this.year);
        hash = 31 * hash + Objects.hashCode(this.orderFurniture);
        hash = 31 * hash + Objects.hashCode(this.model);
        hash = 31 * hash + Objects.hashCode(this.part);
        hash = 31 * hash + Objects.hashCode(this.worker);
        hash = 31 * hash + Objects.hashCode(this.done);
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
        if (!Objects.equals(this.week, other.week)) {
            return false;
        }
        if (!Objects.equals(this.month, other.month)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
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
        if (!Objects.equals(this.worker, other.worker)) {
            return false;
        }
        if (!Objects.equals(this.done, other.done)) {
            return false;
        }
        return true;
    }

    
}