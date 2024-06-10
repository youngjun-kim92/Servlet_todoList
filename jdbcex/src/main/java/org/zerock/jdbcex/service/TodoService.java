package org.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // TodoDTO를 파라미터로 받아서 TodoVO로 변환하는 과정
    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        //System.out.println("todoVO: " + todoVO);
        log.info(todoVO);

        // 데이터베이스의 CRUD가 들어있는 기능의 모음
        // todoDTO -> todoVO로 변환해서 DTO처럼 사용할 수 있게 insert 기능 실행
        // dao 기능을 사용하여 todoVO를 등록
        dao.insert(todoVO);
    }

    // dtoList 변수에 voList의 각 요소를 TodoDTO로 매핑한 후 결과를 리스트로 수집한 리스트 객체가 저장된다
    // 이렇게하면 dtoList에는 TodoDTO 객체들의 리스트가 저장되게 된다
    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = dao.selectAll();

        log.info("voList.........");

        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    // TodoDAO의 selectOne()을 통해서 TodoVO 객체를 가져오고, ModelMapper를 이용해서 TodoDTO로 변환한다.
    public TodoDTO get(Long tno) throws Exception {

        log.info("tno: "+tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }

    public void remove(Long tno)throws Exception {

        log.info("ton: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO)throws Exception {

        log.info("todoDTO: "+ todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);

    }

}