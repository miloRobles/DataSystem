package ventanas;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import controlador.LoginControlador;
import referencia.UsuarioLogin;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_Logo;
	private JTextField textUser;
	private JPasswordField textPassword;
	private LoginControlador loginControlador;
	public static String usu = "";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {

		loginControlador = new LoginControlador();

		setForeground(new Color(0, 0, 0));
		setFont(new Font("Arial", Font.BOLD, 12));
		setTitle("LOGIN DATASYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 550);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setSize(new Dimension(400, 550));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		ImageIcon imagenLogo = new ImageIcon("src/images/DS.png");

		JLabel lblNewLabel = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, 497, 200, 14);
		contentPane.add(lblNewLabel);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarUsuario();
			}
		});
		btnIngresar.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnIngresar.setFont(new Font("Rockwell", Font.PLAIN, 18));
		btnIngresar.setBounds(105, 412, 152, 28);
		contentPane.add(btnIngresar);

		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		textPassword.setBackground(new Color(176, 196, 222));
		textPassword.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPassword.setForeground(new Color(248, 248, 255));
		textPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textPassword.setBounds(105, 341, 152, 28);
		contentPane.add(textPassword);

		textUser = new JTextField();
		textUser.setHorizontalAlignment(SwingConstants.CENTER);
		textUser.setFont(new Font("Arial", Font.PLAIN, 18));

		textUser.setBackground(new Color(176, 196, 222));
		textUser.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textUser.setForeground(new Color(255, 255, 255));
		textUser.setBounds(105, 282, 152, 28);
		contentPane.add(textUser);
		textUser.setColumns(10);
		lbl_Logo = new JLabel("");
		lbl_Logo.setBounds(90, 34, 200, 178);
		lbl_Logo.setIcon(new ImageIcon(imagenLogo.getImage().getScaledInstance(lbl_Logo.getWidth(),
				lbl_Logo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lbl_Logo);

		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 384, 511);
		lblFondo.setIcon(new ImageIcon(
				imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}

	// METODO PARA VALIDAR ROL DEL USUARIO

	public void verificarUsuario() {
		usu = textUser.getText().trim();
		String pas = textPassword.getText().trim();

		if (!textUser.getText().isBlank() && !textPassword.getText().isBlank()) {

			try {
				UsuarioLogin usuarioLogin = this.loginControlador.verificarUsuarioControlador(usu, pas);

				if (usuarioLogin.getEstatus().equalsIgnoreCase("Activo")
						&& usuarioLogin.getRol().equalsIgnoreCase("Administrador")) {
					dispose();
					new Administrador().setVisible(true);
				} else if (usuarioLogin.getEstatus().equalsIgnoreCase("Activo")
						&& usuarioLogin.getRol().equalsIgnoreCase("Capturista")) {
					dispose();
					new Capturista().setVisible(true);
				} else if (usuarioLogin.getEstatus().equalsIgnoreCase("Activo")
						&& usuarioLogin.getRol().equalsIgnoreCase("Tecnico")) {
					dispose();
					new Tecnico().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "usuario Inactivo");
				}

			} catch (Exception e) {

				JOptionPane.showMessageDialog(this, " DATOS DE ACCESO INCORRECTO ");
				textUser.setText("");
				textPassword.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, " DEBES LLENAR TODOS LOS CAMPOS ");
		}
	}

}
