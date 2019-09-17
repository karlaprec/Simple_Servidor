package ejemplo1servidor;
import java.net.*;
import java.io.*;

public class Ejemplo1servidor {

   static int nsocket;
   static ServerSocket socketServer;
   static Socket socket;
   
    public static void main(String[] args){
        try{
        if(args[args.length-1]!=null){
            try {
                nsocket= Integer.parseInt(args[args.length-1]);
                  while (true) {
                  socketServer= new ServerSocket(nsocket);
                  socket= socketServer.accept();
                  BufferedReader lector= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                  String entrada;       
                   while ((entrada=lector.readLine())!=null) {
                    System.out.println("me dijeron: " + entrada);
                    }
                socket.close();
                socketServer.close();
               }
            } 
            catch (Exception e) {System.out.println("No se pudo levantar un servidor");}  
         }
        else{
            System.out.println("Falto Socket");
         }
       } 
        catch (Exception e) {System.out.println("Socket Incorrecto, Volver a intentar");}
    }
}

