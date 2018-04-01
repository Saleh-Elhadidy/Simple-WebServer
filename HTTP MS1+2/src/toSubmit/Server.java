package toSubmit;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;

import org.w3c.dom.html.HTMLParagraphElement;

public class Server {
	public static int connectionId;
	public ArrayList<ClientThread> clients;
	public int port;
	public boolean isRunning;
	public static volatile Queue<HttpRequest> queue = new LinkedList<HttpRequest>();
	ArrayList<HttpRequest> Try = new ArrayList<>();
	public HttpRequest msg;



	public Server(int port) {
		QueueThread handler = new QueueThread();
		handler.start();
		this.port = port;
		clients = new ArrayList<ClientThread>();
		isRunning = true;
		this.startServer();
	}

	public void startServer() {

		try 
		{
			ServerSocket serverSocket = new ServerSocket(port);
			do 
			{
				System.out.println("Server waiting for Clients on port " + port + ".");

				Socket socket = serverSocket.accept();
				ClientThread t = new ClientThread(socket);
				t.start();
				clients.add(t);
			}while(isRunning);
			try {
				serverSocket.close();
				int c = 0;
				while(c<clients.size()){
					ClientThread toClose = clients.get(c);
					try {
						toClose.inputStream.close();
						toClose.outputStream.close();
						toClose.socket.close();
						c++;
					}
					catch(Exception ioE) {
					}
				}
			}
			catch(Exception e) {
			}
		}
		catch (Exception e) {
		}
	}

	private  boolean findAndSendTo(HttpResponse res, String host) {
		
		for(int i =0;i<clients.size();i++) {
			if(clients.get(i).user.equals(host)) {
				ClientThread CT = clients.get(i);
				if(CT.sendToClient(res)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;

	}
	synchronized void logOut(int clientID) {

		int counter = 0;
		while(counter<clients.size()){
			ClientThread sendingThread = clients.get(counter);
			if(sendingThread.id == clientID) {
				clients.remove(counter);
				break;
			}
		}

	}


	public static void main(String[] args) {
		Server server = new Server(6789);
		
	}
	class QueueThread extends Thread{
		public void run() {
			while(true) {
				if(!queue.isEmpty()) {
					System.out.println("Enterd queue");
					HttpRequest toProcess = queue.poll();
					String URL = toProcess.URL;
					String HOST = toProcess.Host;
					String Format = toProcess.format;
					String Connection = toProcess.Connection;
					Object Payload = null;
					byte[] testing = null;
					File f = new File("docroot/"+URL);
					if(f.exists()) {
						String statusCode = "200";
						System.out.println("found");
							Payload = f;
							try {
								testing = Files.readAllBytes(f.toPath());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							HttpResponse res = new HttpResponse(statusCode, "1.1", new Date(), Format, Connection, testing);
							findAndSendTo(res,HOST);
								if(Connection.equals("Close")){
									for(int i=0;i<clients.size();i++){
										if(clients.get(i).user.equals(HOST)){
											clients.remove(i);
											break;
										}
									}
								}
						
					}else {
						f = null;
						String statusCode = "404";
						HttpResponse res = new HttpResponse(statusCode, "1.1", new Date(), Format, Connection, null);

						System.out.println("Not found");
					}
				}
			}
		}
	}

	class ClientThread extends Thread {
		Socket socket;
		ObjectInputStream inputStream;
		ObjectOutputStream outputStream;
		int id;
		String user;

		String recieved ="";
		Object recieve = null;
	//	public HttpRequest msg = null;
		ClientThread(Socket socket) {
			id = ++connectionId;
			this.socket = socket;
			try
			{
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				inputStream  = new ObjectInputStream(socket.getInputStream());
				user = (String) inputStream.readObject();
			}
			catch (IOException e) {
				System.out.println("Exception creating new Input/output Streams: " + e);
				return;
			}
			catch (Exception e) {
			}
		}

		public String getUser() {
			return user;
		}
		public void run() {
			boolean keepGoing = true;
			do {
				try {
					recieve = inputStream.readObject();
					msg = (HttpRequest) recieve;
					queue.add(msg);
					Try.add(msg);
				}
				catch (Exception e) {
					System.out.println(user + " Exception reading Streams: " + e);
					break;				
				}

				//System.out.println(queue.toString());

//				if(recieved.equalsIgnoreCase("LOGOUT")){
//					System.out.println(user + " disconnected with a LOGOUT message.");
//					keepGoing = false;
//					break;	
//				}
//			
//				else{
//					if((findAndSendTo(user + ": " + recieved))){	
//					}
//					else{
//						sendToClient("No user with this name or no input message sent");
//					}
//
//				}

			}while(keepGoing);
			System.out.println("HERE");
			logOut(id);
			close();
		}

		private void close() {
			try {
				if(inputStream != null) inputStream.close();
				if(outputStream != null) outputStream.close();
				if(socket != null) socket.close();
			}
			catch(Exception e) {

			}
		}

		private boolean sendToClient(HttpResponse res) {
			if(!socket.isConnected()) {
				System.exit(0);
				return false;
			}
			try {
				System.out.println("Sending");
				outputStream.writeObject(res);
			}
			catch(Exception ex) {
				System.out.println("Error sending message to " + user);
				System.out.println(ex.toString());
			}
			return true;
		}
	}
}