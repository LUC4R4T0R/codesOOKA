package org.bonn.ooka.buchungssystem.ss2022.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    public void log(String message){
        System.out.println(new SimpleDateFormat("dd.MM.yy HH:mm").format(Calendar.getInstance().getTime()) +
                ": Zugriff auf Buchungssystem über Methode "+Thread.currentThread().getStackTrace()[2].getMethodName()+
                ". "+message);
    }
}
