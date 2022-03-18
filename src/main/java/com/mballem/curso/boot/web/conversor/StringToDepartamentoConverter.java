package com.mballem.curso.boot.web.conversor;

import com.mballem.curso.boot.domain.Departamento;
import com.mballem.curso.boot.service.DepartamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public Departamento convert(String source) {
        if(source.isBlank()){
            return null;
        }

        Long id = Long.valueOf(source);
        return departamentoService.buscarPorId(id);
    }
    
}
