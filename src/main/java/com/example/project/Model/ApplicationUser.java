package com.example.project.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
public class ApplicationUser {
    @Id
    public String username;
    public String user_email;
    public String password;
    public String user_mobile;
    public String location;

    public ApplicationUser(String username, String user_email, String password, String user_mobile, String location) {
        super();
        this.username = username;
        this.user_email = user_email;
        this.password = password;
        this.user_mobile = user_mobile;
        this.location = location;
    }

    public ApplicationUser() {
        super();
    }

    public ApplicationUser(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    //    public Date user_dob;

}
