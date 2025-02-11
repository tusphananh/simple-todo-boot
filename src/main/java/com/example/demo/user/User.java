package com.example.demo.user;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private String name;
    private Integer id;
    private Date registrationDate;
}
