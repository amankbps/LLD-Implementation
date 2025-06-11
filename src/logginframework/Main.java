package logginframework;

import logginframework.formatter.DefaultFormatter;
import logginframework.logappender.FileAppender;
import logginframework.model.LogLevel;

public class Main {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger();

        logger.info("This is Information message");
        logger.warn("This is Warning message");
        logger.error("This is Error message");

        //writing in file
        LoggerConfig config=new LoggerConfig(LogLevel.DEBUG,new FileAppender(
                "app.log",new DefaultFormatter()
        ));
        logger.setConfig(config);
        logger.debug("This is Debug message");
        logger.info("This is Info message");
    }
}
