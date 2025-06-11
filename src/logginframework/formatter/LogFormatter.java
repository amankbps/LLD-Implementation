package logginframework.formatter;

import logginframework.model.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}
