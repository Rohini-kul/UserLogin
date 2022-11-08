package com.mfsa.da.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table("user")
@Lazy
@Data
@AllArgsConstructor
public class User {
    
    @PrimaryKey
    @Column
    private String userId;
    @Column
    private String password;
    @Column
    private String user_Role;
    @Column
    private String userName;

}
