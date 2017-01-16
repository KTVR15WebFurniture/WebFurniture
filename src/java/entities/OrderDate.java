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
    private Integer week_;
    private Integer month_;
    private Integer year_;
   
    public OrderDate() {
    }

    public OrderDate(Integer week_, Integer month_, Integer year_) {
        this.week_ = week_;
        this.month_ = month_;
        this.year_ = year_;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.week_);
        hash = 17 * hash + Objects.hashCode(this.month_);
        hash = 17 * hash + Objects.hashCode(this.year_);
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
        if (!Objects.equals(this.week_, other.week_)) {
            return false;
        }
        if (!Objects.equals(this.month_, other.month_)) {
            return false;
        }
        if (!Objects.equals(this.year_, other.year_)) {
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return "OrderDate{" + "id=" + id + ", week_=" + week_ + ", month_=" + month_ + ", year_=" + year_ + '}';
    }

}
