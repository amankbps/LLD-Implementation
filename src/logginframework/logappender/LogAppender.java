package logginframework.logappender;

import logginframework.model.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
