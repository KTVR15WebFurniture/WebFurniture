/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pupil
 */
@Entity
public class OrderDate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer _week;
    private Integer _month;
    private Integer _year;
   
    public OrderDate() {
    }

    public OrderDate(Integer week, Integer month, Integer year) {
        this._week = week;
        this._month = month;
        this._year = year;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this._week);
        hash = 23 * hash + Objects.hashCode(this._month);
        hash = 23 * hash + Objects.hashCode(this._year);
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
        final OrderDate other = (OrderDate) obj;
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
        return true;
    }

    
    

}
