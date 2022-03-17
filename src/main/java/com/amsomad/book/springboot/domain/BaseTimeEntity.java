package com.amsomad.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    /*
    @MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity를 상속할경우
           createdDate, modifiedDate 도 칼럼으로 인식하도록 한다.
           즉 JPA가 동작할때 칼럼인지가 자동으로 안되니 @MappedSuperclass를 명시 해줘야 인식하나보다.
    
    @EntityListeners(AuditingEntityListener.classs) : BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
            Auditing 기능은뭘까 ?
    
    @CreatedDate : Entity가 저장시 시간을 자동저장
    @LastModifiedDate : 조회한 Entity의 값이 변경될때 시간을 자동저장

     */
}
