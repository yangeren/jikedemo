package cn.wanghan.demo.service;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    private DateTimeFormatter formatter;
    private String datePattern;

    public LocalDateFormatter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public String print(LocalDate localDate, Locale locale) {
        return localDate.format(formatter);
    }

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        try {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern(datePattern));
        } catch (DateTimeParseException e) {
            throw new  IllegalArgumentException(
                    "invalid date format. formatter Please use this pattern\"" + datePattern + "\""
            );
        }
    }
}
