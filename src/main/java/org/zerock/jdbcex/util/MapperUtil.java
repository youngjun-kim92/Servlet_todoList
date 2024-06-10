package org.zerock.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)  // private로 선언된 필드도 접근이 가능하게 해줌
                .setMatchingStrategy(MatchingStrategies.STRICT);  // 매칭을 엄격하게 (이름과 타입이 정확하게 일치해야 한다)
    }
    public  ModelMapper get() {
        return modelMapper;
    }
}