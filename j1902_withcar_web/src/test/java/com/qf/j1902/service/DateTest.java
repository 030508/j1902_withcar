package com.qf.j1902.service;

import org.junit.Test;
import org.omg.CORBA.DATA_CONVERSION;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    @Test
    public void Sui() throws ParseException {
      /*  Date date = new Date();
        System.out.println(date);
        Long integer = Long.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(date))/1000;
        System.out.println(integer);

        Date date1 = new Date(integer);
        date.setTime(integer);

        DateFormat dateformat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        dateformat.format(date);
        System.out.println(dateformat.format(date));*/
        Integer integer = Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10));//创建时间并进行


        Date nedate = new Date(new Long(integer)*1000);   //把Integer 转换成

        DateFormat dateformat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println(dateformat.format(nedate));
    }
    @Test
    public void aa() throws ParseException {
        Date nedate = new Date();
        DateFormat dateformat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        int seconds=1562329137;
        long millions=new Long(seconds)*1000;
        nedate.setTime(millions);
        Date d=new Date(millions);
//        System.out.println("time:"+d.toString());
//        System.out.println(1295539200.0/(60*60*24*365));
        Date oldDate = dateformat.parse("1970-01-01 00:00:00");
        System.out.println(dateformat.format(oldDate));
        System.out.println(nedate.after(oldDate));
        System.out.println(dateformat.format(nedate));

        System.out.println(nedate.getTime());
        System.out.println(oldDate.getTime());
    }
}
