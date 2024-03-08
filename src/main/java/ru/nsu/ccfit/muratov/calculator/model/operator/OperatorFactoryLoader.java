package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

final class OperatorFactoryLoader implements AutoCloseable {
    private final Scanner scanner;

    private static final Logger logger = Logger.getLogger(OperatorFactoryLoader.class.getCanonicalName());

    public OperatorFactoryLoader(String filename) {
        URL resource = getClass().getClassLoader().getResource(filename);
        try {
            if(resource == null) {
                throw new FileNotFoundException("file not found!");
            }
            scanner = new Scanner(new File(resource.toURI()));
        }
        catch (FileNotFoundException | URISyntaxException e) {
            logger.severe(e::getMessage);
            throw new RuntimeException(e);
        }
    }

    public Map<String, Operator> loadClasses() {
        Map<String, Operator> operatorMap = new HashMap<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split("\\s+");
            String name = values[0];
            String className = values[1];
            Operator operator;
            try {
                operator = (Operator) Class.forName(className).getConstructor().newInstance();
            }
            catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                logger.severe(e::getMessage);
                continue;
            }
            catch (ClassCastException e) {
                logger.severe(() -> String.format("%s is not a subclass for the class Operator", className));
                continue;
            }
            operatorMap.put(name, operator);
        }
        return operatorMap;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
