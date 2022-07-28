package com.authoritydmc.learn.Entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "users")
@ApiModel(description = "User model")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ApiModelProperty(notes = "Name of user",required = true)
    String name;
    @ApiModelProperty(notes = "Email of user",required = true)
    String email;
    String imgUrl;
    String phoneNumber;

    Date reg_date;


}
