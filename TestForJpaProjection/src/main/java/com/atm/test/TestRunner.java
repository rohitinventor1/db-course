package com.atm.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	AtmRepository atmRepository;
	@Override
	public void run(String... args) throws Exception {
		//List<Atm> o = atmRepository.get();
		List<AtmProjection> o = atmRepository.get();
		//List<AtmClassProjection> o = atmRepository.get();

	System.out.println("aya ither"+o.get(0).getClass().getName());
	System.out.println("aya ither"+o.get(0).getAtmIdentifier());	
	System.out.println("aya ither"+o.get(0).getExpectedPickup());	

	
		
		
		
//		
//	List<Atm> atms=new ArrayList<Atm>();
//	List<Object[]> obj = atmRepository.getIdentifier();
//	System.out.println(obj.size());
//	obj.stream()
//	.forEach(obs->
//	{	
//		Atm a = new Atm();
//		LocalDate expectedPickup = LocalDate.parse((obs[1].toString()));
//		if(obs[2]!=null){
//			LocalDate actualPickup = LocalDate.parse((obs[2].toString()));
//			a.setActualPickup(actualPickup);
//		}
//		a.setAtmIdentifier(obs[0].toString());
//		a.setExpectedPickup(expectedPickup);		
//		atms.add(a);
//	});
//	atms.stream().forEach(System.out::println);
	
	}

}


