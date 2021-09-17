package br.com.gustavolemillion;

import java.sql.Date;

public class Data {

    public static Date pedirData(){
        String dataStr = Console.leLinhaTexto();

        //XX-XX-XXXX
        //XXXX-XX-XX
        String temp = dataStr;
        dataStr = temp.substring(6,10) + "-" + temp.substring(3,5) + "-" + temp.substring(0,2);

        Date date = Date.valueOf(dataStr);//converting string into sql date

        return date;
    }
}
