/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalData;

import date.OrderDate;
import items.Model;
import items.Order;
import items.Part;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.resource.spi.work.Work;
import people.Worker;

/**
 *
 * @author pupil
 */
@Entity
public class DoneWork implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Integer week;// = OrderDate.getWeek();
    private Integer month;// = OrderDate.getMonth();
    private Integer year;// = OrderDate.getYear();
    private Long orderNo;// = Order.getOrderNo();
    private String orderName;// = Order.getName();
    private String modelName;// = Model.getName();
    private String partName;// = Part.getName();
    private Integer money;// = Part.getPrice();
    private String workerFirstname;// = Worker.getFirstname();
    private String workerSurname;// = Worker.getLastname();

    public DoneWork() {
    }

    public DoneWork(Integer week, Integer month, Integer year, Long orderNo, String orderName, String modelName, String partName, Integer money, String workerFirstname, String workerSurname) {
        this.week = week;
        this.month = month;
        this.year = year;
        this.orderNo = orderNo;
        this.orderName = orderName;
        this.modelName = modelName;
        this.partName = partName;
        this.money = money;
        this.workerFirstname = workerFirstname;
        this.workerSurname = workerSurname;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getWorkerFirstname() {
        return workerFirstname;
    }

    public void setWorkerFirstname(String workerFirstname) {
        this.workerFirstname = workerFirstname;
    }

    public String getWorkerSurname() {
        return workerSurname;
    }

    public void setWorkerSurname(String workerSurname) {
        this.workerSurname = workerSurname;
    }
    
    
}
