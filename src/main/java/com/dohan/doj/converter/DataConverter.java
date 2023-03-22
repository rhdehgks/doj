package com.dohan.doj.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataConverter {
    private ModelMapper modelMapper;

    @Autowired
    public DataConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, E> D convertToDto(E entity) { // 찾아보니 리플렉션은 성능 이슈가 있어서..수정해야할 듯.
        try {
            String entityClassName = entity.getClass().getSimpleName(); // get name without package
            return modelMapper.map(entity, (Class<D>)Class.forName("com.dohan.doj.dto." + entityClassName + "Dto"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <E, D> E convertToEntity(D dto) {
        try {
            String dtoClassName = dto.getClass().getSimpleName();
            return modelMapper.map(dto, (Class<E>)Class.forName("com.dohan.doj.entity." + dtoClassName.substring(0, dtoClassName.length() - 3)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
