package org.zerock.jdbcex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import lombok.extern.log4j.Log4j2;

@WebServlet(name ="todoListController", value="/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("todo list...............");

        try {
            List<TodoDTO> dtoList = todoService.listAll();  // VO -> DTO로 변환해서 리스트를 출력하는 메서드
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }


    }
}
