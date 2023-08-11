package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.UsuarioControlador;
import referencia.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurarPassword extends JFrame {
	private int id;
	private Usuario usuario;
	private JPanel contentPane;
	private JPasswordField textNuevoPass;
	private JPasswordField textConfirm;
	private UsuarioControlador usuarioControlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurarPassword frame = new RestaurarPassword();
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
	public RestaurarPassword() {
		usuarioControlador = new UsuarioControlador();
		
		id = GestionarUsuarios.id;
		usuario = new UsuarioControlador().traerConId(id);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RestaurarPassword.class.getResource("/images/icon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 260);
		setTitle("Cambio de password para " + usuario.getNombre());
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textConfirm = new JPasswordField();
		textConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		textConfirm.setForeground(new Color(240, 248, 255));
		textConfirm.setBackground(new Color(173, 216, 230));
		textConfirm.setBounds(20, 130, 193, 20);
		contentPane.add(textConfirm);
		
		textNuevoPass = new JPasswordField();
		textNuevoPass.setHorizontalAlignment(SwingConstants.CENTER);
		textNuevoPass.setForeground(new Color(240, 248, 255));
		textNuevoPass.setBackground(new Color(173, 216, 230));
		textNuevoPass.setBounds(20, 70, 193, 20);
		contentPane.add(textNuevoPass);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				confirmarPasswor();
			}
		});
		btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCambiar.setBounds(20, 180, 193, 23);
		contentPane.add(btnCambiar);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Confirmar Password:");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4_1.setForeground(SystemColor.menu);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_4_1.setBounds(20, 110, 160, 16);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nuevo Password:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setForeground(SystemColor.menu);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_4.setBounds(20, 50, 124, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel = new JLabel("CAMBIAR CONTRASEÑA");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(63, 11, 228, 29);
		contentPane.add(lblNewLabel);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFondo.setBounds(0, 0, 344, 221);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}
	
	public void confirmarPasswor() {
		
		String nuevoPass = textNuevoPass.getText().trim();
		String confirmacion = textConfirm.getText().trim();
		int id = this.id;
		
		if(!nuevoPass.isBlank() || !confirmacion.isBlank() ) {
		if(nuevoPass.equals(confirmacion)) {
			
			this.usuarioControlador.actualizarContrasena(nuevoPass, id);
			JOptionPane.showMessageDialog(this, "PASSWORD ACTUALIZADO CON ÉXITO!!");
			this.dispose();

		} else {
			
			JOptionPane.showMessageDialog(this, "LAS CONTRASEÑAS NO COINCIDEN");
		}
		}else {
			
			JOptionPane.showMessageDialog(this, "LOS DOS CAMPOS SON OBLIGATORIOS");
			
		}
	}
}
