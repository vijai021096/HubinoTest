package com.hubino.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hubino.jwt.model.Address;



@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
