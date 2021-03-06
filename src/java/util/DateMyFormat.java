/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jvm
 */
public class DateMyFormat {
    private Integer curentDey;
    private Integer curentMonth;
    private Integer curentYear;
    private Integer curentWeek;
    private Date curentDate;
    private SimpleDateFormat dateFormat=null;

    public DateMyFormat() {
        curentDate=new Date();
        this.setCurentDey();
        this.setCurentMonth();
        this.setCurentWeek();
        this.setCurentYear();
    }

    public Integer getCurentDey() {
        return curentDey;
    }

    public void setCurentDey() {
        dateFormat = new SimpleDateFormat("d");
        this.curentDey = Integer.decode(dateFormat.format(curentDate));;
    }

    public Integer getCurentMonth() {
        return curentMonth;
    }

    public void setCurentMonth() {
        dateFormat = new SimpleDateFormat("M");
        this.curentMonth = Integer.decode(dateFormat.format(curentDate));;
    }

    public Integer getCurentYear() {
        return curentYear;
    }

    public void setCurentYear() {
        dateFormat = new SimpleDateFormat("yyyy");
        this.curentYear = Integer.decode(dateFormat.format(curentDate));;
    }

    public Integer getCurentWeek() {
        return curentWeek;
    }

    public void setCurentWeek() {
        dateFormat = new SimpleDateFormat("w");
        this.curentWeek = Integer.decode(dateFormat.format(curentDate));;
    }
    
    
}
