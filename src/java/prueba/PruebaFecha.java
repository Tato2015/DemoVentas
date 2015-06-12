/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gachuy
 */
public class PruebaFecha {

   public static void main(String[] args) {
   String pattern ="yyyy-MM-dd";
   SimpleDateFormat formatter = new SimpleDateFormat(pattern);
   Date now = new Date();
   String mysqlDateString = formatter.format(now);
   
       System.out.println("Java's default date format : "+ now);
       System.out.println("MySql's default date format : "+ mysqlDateString);
    }
    
}
