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
    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
    private OrderDate orderDate;
    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
    private OrderFurniture orderFurniture;
    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
    private Model model;
    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
    private Part part;
    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
    private Worker worker;

    public DoneWork() {
    }

    public DoneWork(OrderDate orderDate, OrderFurniture orderFurniture, Model model, Part part, Worker worker) {
        this.orderDate = orderDate;
        this.orderFurniture = orderFurniture;
        this.model = model;
        this.part = part;
        this.worker = worker;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OrderDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OrderDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.orderDate);
        hash = 67 * hash + Objects.hashCode(this.orderFurniture);
        hash = 67 * hash + Objects.hashCode(this.model);
        hash = 67 * hash + Objects.hashCode(this.part);
        hash = 67 * hash + Objects.hashCode(this.worker);
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
        if (!Objects.equals(this.orderDate, other.orderDate)) {
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
        return true;
    }


    


    
}