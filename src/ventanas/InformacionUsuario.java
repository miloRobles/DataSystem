package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controlador.LoginControlador;
import controlador.UsuarioControlador;
import referencia.Usuario;

import java.awt.Rectangle;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;

public class InformacionUsuario extends JFrame {
	private int id;
	private Usuario nombreUsuario, usuario ;

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textMail;
	private JTextField textTelefono;
	private JTextField textUsername;
	private JTextField textRegistradopor;
	private JComboBox Cbox_roles, Cbox_estatus; 
	private UsuarioControlador controlador;
	private String username;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionUsuario frame = new InformacionUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InformacionUsuario() {
		setResizable(false);
		controlador = new UsuarioControlador();
		
			//OBTENER EL NOMBRE DEL USUARIO 
		String SessionNombre  = new LoginControlador().obtenerNombre(Login.usu);
		
			//ID TRAIDO DESDE GESTIONAR USUARIOS 
		id = GestionarUsuarios.id;
		nombreUsuario = new UsuarioControlador().traerConId(id);
		
		
			setTitle("Informacion del usuario  - Session de "+ SessionNombre );
			setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuarios.class.getResource("/images/icon.png")));
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 630, 450);
			setResizable(false);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBounds(new Rectangle(0, 0, 630, 450));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton Btn_RestaurarPass = new JButton("Restaurar Password");
			Btn_RestaurarPass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				  new RestaurarPassword().setVisible(true);
				}
			});
			Btn_RestaurarPass.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
			Btn_RestaurarPass.setBorder(null);
			Btn_RestaurarPass.setBounds(380, 300, 210, 35);
			contentPane.add(Btn_RestaurarPass);
			
			JButton btnActuaUsuario = new JButton("Actualizar");
			btnActuaUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					actualizarUsuarios();
				}
			});
			btnActuaUsuario.setBorder(null);
			btnActuaUsuario.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
			btnActuaUsuario.setBounds(380, 250, 210, 35);
			contentPane.add(btnActuaUsuario);
			
			JLabel lblNewLabel_2 = new JLabel("creado por Camilo Martinez ®");
			lblNewLabel_2.setForeground(new Color(105, 105, 105));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(211, 397, 170, 14);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Username:");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_3.setForeground(new Color(240, 248, 255));
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_3.setBackground(new Color(0, 0, 128));
			lblNewLabel_1_3.setBounds(380, 50, 71, 14);
			contentPane.add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBackground(new Color(0, 0, 128));
			lblNewLabel_1.setForeground(new Color(240, 248, 255));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(20, 50, 71, 14);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel = new JLabel("Información del usuario " + nombreUsuario.getNombre());
			lblNewLabel.setForeground(new Color(240, 248, 255));
			lblNewLabel.setBackground(new Color(0, 0, 139));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblNewLabel.setBounds(0, 0, 614, 29);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1_1 = new JLabel("em@il:");
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
			
			JLabel lblNewLabel_1_4 = new JLabel("Estatus");
			lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_4.setForeground(new Color(240, 248, 255));
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_4.setBackground(new Color(0, 0, 128));
			lblNewLabel_1_4.setBounds(380, 110, 71, 14);
			contentPane.add(lblNewLabel_1_4);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Prermisos de:");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_1.setForeground(new Color(240, 248, 255));
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1_1_1.setBackground(new Color(0, 0, 128));
			lblNewLabel_1_1_1.setBounds(20, 230, 125, 14);
			contentPane.add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_3 = new JLabel("Registrado por:");
			lblNewLabel_3.setForeground(new Color(240, 248, 255));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_3.setBounds(380, 170, 125, 14);
			contentPane.add(lblNewLabel_3);
			
			textNombre = new JTextField();
			textNombre.setAlignmentX(Component.RIGHT_ALIGNMENT);
			textNombre.setBounds(new Rectangle(20, 70, 210, 0));
			textNombre.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textNombre.setHorizontalAlignment(SwingConstants.CENTER);
			textNombre.setForeground(new Color(240, 248, 255));
			textNombre.setFont(new Font("Arial", Font.BOLD, 16));
			textNombre.setBackground(new Color(70, 130, 180));
			textNombre.setBounds(20, 75, 210, 22);
			contentPane.add(textNombre);
			textNombre.setColumns(10);
			
			textMail = new JTextField();
			textMail.setHorizontalAlignment(SwingConstants.CENTER);
			textMail.setForeground(new Color(240, 248, 255));
			textMail.setFont(new Font("Arial", Font.BOLD, 16));
			textMail.setColumns(10);
			textMail.setBounds(new Rectangle(20, 70, 210, 0));
			textMail.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textMail.setBackground(new Color(70, 130, 180));
			textMail.setAlignmentX(1.0f);
			textMail.setBounds(20, 130, 210, 22);
			contentPane.add(textMail);
			
			textTelefono = new JTextField();
			textTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			textTelefono.setForeground(new Color(240, 248, 255));
			textTelefono.setFont(new Font("Arial", Font.BOLD, 16));
			textTelefono.setColumns(10);
			textTelefono.setBounds(new Rectangle(20, 70, 210, 0));
			textTelefono.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textTelefono.setBackground(new Color(70, 130, 180));
			textTelefono.setAlignmentX(1.0f);
			textTelefono.setBounds(20, 190, 210, 22);
			contentPane.add(textTelefono);
			
			textUsername = new JTextField();
			textUsername.setHorizontalAlignment(SwingConstants.CENTER);
			textUsername.setForeground(new Color(240, 248, 255));
			textUsername.setFont(new Font("Arial", Font.BOLD, 16));
			textUsername.setColumns(10);
			textUsername.setBounds(new Rectangle(20, 70, 210, 0));
			textUsername.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textUsername.setBackground(new Color(70, 130, 180));
			textUsername.setAlignmentX(1.0f);
			textUsername.setBounds(380, 70, 210, 22);
			contentPane.add(textUsername);
			
			textRegistradopor = new JTextField();
			textRegistradopor.setEnabled(false);
			textRegistradopor.setHorizontalAlignment(SwingConstants.CENTER);
			textRegistradopor.setForeground(new Color(240, 248, 255));
			textRegistradopor.setFont(new Font("Arial", Font.BOLD, 16));
			textRegistradopor.setColumns(10);
			textRegistradopor.setBounds(new Rectangle(20, 70, 210, 0));
			textRegistradopor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textRegistradopor.setBackground(new Color(70, 130, 180));
			textRegistradopor.setAlignmentX(1.0f);
			textRegistradopor.setBounds(380, 190, 210, 22);
			contentPane.add(textRegistradopor);
			
			Cbox_roles = new JComboBox();
			Cbox_roles.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Capturista", "Tecnico"}));
			Cbox_roles.setBounds(20, 250, 111, 22);
			contentPane.add(Cbox_roles);
			
			Cbox_estatus = new JComboBox();
			Cbox_estatus.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
			Cbox_estatus.setBounds(380, 130, 111, 22);
			contentPane.add(Cbox_estatus);
			JLabel lblFondo = new JLabel("");
			
			ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
			lblFondo.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblFondo.setBounds(0,0,614, 411);
			lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
			contentPane.add(lblFondo);
			
			traerUsuarios();
		}
		
	
	public void traerUsuarios() {

			usuario = new UsuarioControlador().traerConId(id);// METODO QUE TRAE TODA LA INFORMACION DEL USUARIO

			// INSERTAR LOS TEXT-FIELDS
			textNombre.setText(usuario.getNombre());
			textMail.setText(usuario.getCorreo());
			textTelefono.setText(usuario.getTelefono());
			textUsername.setText(usuario.getUsername());
			textRegistradopor.setText(usuario.getGuardadoPor());

			if (usuario.getRol().equalsIgnoreCase("administrador")) {
				Cbox_roles.setSelectedIndex(0);
			} else if (usuario.getRol().equalsIgnoreCase("Capturista")) {
				Cbox_roles.setSelectedIndex(1);

			} else {
				Cbox_roles.setSelectedIndex(2);
			}

			if (usuario.getActivo().equalsIgnoreCase("activo")) {
				Cbox_estatus.setSelectedIndex(0);
			} else {
				Cbox_estatus.setSelectedIndex(1);

			}

		}

	public void traerUsername() {
			
			username = this.controlador.traerUsername(this.id);
				System.out.println(username);
		}

	public boolean verificarUserAct() {
			
			traerUsername();

			String username = this.username;
			boolean usuarioExiste = this.controlador.verificarUsernameAct(username, id);

			if (usuarioExiste) {
				return false;
			} else {

				return true;
			}
		}

	public void actualizarUsuarios() {

			if (textNombre.getText().isBlank() || textMail.getText().isBlank() || textTelefono.getText().isBlank()
					|| textUsername.getText().isBlank()) {

				JOptionPane.showMessageDialog(this, "TODOS LOS CAMPOS DEBEN ESTAR LLENOS");
			} else {

				if (verificarUserAct()) {

					JOptionPane.showMessageDialog(this, "USERNAME YA EXISTE INTENTA OTRO");

				} else {

					int id = this.id;
					String nombreAct = textNombre.getText();
					String mailAct = textMail.getText();
					String telefonoAct = textTelefono.getText();
					String usernameAct = textUsername.getText();
					String rolAct = Cbox_roles.getSelectedItem().toString();
					String estatusAct = Cbox_estatus.getSelectedItem().toString();

					usuario = new Usuario(id, nombreAct, mailAct, telefonoAct, rolAct, usernameAct, estatusAct);

					this.controlador.actualizarUsuarios(usuario);

					JOptionPane.showMessageDialog(this, "ACTUALIZACION EXITOSA");
				}
			}

		}
	}