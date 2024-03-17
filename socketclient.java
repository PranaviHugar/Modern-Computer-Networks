import java.net.*;
import java.io.*;
public class socketclient
{
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public socketclient(String add,int port)
    {
        try
        {
            socket=new Socket(add,port);
            System.out.println("Connected");

            input=new DataInputStream(System.in);

            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException e)
        {
            System.out.println(e);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        String line="";

        while(!line.equals("Over"))
        {
            try
            {
                line=input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        socketclient client= new socketclient("localhost",8051);
    }
}