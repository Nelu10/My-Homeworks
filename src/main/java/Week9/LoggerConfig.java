package Week9;

import java.util.logging.*;

public class LoggerConfig {
    public static void configure() {
        Logger logger = Logger.getLogger(StudentRepository.class.getName());
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);
    }
}