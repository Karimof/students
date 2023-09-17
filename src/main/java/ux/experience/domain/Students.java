package ux.experience.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.sql.Date;

@Entity(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String description;

    private Date study_start_date;

    private Date study_end_date;

    private String gender;

    private Date birthDate;

    private LocalDateTime created_at;

    @ManyToOne
    private Studies studies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStudy_start_date() {
        return study_start_date;
    }

    public void setStudy_start_date(Date study_start_date) {
        this.study_start_date = study_start_date;
    }

    public Date getStudy_end_date() {
        return study_end_date;
    }

    public void setStudy_end_date(Date study_end_date) {
        this.study_end_date = study_end_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }
}