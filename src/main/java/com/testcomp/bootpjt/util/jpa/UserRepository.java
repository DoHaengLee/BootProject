package com.testcomp.bootpjt.util.jpa;

import org.springframework.data.jpa.repository.JpaRepository;



//JpaRepository를 상속하면 @Repository가 없어도 됨
public interface UserRepository extends JpaRepository<UserEntity, Long> {
/*
 AND 	 : findByLastnameAndFirstname 				(예. where x.lastname = ?1 and x.firstname = ?2) 
 OR 	 : findByLastnameOrFirstname 				(예. where x.lastname = ?1 or x.firstname = ?2) 
 IS 	 : findByName,findByNameIs,findByNameEquals (예. where x.name = ?1) 
 BETWEEN : findBySalBetween 						(예. where x.sal between ?1 and ?2)
 */
	
	
}