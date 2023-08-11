package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.LoginControlador;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrador extends JFrame {

	private JPanel contentPane;
	private LoginControlador loginControlador;
	private String usuario = "";
	private Capturista capturista;
	public static Boolean dispose;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Administrador() {

		dispose = true;

		capturista = new Capturista();
		loginControlador = new LoginControlador();
		usuario = Login.usu;

		String nombre = obtenerNombre();

		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 430);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Administrador - Session de " + nombre);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblNewLabel_1 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setBounds(444, 377, 190, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblAcercaDe = new JLabel("Acerca de");
		lblAcercaDe.setForeground(new Color(240, 248, 255));
		lblAcercaDe.setBounds(451, 324, 120, 14);
		contentPane.add(lblAcercaDe);

		JLabel lblCreatividad = new JLabel("Creatividad");
		lblCreatividad.setForeground(new Color(240, 248, 255));
		lblCreatividad.setBounds(451, 168, 120, 14);
		contentPane.add(lblCreatividad);

		JLabel lblGestionarUsuarios = new JLabel("Gestionar Usuarios");
		lblGestionarUsuarios.setForeground(new Color(240, 248, 255));
		lblGestionarUsuarios.setBounds(254, 168, 120, 14);
		contentPane.add(lblGestionarUsuarios);

		JLabel lblPanelTecnico = new JLabel("Panel técnico");
		lblPanelTecnico.setForeground(new Color(240, 248, 255));
		lblPanelTecnico.setBounds(254, 324, 120, 14);
		contentPane.add(lblPanelTecnico);

		JLabel lblPanelCapturista = new JLabel("Panel Capturista");
		lblPanelCapturista.setForeground(new Color(240, 248, 255));
		lblPanelCapturista.setBounds(57, 324, 120, 14);
		contentPane.add(lblPanelCapturista);

		JLabel lblNewLabel = new JLabel("Registrar Usuario");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(57, 168, 120, 14);
		contentPane.add(lblNewLabel);

		JButton btnGestionarUsuario = new JButton("");
		btnGestionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new GestionarUsuarios().setVisible(true);
			}
		});
		btnGestionarUsuario.setIcon(new ImageIcon(Administrador.class.getResource("/images/informationuser.png")));
		btnGestionarUsuario.setBounds(new Rectangle(40, 70, 120, 100));
		btnGestionarUsuario.setBounds(254, 57, 120, 100);
		contentPane.add(btnGestionarUsuario);

		JButton btnCapturista = new JButton("");
		btnCapturista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capturista.setVisible(true);
			}
		});
		btnCapturista.setIcon(new ImageIcon(Administrador.class.getResource("/images/capturista.png")));
		btnCapturista.setBounds(new Rectangle(40, 70, 120, 100));
		btnCapturista.setBounds(57, 213, 120, 100);
		contentPane.add(btnCapturista);

		JButton btnTecnico = new JButton("");
		btnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tecnico tecnico = new Tecnico();
				tecnico.setVisible(true);
			}
		});
		btnTecnico.setIcon(new ImageIcon(Administrador.class.getResource("/images/tecnico.png")));
		btnTecnico.setBounds(new Rectangle(40, 70, 120, 100));
		btnTecnico.setBounds(254, 213, 120, 100);
		contentPane.add(btnTecnico);

		JButton btnAcerca_de = new JButton("");
		btnAcerca_de.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);

			}
		});
		ImageIcon imagen1 = new ImageIcon("src/images/acerca.jpg");
		btnAcerca_de.setBounds(new Rectangle(40, 70, 120, 100));
		btnAcerca_de.setBounds(451, 213, 120, 100);
		btnAcerca_de.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(btnAcerca_de.getWidth(),
				btnAcerca_de.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(btnAcerca_de);

		JButton btnCreatividad = new JButton("");
		btnCreatividad.setIcon(new ImageIcon(Administrador.class.getResource("/images/creatividad.png")));
		btnCreatividad.setBounds(new Rectangle(40, 70, 120, 100));
		btnCreatividad.setBounds(451, 57, 120, 100);
		contentPane.add(btnCreatividad);

		JButton btnRegistrarUsuario = new JButton("");
		btnRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new RegistrarUsuarios().setVisible(true);
				;
			}
		});
		btnRegistrarUsuario.setIcon(new ImageIcon(Administrador.class.getResource("/images/addUser.png")));
		btnRegistrarUsuario.setBounds(new Rectangle(40, 70, 120, 100));
		btnRegistrarUsuario.setBounds(57, 57, 120, 100);
		contentPane.add(btnRegistrarUsuario);

		JLabel lblNomnbre_usuario = new JLabel();
		lblNomnbre_usuario.setText("hola " + nombre);
		lblNomnbre_usuario.setFont(new Font("Arial", Font.BOLD, 20));
		lblNomnbre_usuario.setForeground(new Color(240, 255, 240));
		lblNomnbre_usuario.setBounds(10, 11, 190, 22);
		contentPane.add(lblNomnbre_usuario);

		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 634, 391);
		lblFondo.setIcon(new ImageIcon(
				imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}

	// TRAE EL NOMBRE DEL USUARIO lOGEADO PARA INGRESARLO AL TITULO DE LA VENTANA
	public String obtenerNombre() {

		String nombreuser = this.loginControlador.obtenerNombre(usuario);
		return nombreuser;
	}
}
