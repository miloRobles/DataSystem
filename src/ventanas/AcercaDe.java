package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controlador.ClienteControlador;
import controlador.LoginControlador;
import referencia.Clientes;
import referencia.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.List;
import java.awt.event.ActionEvent;

public class AcercaDe extends JFrame {

	private JPanel contentPane;
	private LoginControlador loginControlador;
	private Usuario usuario2;
	private String usuario = "";
	private Boolean closeDispose = Administrador.dispose ;
	private int idCliente; 
	private Clientes clientes;
	private ClienteControlador clienteControlador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe frame = new AcercaDe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AcercaDe() {
		clienteControlador = new ClienteControlador();
		clientes = new Clientes();
		
		loginControlador = new LoginControlador();
		
		//OBTIENE EL ID DEL CLIENTE
		idCliente = GestionarClientes.id;
		
		// VARIABLE QUE OBTIENE EL USERNAME (EN LA CLASE LOGIN TEXUSER);
		usuario = Login.usu;
		String nombre = obtenerNombre();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("/images/icon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 550, 300);
		setLocationRelativeTo(null);
		setTitle("Acerca de Session de - "+ nombre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema hecho con MVC");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(120, 49, 300, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1.setBounds(354, 247, 170, 14);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		
		JLabel lblCamiloMartinez = new JLabel("Camilo Martinez");
		lblCamiloMartinez.setForeground(new Color(240, 248, 255));
		lblCamiloMartinez.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamiloMartinez.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCamiloMartinez.setBounds(120, 66, 300, 20);
		contentPane.add(lblCamiloMartinez);
		
		JLabel lblDesarrolladorBackend = new JLabel("Desarrollador BackEnd");
		lblDesarrolladorBackend.setForeground(new Color(240, 248, 255));
		lblDesarrolladorBackend.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladorBackend.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesarrolladorBackend.setBounds(120, 138, 300, 20);
		contentPane.add(lblDesarrolladorBackend);
		
		JLabel lblGithubmilorobles = new JLabel("github/miloRobles");
		lblGithubmilorobles.setForeground(new Color(240, 248, 255));
		lblGithubmilorobles.setHorizontalAlignment(SwingConstants.CENTER);
		lblGithubmilorobles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGithubmilorobles.setBounds(120, 159, 300, 20);
		contentPane.add(lblGithubmilorobles);
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 534, 261);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}
	
	//OBTENEMOS EL NOMBRE PARA PASARLO AL TITULO DEL FRAME
	public String obtenerNombre() {
		
		String nombreuser = this.loginControlador.obtenerNombre(usuario);
		return nombreuser;
	}
}
