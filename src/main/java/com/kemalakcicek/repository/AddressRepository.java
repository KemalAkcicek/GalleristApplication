package com.kemalakcicek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalakcicek.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
