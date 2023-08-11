package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controlador.LoginControlador;


public class Tecnico extends JFrame {

	private JPanel contentPane;
	private LoginControlador  loginControlador;
	private int idCliente;
	private String usuario; 
	private Boolean closeDispose = Administrador.dispose ;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tecnico frame = new Tecnico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Tecnico() {
		
			loginControlador = new LoginControlador();
			
			//OBTIENE EL ID DEL CLIENTE
			idCliente = GestionarClientes.id;
			
			// VARIABLE QUE OBTIENE EL USERNAME (EN LA CLASE LOGIN TEXUSER);
			usuario = Login.usu;
			String nombre = obtenerNombre();
			
			
			setIconImage(Toolkit.getDefaultToolkit().getImage(Capturista.class.getResource("/images/icon.png")));
			setResizable(false);
			//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			cierreVentana();
			setBounds(0, 0, 550, 300);
			setLocationRelativeTo(null);
			setTitle("Técnico Session de - "+ nombre);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNombreUsuario = new JLabel("");
			lblNombreUsuario.setForeground(new Color(0, 0, 0));
			lblNombreUsuario.setFont(new Font("Arial", Font.BOLD, 20));
			lblNombreUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNombreUsuario.setInheritsPopupMenu(false);
			lblNombreUsuario.setBounds(10, 10, 46, 14);
			contentPane.add(lblNombreUsuario);
			
			JButton BtnMarcas = new JButton("");
			BtnMarcas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionarEquipos gestionarEquipos = new GestionarEquipos();
					gestionarEquipos.setVisible(true);
				}
			});
			BtnMarcas.setIcon(new ImageIcon(Tecnico.class.getResource("/images/apoyo-tecnico.png")));
			BtnMarcas.setBounds(new Rectangle(40, 70, 120, 100));
			BtnMarcas.setBounds(30, 80, 120, 100);
			contentPane.add(BtnMarcas);
			
			JButton btnGesEstatus = new JButton("");
			btnGesEstatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GraficarEstatus graficarEstatus = new GraficarEstatus();
					graficarEstatus.setVisible(true);
				}
			});
			btnGesEstatus.setIcon(new ImageIcon(Tecnico.class.getResource("/images/grafica.png")));
			btnGesEstatus.setBounds(new Rectangle(40, 70, 120, 100));
			btnGesEstatus.setBounds(204, 80, 120, 100);
			contentPane.add(btnGesEstatus);
			
			JButton btnGesEquipos = new JButton("");
			btnGesEquipos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GraficarMarcas graficarMarcas = new GraficarMarcas();
					graficarMarcas.setVisible(true);
				}
			});
			btnGesEquipos.setIcon(new ImageIcon(Tecnico.class.getResource("/images/grafica.png")));
			btnGesEquipos.setBounds(new Rectangle(40, 70, 120, 100));
			btnGesEquipos.setBounds(371, 80, 120, 100);
			contentPane.add(btnGesEquipos);
			
			JLabel lblRegistrarCliente = new JLabel("Gestión de equipo");
			lblRegistrarCliente.setBackground(new Color(173, 216, 230));
			lblRegistrarCliente.setForeground(new Color(240, 248, 255));
			lblRegistrarCliente.setBounds(30, 191, 120, 14);
			contentPane.add(lblRegistrarCliente);
			
			JLabel lblGestionarCliente = new JLabel("Gráfica de estatus");
			lblGestionarCliente.setBackground(new Color(173, 216, 230));
			lblGestionarCliente.setForeground(new Color(240, 248, 255));
			lblGestionarCliente.setBounds(204, 191, 120, 14);
			contentPane.add(lblGestionarCliente);
			
			JLabel lblImprimirCliente = new JLabel("Gráfica de marcas");
			lblImprimirCliente.setBackground(new Color(173, 216, 230));
			lblImprimirCliente.setForeground(new Color(240, 248, 255));
			lblImprimirCliente.setBounds(371, 191, 120, 14);
			contentPane.add(lblImprimirCliente);
			
			JLabel lblNewLabel_1 = new JLabel("creado por Camilo Martinez ®");
			lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
			lblNewLabel_1.setBounds(354, 247, 170, 14);
			contentPane.add(lblNewLabel_1);
			
			ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
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

		//TIPO DE CIERRE QUE VA A HACER LA VENTANA (EXIT O DISPOSE)
		public void cierreVentana() {

			try {
				if (closeDispose != null) {
					
					
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				} else {
						
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}

			catch (NullPointerException e) {
				System.out.println("Tecnico método cierreVentana");
			}
		}

	
		

	}


