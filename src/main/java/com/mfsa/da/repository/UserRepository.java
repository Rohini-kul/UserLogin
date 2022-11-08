package com.mfsa.da.repository;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.mfsa.da.model.User;

@Repository

public interface UserRepository extends CassandraRepository<User, UUID>{
    
    User findByUserId(String tempUserId);
    @Query(allowFiltering=true)
    User findByUserIdAndPassword(String tempUserId, String tempPass);

}
