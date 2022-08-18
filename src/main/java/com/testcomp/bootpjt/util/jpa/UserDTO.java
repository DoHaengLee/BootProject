package com.testcomp.bootpjt.util.jpa;

import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

import javax.persistence.Column;



@Data
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	private String id;
	private String pw;
	private String seed;
    private Timestamp refexp;
    private Timestamp accexp;

    public UserDTO(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
    
    @Builder
    public UserDTO(String id, String pw, String seed, Timestamp accexp, Timestamp refexp) {
        this.id = id;
        this.pw = pw;
        this.seed = seed;
		this.refexp = refexp;
		this.accexp = accexp;
    }
    
    // DTO -> Entity
    public UserEntity toEntity() {
        return UserEntity.builder()
		    	.id(id)
		    	.pw(pw)
		    	.seed(seed)
		        .refexp(refexp)
		        .accexp(accexp)
		        .build();
    }
}