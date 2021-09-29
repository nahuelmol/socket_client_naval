package server;

import java.io.*;  
import java.net.*; 
import myinterface.Interface;
import java.util.Date;

import java.util.Iterator;
import java.util.ArrayList;

public class Server {
	public static Console cnsl;

    public static double get_value(int x){
        double result = 0.0;
        for(int i=0;Interface.elem.coordinates.size()>i;i++){
            if(i==x){
                result = Interface.elem.coordinates.get(i);
                break;
            }
        }
        return result;
    }

	public static void init(){
        String name;
        String l_name;
        String age;

        String stringOBJ;
        String final_obj;
        String coordinatesOBJ;
        
        DataOutputStream dout;
        Socket s;

        try{
            s   =  new Socket("localhost",3333);  
                
            dout    = new DataOutputStream(s.getOutputStream());

            stringOBJ = "{\"name\" :\"Silvio\",\"lastname\":\"Molina\",\"age\":\"23\"}";

            double first = get_value(0);
            double secon = get_value(1);

            coordinatesOBJ = "{\"x\":\""+first+"\",\"y\":\""+secon+"\"}";

            final_obj = "{\"user\":"+ stringOBJ   + 
                        ",\"example\":\"content\",\"coordinates\":"+coordinatesOBJ +"}";
            System.out.println(final_obj);
                        
            dout.writeUTF(final_obj);  
            dout.flush();
            dout.close();
        }catch(Exception e){
            System.out.println("Error in while loop: "+e);
        }
    }

	public static void start(){
		try{      
            cnsl = System.console();
            if(cnsl == null){
                System.out.println("There is not console available\n");
            }else{
                while(true){
                    init();                                
                }
            }
		}catch(Exception e){
            System.out.println("Error: "+e);
        }
	}
}