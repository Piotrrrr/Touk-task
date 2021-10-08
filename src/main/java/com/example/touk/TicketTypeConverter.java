package com.example.touk;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class TicketTypeConverter implements AttributeConverter<TicketType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TicketType ticketType) {
        if(ticketType==null) {
            return null;
        }
        return ticketType.getId();
    }

    @Override
    public TicketType convertToEntityAttribute(Integer i) {
        if(i == null){
            return null;
        }
        return (TicketType) Arrays.stream(TicketType.values()).sorted().toArray()[i-1];
    }
}
