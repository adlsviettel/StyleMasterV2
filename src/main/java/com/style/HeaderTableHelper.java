package com.style;

import lombok.RequiredArgsConstructor;
import org.springframework.util.ReflectionUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HeaderTableHelper<T> {
    public List<String> getHeaders(T object){
        List<String> ls=new ArrayList<>();
        ReflectionUtils.doWithFields(object.getClass(), field -> {
            field.setAccessible(true);
            ls.add(field.getName());
        });
        return ls;
    }
}
