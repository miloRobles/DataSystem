package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClienteControlador;
import controlador.LoginControlador;
import referencia.Clientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class RegistrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textMail;
	private JTextField textDireccion;
	private JTextField texttelefono;
	private String usuario = "";
	private LoginControlador loginControlador;
	private String nombre;
	private Clientes clientes;
	private ClienteControlador clienteControlador;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarClientes frame = new RegistrarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RegistrarClientes() {
		clienteControlador = new ClienteControlador();
		loginControlador = new LoginControlador();
		clientes = new Clientes();
		
		usuario = Login.usu;
		nombre = obtenerNombre();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarClientes.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(" Bienvenido  " +nombre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeClientes = new JLabel("REGISTRO DE CLIENTES");
		lblRegistroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeClientes.setForeground(new Color(240, 248, 255));
		lblRegistroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRegistroDeClientes.setBackground(new Color(0, 0, 139));
		lblRegistroDeClientes.setBounds(116, 11, 293, 29);
		contentPane.add(lblRegistroDeClientes);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(20, 50, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Em@il:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_1.setBounds(20, 110, 71, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Teléfono:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_2.setBounds(20, 170, 71, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Dirección:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_3.setBounds(20, 230, 71, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Registrar Cliente");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_4.setBounds(351, 216, 110, 20);
		contentPane.add(lblNewLabel_1_4);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(173, 216, 230));
		textNombre.setBounds(20, 70, 230, 20);
		contentPane.add(textNombre);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBackground(new Color(173, 216, 230));
		textMail.setBounds(20, 130, 230, 20);
		contentPane.add(textMail);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBackground(new Color(173, 216, 230));
		textDireccion.setBounds(20, 250, 230, 20);
		contentPane.add(textDireccion);
		
		texttelefono = new JTextField();
		texttelefono.setColumns(10);
		texttelefono.setBackground(new Color(173, 216, 230));
		texttelefono.setBounds(20, 190, 230, 20);
		contentPane.add(texttelefono);
		
		JButton btnCrear = new JButton("");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarClientes();
			}
		});
		btnCrear.setIcon(new ImageIcon(RegistrarClientes.class.getResource("/images/add.png")));
		btnCrear.setBounds(351, 100, 110, 108);
		contentPane.add(btnCrear);
		
		JLabel lblNewLabel_2 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_2.setBounds(334, 297, 170, 14);
		contentPane.add(lblNewLabel_2);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFondo.setBounds(0, 0, 514, 311);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}
	
	public String obtenerNombre() {
			String nombreuser = this.loginControlador.obtenerNombre(usuario);
			return nombreuser;
	}
	
	public void registrarClientes() {
		String nombre = textNombre.getText();
		String mail = textMail.getText();
		String telefono = texttelefono.getText();
		String direccion = textDireccion.getText();
		String nombreRegistrador = this.nombre;

		if (nombre.isBlank() || mail.isBlank() || telefono.isBlank() || direccion.isBlank()) {

			JOptionPane.showMessageDialog(this, "DEBES DILIGENCIAR TODOS LOS CAMPOS");
		} else {
			try {
				clientes = new Clientes(nombre, mail, telefono, direccion, nombreRegistrador);
				this.clienteControlador.registrarCliente(clientes);

				JOptionPane.showMessageDialog(this, "CLIENTE REGISTRADO CON ÉXITO!!");
				this.dispose();

			} catch (Exception e) {
				System.out.println("Error ventana Cliente");
			}
		}
	}
	

}
