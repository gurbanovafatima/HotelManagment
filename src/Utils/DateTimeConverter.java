/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author hp1
 */
public class DateTimeConverter {
    
    public Date convertToSqlDate(LocalDateTime localDateTime){
        Date sqlDate = Date.valueOf(localDateTime.toLocalDate());
        return sqlDate;
    }
    
    public LocalDateTime convertToLocalDateTime(Date sqlDate){
         return Instant.ofEpochMilli(sqlDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
