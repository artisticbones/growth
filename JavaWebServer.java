package cn.edu.swu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
 
public class JavaWebServer
{
 
    private static final int fNumberOfThreads = 100;
    private static final Executor fThreadPool = Executors.newFixedThreadPool(fNumberOfThreads);
 
    public static void main(String[] args) throws IOException
    {
        ServerSocket socket = new ServerSocket(81);
        while (true)
        {
            final Socket connection = socket.accept();
            HandleRequest(connection);
			/*
            Runnable task = new Runnable()
            {
                @Override
                public void run()
                {
                    HandleRequest(connection);
                }
            };
            fThreadPool.execute(task);
			*/
        }
    }
 
    private static void HandleRequest(Socket s)
    {
        BufferedReader in;
        PrintWriter out;
        String request = null;
 
        try
        {
            String webServerAddress = s.getInetAddress().toString();
            System.out.println("New Connection:" + webServerAddress);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
 
            System.out.println("--- Client request:");
			while ((request = in.readLine()) != null ) {
				System.out.print(request + "\n");
				if (request.isEmpty()) {
					break;
				}
			}

            //request = in.readLine();
			
            //System.out.println("--- Client request: " + request);
 
            out = new PrintWriter(s.getOutputStream(), true);
            out.println("HTTP/1.0 200");
            out.println("Content-type: text/html");
            out.println("Server-name: myserver");
            String response = "<html>\n"
                    + "<head>\n"
                    + "<title>My Web Server</title></head>\n"
                    + "<h1>Welcome to my Web Server!</h1>\n"
                    + "</html>\n";
            out.println("Content-length: " + response.length());
            out.println("");
            out.println(response);
            out.flush();
            out.close();
            s.close();
        }
        catch (IOException e)
        {
            System.out.println("Failed respond to client request: " + e.getMessage());
        }
        finally
        {
            if (s != null)
            {
                try
                {
                    s.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return;
    }
 
}
