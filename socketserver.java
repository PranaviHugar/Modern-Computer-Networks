import java.net.*;
import java.io.*;
public class socketserver
{
    private Socket socket=null;
    private ServerSocket server =null;
    private DataInputStream in =null;

    public socketserver(int port)
    {
        try 
        {
            server=new ServerSocket(port);
            System.out.println("server started");
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client accepted");
            in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line="";
            while(!line.equals("Over"))
            {
                try
                {
                    line=in.readUTF();
                    System.out.println(line);
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
            }
            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch (IOException e) 
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        socketserver server=new socketserver(8051);
    }
}