package store.store_api.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){
        var mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        SimpleModule dateModule = new SimpleModule();
        dateModule.addSerializer(LocalDateTime.class, new CustomLocalDateTimeSerializer(localDateTimeFormatter));
        mapper.registerModule(dateModule);

        return mapper;
    }

    public static class CustomLocalDateTimeSerializer extends com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer {
        public CustomLocalDateTimeSerializer(DateTimeFormatter formatter) {
            super(formatter);
        }
    }

}
