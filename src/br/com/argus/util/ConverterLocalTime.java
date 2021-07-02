/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.util;

import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.AttributeConverter;


/**
 *
 * @author Hakkinen
 */
public class ConverterLocalTime implements AttributeConverter<LocalTime, Time>{

    @Override
    public Time convertToDatabaseColumn(LocalTime x) {
        return Time.valueOf(x);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time y) {
        return y.toLocalTime();
    }
    
    
    
}
