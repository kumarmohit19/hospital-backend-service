package com.example.project.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Setter
@Getter
public class Patient {
	
	@Id
	@GeneratedValue(generator = "uuid", strategy= GenerationType.SEQUENCE)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String patient_Id;
    private String patient_name;
    private String patient_email;
    private String patient_mobile;
    private Date registeredDate;


    public Patient(String patient_name, String patient_email, String patient_mobile, Date registeredDate) {
        this.patient_name = patient_name;
        this.patient_email = patient_email;
        this.patient_mobile = patient_mobile;
        this.registeredDate = registeredDate;
    }

    public Patient() {
        super();
    }

}
