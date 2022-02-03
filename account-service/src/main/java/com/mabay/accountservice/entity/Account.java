package com.mabay.accountservice.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id;

    @Column(value = "uname")
    private String username;

    @Column(value = "pwd")
    private String password;

    @Column(value = "name")
    private String name;

    @Column(value = "surname")
    private String surname;

    @Column(value = "email")
    private String email;

    @Column(value = "birth_date")
    private Date birthDate;

    @CreatedDate
    @Column(value = "created_at")
    private Date createdAt;

    @Column(value = "is_active")
    private Boolean isActive;

}
