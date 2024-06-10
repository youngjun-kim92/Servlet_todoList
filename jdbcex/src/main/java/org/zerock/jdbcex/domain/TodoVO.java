package org.zerock.jdbcex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter  // getTno, getTitle
@Builder // TodoVO.builder().build()
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {  // 주로 읽기 전용으로 사용하는 경우가 많다
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
