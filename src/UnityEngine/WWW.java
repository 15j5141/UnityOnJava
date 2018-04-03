package UnityEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class WWW{
	
	private String url;
	private int port;
	
	WWW(String url, int port){
		this.url = url;
		this.port = port;
	}
	
	public String get() {
		String result = "";
		boolean flag = false; //split Header and contents flag

		try {
			Socket server = new Socket(url, port);
			System.out.printf("Client: connected to %s.\n", server.getInetAddress().toString());

			PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(server.getOutputStream())), true);
			writer.printf("GET /index.html HTTP/1.0\r\nHost: www.meisei-u.ac.jp\r\n\r\n", server.getLocalAddress().toString());

			BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String line;
			while((line = reader.readLine()) != null){
				System.out.printf("Server: message from client %s\n", line);
				if(line.equals("")) flag=true;
				if(flag){
					result += line;
				}
			}

			server.close();
			System.out.printf("Client: disconnected.\n");
		} catch (IOException e) {
			e.printStackTrace();
			result = "";
		}
		
		return result;
		
	}


}
