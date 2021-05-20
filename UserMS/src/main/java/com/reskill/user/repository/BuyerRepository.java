package com.reskill.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.reskill.user.entity.Buyer;



public interface BuyerRepository extends CrudRepository<Buyer,String> {
  public Optional<Buyer> findByPhoneNumber(long phoneno);
}
