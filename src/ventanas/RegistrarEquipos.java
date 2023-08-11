package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import controlador.ClienteControlador;
import controlador.EquiposControlador;
import controlador.LoginControlador;
import referencia.Clientes;
import referencia.Equipos;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarEquipos extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textModelo;
	private JTextField textSerie;
	private LoginControlador loginControlador;
	private ClienteControlador clienteControlador;
	private Clientes clientes;
	private int id;
	private JComboBox Cbox_Tequipo, Cbox_Marcas ;
	private JTextPane textPane_Observaciones;
	private String usuario;
	private EquiposControlador equiposControlador;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEquipos frame = new RegistrarEquipos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RegistrarEquipos() {
		equiposControlador = new EquiposControlador();
		clienteControlador = new ClienteControlador();
		loginControlador = new LoginControlador();
		
		//USERNAME DE LA SESIÓN ACTUAL (LOGIN.USU)
		usuario = Login.usu;
		String nombre = obtenerNombre();
		
		// ID DEL CLIENTE (OBTENIDO EN LA TABLA)
		id = GestionarClientes.id ;
		String cliente = obtenerNombreCliente();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarEquipos.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 445);
		setResizable(false);
		setTitle("Registrar nuevo equipo para "+ cliente  );
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 630, 445));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 80, 314, 230);
		contentPane.add(scrollPane);
		
		textPane_Observaciones = new JTextPane();
		scrollPane.setViewportView(textPane_Observaciones);
		
		JLabel lblRegistroDeEquipo = new JLabel("Registro de equipo");
		lblRegistroDeEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEquipo.setForeground(new Color(240, 248, 255));
		lblRegistroDeEquipo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblRegistroDeEquipo.setBackground(new Color(0, 0, 139));
		lblRegistroDeEquipo.setBounds(0, 0, 614, 29);
		contentPane.add(lblRegistroDeEquipo);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre cliente:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(10, 60, 143, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de equipo:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_1.setBounds(10, 120, 106, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Marca:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_2.setBounds(10, 180, 71, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Modelo:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_3.setBounds(10, 240, 143, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Número de serie:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_4.setBounds(10, 300, 143, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Daño reportado y observaciones:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_5.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_5.setBounds(290, 60, 217, 14);
		contentPane.add(lblNewLabel_1_5);
		
		textNombre = new JTextField();
		textNombre.setText(cliente);
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setForeground(new Color(240, 248, 255));
		textNombre.setFont(new Font("Arial", Font.BOLD, 16));
		textNombre.setColumns(10);
		textNombre.setBounds(new Rectangle(20, 70, 210, 0));
		textNombre.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textNombre.setBackground(new Color(70, 130, 180));
		textNombre.setAlignmentX(1.0f);
		textNombre.setBounds(10, 80, 210, 22);
		contentPane.add(textNombre);
		
		textModelo = new JTextField();
		textModelo.setText((String) null);
		textModelo.setHorizontalAlignment(SwingConstants.CENTER);
		textModelo.setForeground(new Color(240, 248, 255));
		textModelo.setFont(new Font("Arial", Font.BOLD, 16));
		textModelo.setColumns(10);
		textModelo.setBounds(new Rectangle(20, 70, 210, 0));
		textModelo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textModelo.setBackground(new Color(70, 130, 180));
		textModelo.setAlignmentX(1.0f);
		textModelo.setBounds(10, 260, 210, 22);
		contentPane.add(textModelo);
		
		textSerie = new JTextField();
		textSerie.setText((String) null);
		textSerie.setHorizontalAlignment(SwingConstants.CENTER);
		textSerie.setForeground(new Color(240, 248, 255));
		textSerie.setFont(new Font("Arial", Font.BOLD, 16));
		textSerie.setColumns(10);
		textSerie.setBounds(new Rectangle(20, 70, 210, 0));
		textSerie.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textSerie.setBackground(new Color(70, 130, 180));
		textSerie.setAlignmentX(1.0f);
		textSerie.setBounds(10, 320, 210, 22);
		contentPane.add(textSerie);
		
		Cbox_Tequipo = new JComboBox();
		Cbox_Tequipo.setModel(new DefaultComboBoxModel(new String[] {"Laptop", "Desktop", "Impresora", "Multifuncional"}));
		Cbox_Tequipo.setBounds(10, 140, 143, 22);
		contentPane.add(Cbox_Tequipo);
		
		Cbox_Marcas = new JComboBox();
		Cbox_Marcas.setModel(new DefaultComboBoxModel(new String[] {"Acer", "Alenware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo", "Samsumg", "Toshiba"}));
		Cbox_Marcas.setBounds(10, 200, 143, 22);
		contentPane.add(Cbox_Marcas);
		
		JButton Btn_Regis = new JButton("Registrar equipo");
		Btn_Regis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resgistrarEquipos();
			}
		});
		Btn_Regis.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		Btn_Regis.setBorder(null);
		Btn_Regis.setBounds(394, 311, 210, 35);
		contentPane.add(Btn_Regis);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1_5_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1_5_1.setBounds(413, 392, 191, 14);
		contentPane.add(lblNewLabel_1_5_1);
				
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFondo.setBounds(0,0,614, 406);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}
	
	
	//TRAE EL NOMBRE DEL USUARIO QUE INICIÓ SESIÓN PARA MOSTRARLO EN EL TITULO DE LA VENTANA
	public String obtenerNombre() {

			String nombreuser = this.loginControlador.obtenerNombre(usuario);
			return nombreuser;
		}
	
	
	//TRAE EL NOMBRE DEL CLIENTE PARA INGRESARLO A LOS TITULOS 
	public String obtenerNombreCliente() {

		String nombreCliente = this.clienteControlador.obtenerNombreCliente(id);
		return nombreCliente;
	}
	
	//OBTENEMOS LOS DATOS DE LOS TEXFIELDS + EL STATUS Y LA FECHA PARA GUARDAR EN LA BASE DE DATOS
	public void resgistrarEquipos(){
		
		
		int idCliente = this.id  ;
		String tipoEquipo = Cbox_Tequipo.getSelectedItem().toString();
		String marca = Cbox_Marcas.getSelectedItem().toString();
		String modelo = textModelo.getText();
		String numeroSerie = textSerie.getText();
		String observaciones = textPane_Observaciones.getText();
		String estatus = "Nuevo Ingreso";
		//NOMBRE DE USUARIO QUE INICIÓ SESIÓN
		String ultimaModificacion = usuario ; 
		//DEJAMOS VACÍO MIENTRAS OBTENEMOS LOS COMENTARIOS DEL TÉCNICO Y EL NOMBRE DEL MISMO 
		String comentarios ="";
		String revisionDe = "";
		
		//OBTENEMOS LA FECHA ACTUAL
		Calendar calendar =  Calendar.getInstance();
		
		String diaIngreso = String.valueOf(calendar.get(Calendar.DATE));
		String mesIngreso = String.valueOf(calendar.get(Calendar.MONTH));
		String annioIngreso = String.valueOf(calendar.get(Calendar.YEAR));
		
		if( textNombre.getText().isBlank() || textModelo.getText().isBlank() || textSerie.getText().isBlank()) {
			
			JOptionPane.showMessageDialog(this, "DEBES LLENAR TODOS LOS CAMPOS");
			
		}else {
			
			if(observaciones.isBlank()) {
				observaciones = "Sin observaciones";
			}
			
		Equipos equipos = new Equipos(idCliente,tipoEquipo,marca,modelo,numeroSerie,diaIngreso,mesIngreso,annioIngreso,
				observaciones,estatus,ultimaModificacion,comentarios,revisionDe);
		
		this.equiposControlador.registrarEquipo(equipos);
		
		JOptionPane.showMessageDialog(this, "REGISTRO EXITOSO!!");
			dispose();
		}
		
	}
	
}




















