package com.seawave.waterfall;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException
            , NoSuchMethodException
            , InstantiationException
            , IllegalAccessException
            , InvocationTargetException {
        Operator operator = new Operator();
        operator.executeAlgorithm("EmailRegExp");
    }
}
