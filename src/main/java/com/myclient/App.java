package com.myclient;

import server.Server;
import myinterface.Interface;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Interface.main();
        Server.start();
    }
}
