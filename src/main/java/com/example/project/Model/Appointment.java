package com.example.project.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(generator = "uuid", strategy= GenerationType.SEQUENCE)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String booking_id;
    private String disease;

    private Date tentativeDate;
    private String priority;

    private String patientId;
    private Date bookingTime;

    public Appointment( String disease, Date tentativeDate, String priority, String patientId) {
        super();

        this.disease = disease;
        this.tentativeDate = tentativeDate;
        this.priority = priority;
        this.patientId = patientId;

    }

}
