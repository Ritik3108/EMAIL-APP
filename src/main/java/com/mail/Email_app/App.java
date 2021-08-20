package com.mail.Email_app;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, il1, l41;
	public static JTextField t1;
	public static JTextField t2;
	public static JTextField t3;
	public static JTextField t4;
	JPasswordField pf;
	JButton b1, b2, b3;
	JPanel p1;
	PreparedStatement ps;
	ResultSet rs;
	static String getpass;
	String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

	App() {
		super("EMAIL");
		// setBackground(new Color(169, 169, 169));

		setSize(500, 350);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE);

		setResizable(false);
		setLayout(null);
		// setUndecorated(true);

		p1 = new JPanel();
		p1.setBounds(0, 0, 500, 450);
		setContentPane(p1);
		p1.setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/mail/Email_app/email.jpg"));
		Image im = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(im);
		il1 = new JLabel(i2);
		il1.setLayout(null);
		il1.setBounds(0, 0, 500, 350);

		p1.add(il1);

		l1 = new JLabel("TO:");
		l1.setBounds(100, 60, 100, 30);
		l1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));

		il1.add(l1);

		t1 = new JTextField();
		t1.setBounds(200, 65, 200, 20);
		t1.setFont(new Font("Tahoma", Font.BOLD, 16));
		il1.add(t1);

		l2 = new JLabel("From:");
		l2.setBounds(100, 110, 100, 30);
		l2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));

		il1.add(l2);

		l3 = new JLabel("Subject:");
		l3.setBounds(100, 160, 100, 30);
		l3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));

		il1.add(l3);

		l41 = new JLabel("Message:");
		l41.setBounds(100, 210, 100, 30);
		l41.setFont(new Font("Trebuchet MS", Font.BOLD, 16));

		il1.add(l41);

		l4 = new JLabel("EMAIL");
		l4.setBounds(200, 13, 100, 30);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		il1.add(l4);

		t2 = new JTextField();
		t2.setBounds(200, 115, 200, 20);
		t2.setForeground(Color.BLUE);
		t2.setFont(new Font("Tahoma", Font.BOLD, 16));
		// pf.setEchoChar('*');

		il1.add(t2);

		t3 = new JTextField();
		t3.setBounds(200, 165, 200, 20);
		t3.setFont(new Font("Tahoma", Font.BOLD, 16));
		il1.add(t3);

		t4 = new JTextField();
		t4.setBounds(200, 215, 200, 20);
		t4.setFont(new Font("Tahoma", Font.BOLD, 16));
		il1.add(t4);

		b3 = new JButton("SEND");
		b3.setBounds(200, 270, 100, 30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		il1.add(b3);
		b3.addActionListener(this);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (t1.getText().length() == 0 || t2.getText().length() == 0 || t3.getText().length() == 0
						|| t4.getText().length() == 0) {
					t1.setBackground(Color.RED);
					t2.setBackground(Color.BLUE);
					t3.setBackground(Color.RED);
					t4.setBackground(Color.BLUE);

					JDialog.setDefaultLookAndFeelDecorated(true);

					JOptionPane.showMessageDialog(null, "FILL ALL THE FIELDS!");
					t1.setBackground(Color.WHITE);
					t2.setBackground(Color.WHITE);
					t3.setBackground(Color.WHITE);
					t4.setBackground(Color.WHITE);

				} else {

					if (t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty()) {
						// Toast.makeText(getApplicationContext(),"enter email
						// address",Toast.LENGTH_SHORT).show();
					} else {
						if (t1.getText().toString().trim().matches(emailPattern)
								&& t2.getText().toString().trim().matches(emailPattern)) {

							JDialog.setDefaultLookAndFeelDecorated(true);

							getpass = JOptionPane.showInputDialog("Enter Your Gmail Password");
							if (getpass != null) {
								Email.send();

							}

						} else {

							JDialog.setDefaultLookAndFeelDecorated(true);

							JOptionPane.showMessageDialog(null, "Enter Valid Email Address!");
						}
					}

					// setVisible(false);

				}

			}
		});

		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				if (EVT.getKeyCode() == KeyEvent.VK_ENTER) {
					t2.requestFocus();
				} else {

				}
			}

		});

		t2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				if (EVT.getKeyCode() == KeyEvent.VK_ENTER) {
					t3.requestFocus();
				} else {

				}
			}

		});

		t3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				if (EVT.getKeyCode() == KeyEvent.VK_ENTER) {
					t4.requestFocus();
				} else {

				}
			}

		});

		t4.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				if (EVT.getKeyCode() == KeyEvent.VK_ENTER) {
					b3.requestFocus();
				} else {

				}
			}

		});

	}

	public void actionPerformed(ActionEvent ev) {
	}

	public static void main(String[] args) {

		new App().setVisible(true);
	}

	static class Email {
		public static void send() {
			System.out.println("Email Application");
			String msg = t4.getText();
			String sub = t3.getText();
			String to = t1.getText();
			String from = t2.getText();

			Email.sendMail(msg, sub, to, from);
			// Email.sendFileWithEmail(msg, sub, to, from);

		}

		public static void sendMail(String msg, String sub, String to, String from) {
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.auth", "true");

			Session session = Session.getInstance(prop, new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(t2.getText(), getpass);
				}

			});

			MimeMessage mg = new MimeMessage(session);
			try {

				mg.setFrom(from);
				mg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mg.setSubject(sub);
				mg.setText(msg);

				Transport.send(mg);

				JDialog.setDefaultLookAndFeelDecorated(true);

				JOptionPane.showMessageDialog(null, "Email Sent Successfully!.");
				// System.out.println("Email Sent Successfully!");
			} catch (Exception e) {

				JDialog.setDefaultLookAndFeelDecorated(true);

				JOptionPane.showMessageDialog(null,
						"Username and Password not accepted!   OR   Goto to your Gmail Account < Click Your Profile Picture < Manage Your Google Account < Go to the Search Bar and search 'less secure app access'");
				
				JDialog.setDefaultLookAndFeelDecorated(true);

				JOptionPane.showMessageDialog(null," < Turn the Switch ON to allow less secure apps < & then Retry ");


				// System.out.println("Username and Password not accepted!");

				e.printStackTrace();
				// TODO: handle exception
			}

		}

		public static void sendFileWithEmail(String msg, String sub, String to, String from) {
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.auth", "true");

			Session session = Session.getInstance(prop, new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(t2.getText(), getpass);
				}

			});

			MimeMessage mg = new MimeMessage(session);
			try {

				mg.setFrom(from);
				mg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mg.setSubject(sub);

				MimeMultipart mpart = new MimeMultipart();

				MimeBodyPart mbody = new MimeBodyPart();
				MimeBodyPart mtext = new MimeBodyPart();

				mtext.setText(msg);

				String path = "C:\\Users\\RITIK GARG\\Downloads\\Home.jpg";
				File f = new File(path);
				try {

					mbody.attachFile(f);
					mpart.addBodyPart(mbody);
					mpart.addBodyPart(mtext);

				} catch (Exception e) {

					e.printStackTrace();
				}

				mg.setContent(mpart);
				Transport.send(mg);

				JDialog.setDefaultLookAndFeelDecorated(true);

				JOptionPane.showMessageDialog(null, "Email Sent Successfully!.");

				// System.out.println("File Sent Successfully!..");

			} catch (Exception e) {

				JDialog.setDefaultLookAndFeelDecorated(true);

				JOptionPane.showMessageDialog(null, "Username and Password not accepted!");
				// System.out.println("Username and Password not accepted!");

				e.printStackTrace();

			}
		}
	}

}
