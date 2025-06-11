package logginframework;

import logginframework.formatter.DefaultFormatter;
import logginframework.logappender.ConsoleAppender;
import logginframework.model.LogLevel;
import logginframework.model.LogMessage;

public class Logger {
    public static final Logger instance = new Logger();
    private LoggerConfig config;

    private Logger() {
        config=new LoggerConfig(LogLevel.INFO,new ConsoleAppender(new DefaultFormatter()));
    }

    public static Logger getLogger() {
        return instance;
    }

    public void setConfig(LoggerConfig config) {
        this.config = config;
    }

    public void log(LogLevel level, String message) {
         if(level.ordinal()>=config.getLevel().ordinal()){
             LogMessage logMessage=new LogMessage(level,message);
             config.getAppender().append(logMessage);
         }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG,message);
    }
    public void info(String message) {
        log(LogLevel.INFO,message);
    }
    public void warn(String message) {
        log(LogLevel.WARN,message);
    }
    public void error(String message) {
        log(LogLevel.ERROR,message);
    }
    public void fatal(String message) {
        log(LogLevel.FATAL,message);
    }
}
