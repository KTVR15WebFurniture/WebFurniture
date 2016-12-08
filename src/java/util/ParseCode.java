
package util;

import java.util.Calendar;


public class ParseCode {
    private String code;
    private String gender;
    private int day;
    private int month;
    private int year;

    public ParseCode() {
    }

    public ParseCode(String code) {
        setCode(code);
        parse(code);
    }
    private void setCode(String code) {
        this.code = code;
    }
    private void setGender(String gender){
        this.gender=gender;
    }
    public int getDay() {
        return day;
    }

    private void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    private void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }
    private void parse(String code){
        String youCode = code;
        String g=youCode.substring(0, 1);
        int gen=Integer.parseInt(g);
        String year;
        
        switch (gen) {
            case 3:
                {
                    year= "19"+youCode.substring(1,3);
                    setGender("Мужчина");
                    break;
                }
            case 5:
                {
                    year= "20"+youCode.substring(1,3);
                    setGender("Мужчина");
                    break;
                }
            case 4:
                {
                    year= "19"+youCode.substring(1,3);
                    setGender("Женщина");
                    break;
                }
            case 6:
                {
                    year= "20"+youCode.substring(1,3);
                    setGender("Женщина");
                    break;
                }
            default:
                {
                    year= "0";
                    break;
                }
        }
        setYear(Integer.parseInt(year));
        String month = youCode.substring(3,5);
        setMonth(Integer.parseInt(month));
        String day = youCode.substring(5,7);
        setDay(Integer.parseInt(day));
        
    }
    
    public Integer getAge(){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(getYear(), getMonth(), getDay());
        // include day of birth
        dob.add(Calendar.DAY_OF_MONTH, -1);
    // System.out.println("\ntoday="+today.get(Calendar.YEAR)+" \ndob="+dob.get(Calendar.YEAR));
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public String getBirthday(){
        String d=Integer.toString(getDay());
        String m=Integer.toString(getMonth());
        String y=Integer.toString(getYear());
        if(getMonth()>9){
           return  d+"."+m+"."+y;    
        }else{
           return  d+".0"+m+"."+y;
        }
        
    }
 
}
