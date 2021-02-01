package com.atm.test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AtmRepository extends JpaRepository<Atm, Integer> {
	//@Query(value = "Select atm_identifier as atmIdentifier,expected_pickup as expectedPickup,actual_pickup as actualPickup from atm_cash_pickup",nativeQuery = true)
	// <T> List<T> get();
	
@Query(value = "select atm_identifier as atmIdentifier , min(expected_pickup) as expectedPickup, max(actual_pickup) as actualPickup" + 
	" from (select t.*," + 
	"             sum(actual_pickup is not null) over (partition by atm_identifier order by expected_pickup desc) as imputed_actual_pickup" + 
	"      from ATM_CASH_PICKUP t" + 
	"     ) t" + 
	" group by atm_identifier, imputed_actual_pickup" + 
	" order by atm_identifier,min(expected_pickup);"
	,nativeQuery = true)
	 List<AtmProjection> get();
	
	<T> List<T> findByAtmIdentifier(String atmIdentifier,Class<T> t);
	
	 @Query(value = "Select atm_identifier ,expected_pickup,actual_pickup from atm_cash_pickup",nativeQuery = true)
	 List<Object[]> getIdentifier();
}
