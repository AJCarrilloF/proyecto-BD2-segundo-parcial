/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author Angek
 */
public class Utiles {
    public static final int TO_INTEGER=0;
    public static final int TO_FLOAT=1;
    public static final int TO_DOUBLE=2;
    
    
    
   public static void errCmpsVacios(String txt)
   {
       String mensaje="Los campos: ";
       if(txt.isEmpty())
       {
           JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacío.","ERROR",0);
       }
       else
       {
           
           String[] campos = txt.split(",");
           for(int i = 0;i<campos.length;i++)
           {
               mensaje+=campos[i]+" ";
           }
           mensaje+="no pueden estar vacíos.";
           JOptionPane.showMessageDialog(null, mensaje,"ERROR",0);
           
       }
   }
   
   public static boolean chckNumber(String source,int parsingTo)
   {
       switch(parsingTo)
       {
           case 0:
               try
               {
                   Integer.parseInt(source);
               }
               catch(Exception a)
               {
                   return false;
               }
            break;
           case 1:
               try
               {
                   Float.parseFloat(source);
               }
               catch(Exception a)
               {
                   return false;
               }
            break;
           case 2:
               try
               {
                   Double.parseDouble(source);
               }
               catch(Exception a)
               {
                   return false;
               }
            break;
           default: 
               System.out.println("Bad option: Utiles. Must be 0, 1 or 3");
               return false;
       }
       return true;
       
       
   }

    static void errNumParse(String txt) {
       String mensaje="Los campos: ";
        String[] campos = txt.split(",");
           for(int i = 0;i<campos.length;i++)
           {
               mensaje+=campos[i]+" ";
           }
           mensaje+="Deben ser numeros válidos.";
           JOptionPane.showMessageDialog(null, mensaje,"ERROR",0);
    }

    static void errCombo(String categoria) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar una "+categoria,"ERROR",0);
    }
    
    
    
}
