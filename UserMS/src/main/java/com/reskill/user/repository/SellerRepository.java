package com.reskill.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reskill.user.entity.Seller;

public interface SellerRepository extends CrudRepository<Seller,String> {

	Optional<Seller> findByPhoneNumber(long phoneNumber);

}
