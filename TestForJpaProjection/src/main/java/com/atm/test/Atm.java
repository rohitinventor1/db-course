package com.atm.test;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Entity
@Table(name = "atm_cash_pickup", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "atm_identifier", "expected_pickup" }) })
public class Atm {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	@NotNull
	@Column(name = "atm_identifier")
	private String atmIdentifier;

	@NotNull
	@Column(name = "expected_pickup")
	private LocalDate expectedPickup;

	@Column(name = "actual_pickup")
	private LocalDate actualPickup;

}
interface AtmProjection {
	String getAtmIdentifier();
	LocalDate getExpectedPickup();
	LocalDate getActualPickup();
	Integer getId();
}
interface AtmidProjection {
	String getAtmIdentifier();
	
}

@Data
@AllArgsConstructor
class AtmClassProjection {
	private String atmIdentifier;
	private LocalDate expectedPickup;
	private LocalDate actualPickup;	
}
