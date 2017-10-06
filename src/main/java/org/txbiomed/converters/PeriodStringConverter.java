/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.converters;

import java.time.Period;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author lkacimi
 */
@Converter
public class PeriodStringConverter implements AttributeConverter<Period, String> {

    @Override
    public String convertToDatabaseColumn(Period p) {
        return p.toString();
    }

    @Override
    public Period convertToEntityAttribute(String s) {
        return Period.parse(s);
    }
    
}
