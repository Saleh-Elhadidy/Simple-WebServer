package toSubmit;

import java.net.*;
import java.nio.file.Files;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Client  {
	public ObjectInputStream inputStream;
	public ObjectOutputStream outputStream;		
	public Socket clientSocket;					
	public String server, username;
	public int port;		
	static  JFrame frmChatApplicationLogin;
	static  JTextField textField;
	static  JTextField textField_1;
	static JFrame frame;
	static JTextField ChatField;
	static JTextPane textPane = new JTextPane();
	static 	JButton btnNewButton;
	static	JButton btnNewButton_1;
	static	JButton btnNewButton_2;
	static	JButton btnNewButton_3;
	static	JButton btnNewButton_4;
	static	JButton btnNewButton_5;
	static	JButton btnNewButton_6;
	static	JButton btnNewButton_7;
	static	JButton btnNewButton_8;
	static	JButton btnNewButton_9;

	
	public Client(String server, int port, String username) {
		this.server = server;
		this.port = port;
		this.username = username;
		if(this.start()){		
		}else{
			return;
		}

	}


	public boolean start() {
		try {
			clientSocket = new Socket(server, port);
			ChatWindow(this);

		} 
		catch(Exception ec) {
			return false;
		}

		try
		{
			inputStream  = new ObjectInputStream(clientSocket.getInputStream());
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
		}
		catch (Exception eIO) {
			return false;
		}

		new ListenFromServer().start();
		try
		{
			outputStream.writeObject(username);
		}
		catch (IOException eIO) {
			System.exit(0);
			return false;
		}
		return true;
	}

	private void disconnect() {
		try { 
			if(inputStream != null) inputStream.close();
		}
		catch(Exception e) {}
		try {
			if(outputStream != null) outputStream.close();
		}
		catch(Exception e) {}
        try{
			if(clientSocket != null) clientSocket.close();
		}
		catch(Exception e) {}
			
	}
	public void send(HttpRequest a) {
		try {
			outputStream.writeObject(a);
		}
		catch(Exception e) {
		}
	}
	   public static void ChatWindow(Client A){
		   String Method = "GET";
		   String Version = "1.1";
		   String host = A.username;
		   String conncection = "false";
			frame = new JFrame();
			frame.setBounds(100, 100, 515, 470);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);
			
			JCheckBox chckbxCloseConnectionNext = new JCheckBox("Close Connection next object");
			chckbxCloseConnectionNext.setBounds(181, 284, 228, 23);
			frame.getContentPane().add(chckbxCloseConnectionNext);
			
			 btnNewButton = new JButton("TextFile1");
			 btnNewButton.setName("TextFile1.txt");

			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton.getName(), host, btnNewButton.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			btnNewButton.setBounds(26, 40, 89, 23);
			frame.getContentPane().add(btnNewButton);
			
			 btnNewButton_1 = new JButton("TextFile2");
			 btnNewButton_1.setName("TextFile2.txt");
		
			btnNewButton_1.setBounds(26, 108, 89, 23);
			frame.getContentPane().add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_1.getName(), host, btnNewButton_1.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			
			 btnNewButton_2 = new JButton("TextFile3");
			 btnNewButton_2.setName("TextFile3.txt");
			btnNewButton_2.setBounds(26, 171, 89, 23);
			frame.getContentPane().add(btnNewButton_2);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_2.getName(), host, btnNewButton_2.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			 btnNewButton_3 = new JButton("TextFile4");
			 btnNewButton_3.setName("TextFile4.txt");
			btnNewButton_3.setBounds(26, 232, 89, 23);
			frame.getContentPane().add(btnNewButton_3);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_3.getName(), host, btnNewButton_3.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			
			 btnNewButton_4 = new JButton("Mario Picture");
			 btnNewButton_4.setName("PNG1.png");
			btnNewButton_4.setBounds(181, 40, 89, 23);
			frame.getContentPane().add(btnNewButton_4);
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_4.getName(), host, btnNewButton_4.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
					
				}
			});
			
			btnNewButton_5 = new JButton("Groot Picture");
			 btnNewButton_5.setName("PNG2.PNG");
			btnNewButton_5.setBounds(181, 108, 89, 23);
			frame.getContentPane().add(btnNewButton_5);
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_5.getName(), host, btnNewButton_5.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
					
				}
			});
			
			 btnNewButton_6 = new JButton("Cat Picture");
			 btnNewButton_6.setName("JPEG1.JPEG");
			btnNewButton_6.setBounds(181, 171, 89, 23);
			frame.getContentPane().add(btnNewButton_6);
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_6.getName(), host, btnNewButton_6.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			
			 btnNewButton_7 = new JButton("Panda Picture");
			 btnNewButton_7.setName("JPEG2.JPEG");
			btnNewButton_7.setBounds(181, 232, 89, 23);
			frame.getContentPane().add(btnNewButton_7);
			btnNewButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_7.getName(), host, btnNewButton_7.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			
			 btnNewButton_8 = new JButton("Ceiling Video");
			 btnNewButton_8.setName("MP41.MP4");
			btnNewButton_8.setBounds(331, 40, 89, 23);
			frame.getContentPane().add(btnNewButton_8);
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_8.getName(), host, btnNewButton_8.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			
			 btnNewButton_9 = new JButton("Waterfall Video");
			 btnNewButton_9.setName("MP42.MP4");
			btnNewButton_9.setBounds(331, 108, 89, 23);
			frame.getContentPane().add(btnNewButton_9);
			btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String c = "Keep-Alive";
					if(chckbxCloseConnectionNext.isSelected()){
						 c = "Close";
					}else{
						 c = "Keep-Alive";
					}
					HttpRequest making = new HttpRequest(btnNewButton_9.getName(), host, btnNewButton_9.getName().split("\\.")[1], c);
					A.send(making);
					if(chckbxCloseConnectionNext.isSelected()){
						System.out.println("HERE");
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						btnNewButton_6.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_9.setEnabled(false);
						chckbxCloseConnectionNext.setEnabled(false);
					}
				}
			});
			
			textField = new JTextField();
			textField.setBounds(26, 314, 440, 106);
			frame.getContentPane().add(textField);
			textField.setColumns(10);

	   }


	public static void main(String[] args) {

		frmChatApplicationLogin = new JFrame();
		frmChatApplicationLogin.setVisible(true);
		frmChatApplicationLogin.setTitle("Chat Application Login");
		frmChatApplicationLogin.setBounds(100, 100, 450, 300);
		frmChatApplicationLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChatApplicationLogin.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Name:");
		lblPleaseEnterYour.setBounds(10, 45, 192, 14);
		frmChatApplicationLogin.getContentPane().add(lblPleaseEnterYour);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Your Name Here\r\n");
		textField.setBounds(10, 71, 86, 20);
		frmChatApplicationLogin.getContentPane().add(textField);
		textField.setColumns(10);
				
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name  = textField.getText();
				if(!name.equals("")){
						Client A = new Client("localhost", 6789, name);
						frmChatApplicationLogin.dispose();
				}
			}
		});
		btnLogin.setBounds(158, 190, 89, 23);
		frmChatApplicationLogin.getContentPane().add(btnLogin);
	}


	class ListenFromServer extends Thread {

		public void run() {
			String msg = "";
			HttpResponse Res;
			File f = new File(username);
			
			byte[] data;
			do {
				try {

					Object t =  inputStream.readObject();
					Res = (HttpResponse)t;

					textField.setText(Res.toString());
					Object p =(Object) Res.payload;
					data = (byte[])p;
					System.out.print("--> ");
					Desktop dt =  Desktop.getDesktop();
					Files.write(f.toPath(), data);
					dt.open(f);
					f.deleteOnExit();
					if(Res.Connection.equals("Close")){
						//clientSocket.close();
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
					break;
				}
				finally{
					System.out.println(":");
				}
			}while(true);
		}
	}
}