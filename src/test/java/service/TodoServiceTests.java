package service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach  // 테스트 메서드가 실행되기 전에 호출되는 메서드
    public void read() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC Test Title2")
                .dueDate(LocalDate.now())
                .build();

        log.info("--------------------------------");  // 테스트 코드의 log4j2
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}