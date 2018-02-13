package cn.wanghan.demo.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MyConverter implements Converter<String, LocalDate>{

    private String dataPattern;

    public MyConverter(String dataPattern) {
        this.dataPattern = dataPattern;
    }

    @Nullable
    @Override
    public LocalDate convert(String aLong) {
        try {
            return LocalDate.parse(aLong, DateTimeFormatter.ofPattern(dataPattern));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "invalid date format. Please use this pattern\"" + dataPattern + "\""
            );
        }
    }
}
