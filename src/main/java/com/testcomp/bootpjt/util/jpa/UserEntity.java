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

	 * Setter�� �����ؾ� �� > DTO�� ���� ����ϴ� ���� ����
	
	 * Entity������ ���� ������ ���� ����� ��� ����
       camelCase�� �ۼ��ϸ� �˾Ƽ� ����ٷ� ��ȯ (��: sB -> s_b)

     * AutoIncrement
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

    */
    
    @Id                     // PK - Entity�� PK ������ �ʿ��ϸ�, �����ؾ��ϴ� ��� Embeddedid�� ���
    @Column(length = 100)   // ����Ʈ : varchar(255)
    @NotNull                // Column�� nullable=false �� ���� �������� �˻翡 �� �ɸ��� ������ @NotNull ���� �� �� ����
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
