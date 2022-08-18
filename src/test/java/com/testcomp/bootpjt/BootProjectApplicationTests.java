package com.testcomp.bootpjt;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcomp.bootpjt.util.jpa.UserDTO;
import com.testcomp.bootpjt.util.jpa.UserEntity;
import com.testcomp.bootpjt.util.jpa.UserRepository;



@SpringBootTest
class BootProjectApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(BootProjectApplicationTests.class);

	@Test
	void contextLoads() {
	}
	
	
	@Autowired
	UserRepository uRepo;

	@Test
	void saveNselect() {
		//save
		uRepo.save(new UserDTO("aaa","aaa").toEntity());
		uRepo.save(new UserDTO("bbb","bbb").toEntity());
		uRepo.save(new UserDTO("ccc","ccc").toEntity());
		
		//select
		List<UserEntity> userList = uRepo.findAll();
		int i = 1;
		for(UserEntity u : userList) {
			UserDTO uDTO = u.toDTO();
			logger.info("["+i+"] id : "+u.getId()+", pw : "+u.getPw());
			i++;
		}
	}
}
