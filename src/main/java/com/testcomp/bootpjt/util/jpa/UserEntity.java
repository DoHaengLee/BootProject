package com.testcomp.bootpjt.util.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;



@Entity
@Getter
@NoArgsConstructor
@Table(name="boot_users")
public class UserEntity {
	/*

	 * Setter는 지양해야 함 > DTO를 통해 사용하는 것을 권장
	
	 * Entity에서는 오류 방지를 위해 언더바 사용 금지
       camelCase로 작성하면 알아서 언더바로 전환 (예: sB -> s_b)

     * AutoIncrement
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

    */
    
    @Id                     // PK - Entity는 PK 설정이 필요하며, 복합해야하는 경우 Embeddedid로 사용
    @Column(length = 100)   // 디폴트 : varchar(255)
    @NotNull                // Column에 nullable=false 할 때는 제약조건 검사에 안 걸리기 때문에 @NotNull 쓰는 게 더 안전
    private String id;

    @Column(length = 500)
    @NotNull
    private String pw;

    @Column(length = 500)
    private String seed;

    @Column()
    private Timestamp refexp;
    
    @Column()
    private Timestamp accexp;

    
    
    @Builder
    public UserEntity(String id, String pw, String seed, Timestamp refexp, Timestamp accexp) {
		this.id = id;
		this.pw = pw;
		this.seed = seed;
		this.refexp = refexp;
		this.accexp = accexp;
	}
    
    // Entity -> DTO
    public UserDTO toDTO() {
        return UserDTO.builder()
		    	.id(id)
		    	.pw(pw)
		    	.seed(seed)
		        .refexp(refexp)
		        .accexp(accexp)
		        .build();
    }
}
