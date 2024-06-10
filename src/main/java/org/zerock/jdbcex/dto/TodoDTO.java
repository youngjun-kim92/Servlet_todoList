package org.zerock.jdbcex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data  // getter/setter/toString/quals/hasCode
@NoArgsConstructor  // 매개값이 없는 생성자
@AllArgsConstructor  // 매개값이 있는 생성자
public class TodoDTO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}