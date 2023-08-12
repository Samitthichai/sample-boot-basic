package th.mfu;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List ;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @JsonProperty("first_name")
    private String firstname;
    
    @JsonProperty("last_name")
    private String lastname;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthday;
    private long salary;

    //relationship to other entities
    @ManyToOne(cascade = CascadeType.MERGE)//update เข้าไปใหม่ //มี การsetไว้ก่อน แล้ว เมื่ออันใหม่เข้ามาเอาอันใหม่ไปmatchกับข้อมูลที่setไว้อยู่เเล้ว
    @JoinColumn(name="position_id", referencedColumnName="id")
    private Position position;


   


    @OneToOne(cascade = CascadeType.PERSIST) //add เข้าไปใหม่ //2 entity ส่งข้อมูลไปพร้อมกัน
    @JoinColumn(name="account_id", referencedColumnName="id")
    private Account account;
    


    public Employee() {
    }

    public Employee(Long id, String firstname, String lastname, Date birthday, long salary) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.salary = salary;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
   
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    

    

}
