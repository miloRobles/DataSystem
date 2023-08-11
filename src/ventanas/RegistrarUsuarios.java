package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import controlador.UsuarioControlador;
import referencia.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;
import java.awt.event.ActionEvent;

public class RegistrarUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTextField textUsername;
	private JTextField textPass;
	private JComboBox box_rol;
	private Usuario usuario;
	private UsuarioControlador usuarioControlador;
	private LoginControlador loginControlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuarios frame = new RegistrarUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarUsuarios() {
				
		usuarioControlador =new UsuarioControlador();
		loginControlador = new LoginControlador();
		
		 String SessionNombre  = this.loginControlador.obtenerNombre(Login.usu);
		
		setTitle("Registro de usuarios - Session de "+ SessionNombre );
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuarios.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Prermisos de:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_1_1.setBounds(20, 183, 125, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_4.setBounds(351, 95, 71, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Teléfono:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_2.setBounds(20, 139, 71, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("em@il:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_1.setBounds(20, 95, 71, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE USUARIOS");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBackground(new Color(0, 0, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(154, 0, 293, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 51, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_3.setBounds(351, 51, 71, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_2.setForeground(new Color(105, 105, 105));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(208, 297, 170, 14);
		contentPane.add(lblNewLabel_2);
		
		box_rol = new JComboBox();
		box_rol.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Capturista", "Tecnico"}));
		box_rol.setSelectedIndex(0);
		box_rol.setBounds(20, 202, 141, 20);
		contentPane.add(box_rol);
		
		JButton btnCrear = new JButton("");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				agregarUsuario();
			}
		});
		btnCrear.setIcon(new ImageIcon(RegistrarUsuarios.class.getResource("/images/add.png")));
		btnCrear.setBounds(413, 158, 110, 108);
		contentPane.add(btnCrear);
		
		textPass = new JTextField();
		textPass.setBackground(new Color(173, 216, 230));
		textPass.setColumns(10);
		textPass.setBounds(351, 114, 230, 20);
		contentPane.add(textPass);
		
		textUsername = new JTextField();
		textUsername.setBackground(new Color(173, 216, 230));
		textUsername.setColumns(10);
		textUsername.setBounds(351, 70, 230, 20);
		contentPane.add(textUsername);
		
		textTelefono = new JTextField();
		textTelefono.setBackground(new Color(173, 216, 230));
		textTelefono.setColumns(10);
		textTelefono.setBounds(20, 158, 230, 20);
		contentPane.add(textTelefono);
		
		textEmail = new JTextField();
		textEmail.setBackground(new Color(173, 216, 230));
		textEmail.setColumns(10);
		textEmail.setBounds(20, 114, 230, 20);
		contentPane.add(textEmail);
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(173, 216, 230));
		textNombre.setBounds(20, 70, 230, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFondo.setBounds(0, 0, 614, 311);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}
	
		public void agregarUsuario() {
			
			if(!textNombre.getText().isBlank() && !textEmail.getText().isBlank() && !textTelefono.getText().isBlank() && !textUsername.getText().isBlank() && !textPass.getText().isBlank()) {
				
				String nombre = textNombre.getText();
				String email = textEmail.getText();
				String telefono = textTelefono.getText();
				String rol = box_rol.getSelectedItem().toString();
				String user = textUsername.getText();
				String pass = textPass.getText();
				String activo = "activo";
				
				//OBTENEMOS EL NOMBRE DE LA PERSONA QUE REALIZA EL REGISTRO 
				String creado =    Login.usu;
				String registradoPor = this.loginControlador.obtenerNombre(creado);
				
				//VERIFICAR SI EL USUARIO EXISTE 
				Boolean existe = this.usuarioControlador.verificacionUser(user);
				
				if(existe){
					
					JOptionPane.showMessageDialog(this, "NOMBRE DE USUARIO NO DISPONIBLE 😔 ");
				}else{
					
					usuario = new Usuario(nombre,email,telefono, rol, user,pass,activo ,registradoPor );
					
					this.usuarioControlador.agregarUsuarioC(usuario);
					
					JOptionPane.showMessageDialog(this, "USUARIO REGISTRADO CON EXITO !");
					
					textNombre.setText("");
					textEmail.setText("");
					textTelefono.setText("");
					textUsername.setText("");
					textPass.setText("");
					
					
				}
				
			}else {
			
			JOptionPane.showMessageDialog(this, " TODOS LOS CAMPOS DEBEN ESTAR LLENOS ⚠");
			}
		}
	
}
