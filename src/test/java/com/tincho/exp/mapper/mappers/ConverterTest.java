package com.tincho.exp.mapper.mappers;

import org.easymock.EasyMockRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public abstract class ConverterTest<A, B> {

    public abstract A generateA();

    public abstract B generateB();

    @Test
    public abstract void mapAtoBTest();

    @Test
    public abstract void mapBtoATest();
}
