package com.rimonmostafiz.elasticlight.component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Rimon Mostafiz
 */
public class EsParameterizedType implements ParameterizedType {
    private final ParameterizedType parameterizedType;
    private final Type[] actualTypes;

    public EsParameterizedType(ParameterizedType parameterizedType, Type[] actualTypes) {
        this.parameterizedType = parameterizedType;
        this.actualTypes = actualTypes;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return actualTypes;
    }

    @Override
    public Type getRawType() {
        return parameterizedType.getRawType();
    }

    @Override
    public Type getOwnerType() {
        return parameterizedType.getOwnerType();
    }
}
