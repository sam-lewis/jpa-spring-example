package me.samlewis.jpaspring.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class User extends BaseDomainObject {
    @Column(nullable = true, length = 30)
    private String title;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Basic(optional = false)
    private String gender;

    @Basic(optional = true)
    private Date dateOfBirth;

    @Column(nullable = true, length = 15)
    private String phone;

    @Column(unique = true, nullable = false, length = 255)
    private String email;

    @Basic
    private String role;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
