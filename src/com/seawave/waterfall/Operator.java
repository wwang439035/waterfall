package com.seawave.waterfall;

import com.seawave.algorithms.IAlgorithm;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;

public class Operator {
    final String ALGORITHM_DIR = "./src/com/seawave/algorithms";

    HashMap<String, IAlgorithm> algorithmHashMap = new HashMap<>();

    public Operator() throws ClassNotFoundException
            , NoSuchMethodException
            , InvocationTargetException
            , InstantiationException
            , IllegalAccessException {

        File algorithmFolder = new File(ALGORITHM_DIR);
        registerAlgorithms(algorithmFolder);
    }

    private void registerAlgorithms(File algorithmFolder) throws ClassNotFoundException
            , NoSuchMethodException
            , IllegalAccessException
            , InvocationTargetException
            , InstantiationException {

        for (File file : Objects.requireNonNull(algorithmFolder.listFiles())) {
            if (file.isDirectory())
                registerAlgorithms(algorithmFolder);
            else {
                String className = file.getName().split("\\.")[0];
                if (!"IAlgorithm".equals(className)) {
                    algorithmHashMap.put(className, (IAlgorithm) Class
                                    .forName("com.seawave.algorithms." + className)
                                    .getConstructor()
                                    .newInstance());
                }
            }
        }
    }

    public void executeAlgorithm(String algorithmName) {
        IAlgorithm algorithm = algorithmHashMap.get(algorithmName);
        if (algorithm != null) {
            algorithm.execute();
        }
    }
}
