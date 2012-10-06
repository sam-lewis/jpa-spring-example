package me.samlewis.jpaspring.util;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BeanMapper {
    private final Mapper mapper;

    @Autowired
    public BeanMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        } else {
            return mapper.map(source, destinationClass);
        }
    }

    public <T> List<T> map(List<?> source, Class<T> destinationClass) {
        List<T> result = new ArrayList<T>();
        for (Object object : source) {
            result.add(map(object, destinationClass));
        }
        return result;
    }
}
