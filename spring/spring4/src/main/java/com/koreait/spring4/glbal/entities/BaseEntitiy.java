package com.koreait.spring4.glbal.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
public class BaseEntitiy {
    @CreatedDate // 현재 날짜 자동 으로 설정
    @Column("create")
    private LocalDateTime createAt;

    @LastModifiedDate// 마지막 수정 날짜
    @Column("modifiedAt")
    private LocalDateTime modifiedAt;

    @Column("delete") // 객체 필드나 데이터 베이스 사옹
    private LocalDateTime deleteAt;











}
