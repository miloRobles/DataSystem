package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import com.itextpdf.text.List;

import controlador.ClienteControlador;
import controlador.EquiposControlador;
import controlador.LoginControlador;
import referencia.Equipos;
import referencia.Usuario;

import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InformacionEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreCliente;
	private JTextField textModelo;
	private JTextField textNSerie;
	private JTextField textUmodificacion;
	private JTextField textFecha;
	private EquiposControlador equiposControlador;
	private Equipos equiposE;
	private ClienteControlador clienteControlador;
	private String nombreCliente;
	private JComboBox Cbox_TipoEquipo,Cbox_Marcas,Cbox_Estatus;
	private JTextPane textPane_ComentariosTecnico, textPane_Observaciones ;
	private int idCliente;
	private int idEquipos;
	private LoginControlador loginControlador;
	private String nombreUsuario; 
	private String usernameUsuario;

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionEquipo frame = new InformacionEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InformacionEquipo() {
		loginControlador = new LoginControlador();
		clienteControlador = new ClienteControlador();
		equiposControlador = new EquiposControlador();
		equiposE = new Equipos();
		
		//REGRESA EL USERNAME DEL USUARIO DUEÑO DE LA SESIÓN
		usernameUsuario = Login.usu;
		nombreUsuario = obtenerNombre();
		
		
		//OBTIENE EL ID DEL EQUIPO
		idEquipos = InformacionClientes.idEquipos;
		
		// ID PERTENECIENTE AL CLIENTE
		idCliente = GestionarClientes.id;
		nombreCliente = obtenerNombreCliente();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionEquipo.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 533);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(320, 280, 330, 120);
		contentPane.add(scrollPane_1);
		
		textPane_ComentariosTecnico = new JTextPane();
		textPane_ComentariosTecnico.setEditable(false);
		scrollPane_1.setViewportView(textPane_ComentariosTecnico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 130, 330, 120);
		contentPane.add(scrollPane);
		
		textPane_Observaciones = new JTextPane();
		scrollPane.setViewportView(textPane_Observaciones);
		
		JLabel lblInformacinDeEquipo = new JLabel("Información de equipo");
		lblInformacinDeEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacinDeEquipo.setForeground(new Color(240, 248, 255));
		lblInformacinDeEquipo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblInformacinDeEquipo.setBackground(new Color(0, 0, 139));
		lblInformacinDeEquipo.setBounds(21, 0, 614, 29);
		contentPane.add(lblInformacinDeEquipo);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del cliente:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(10, 60, 135, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de equipo:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_1.setBounds(10, 120, 123, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Marca:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_2.setBounds(10, 180, 123, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Modelo:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_3.setBounds(10, 240, 123, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Número de serie:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_4.setBounds(10, 300, 128, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Fecha de ingreso:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_5.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_5.setBounds(320, 60, 154, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Ultima modificación por:");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_6.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_6.setBounds(10, 360, 179, 14);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Estatus:");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_7.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_7.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_7.setBounds(530, 60, 101, 14);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Daño reportado y observaciones");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_8.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_8.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_8.setBounds(320, 110, 226, 14);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("Comentarios y actualización del técnico:");
		lblNewLabel_1_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_9.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_9.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_9.setBounds(320, 260, 255, 14);
		contentPane.add(lblNewLabel_1_9);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setEnabled(false);
		textNombreCliente.setText((String) null);
		textNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreCliente.setForeground(new Color(240, 248, 255));
		textNombreCliente.setFont(new Font("Arial", Font.BOLD, 16));
		textNombreCliente.setColumns(10);
		textNombreCliente.setBounds(new Rectangle(20, 70, 210, 0));
		textNombreCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textNombreCliente.setBackground(new Color(70, 130, 180));
		textNombreCliente.setAlignmentX(1.0f);
		textNombreCliente.setBounds(10, 80, 210, 22);
		contentPane.add(textNombreCliente);
		
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
		
		textNSerie = new JTextField();
		textNSerie.setText((String) null);
		textNSerie.setHorizontalAlignment(SwingConstants.CENTER);
		textNSerie.setForeground(new Color(240, 248, 255));
		textNSerie.setFont(new Font("Arial", Font.BOLD, 16));
		textNSerie.setColumns(10);
		textNSerie.setBounds(new Rectangle(20, 70, 210, 0));
		textNSerie.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textNSerie.setBackground(new Color(70, 130, 180));
		textNSerie.setAlignmentX(1.0f);
		textNSerie.setBounds(10, 320, 210, 22);
		contentPane.add(textNSerie);
		
		textUmodificacion = new JTextField();
		textUmodificacion.setEnabled(false);
		textUmodificacion.setText((String) null);
		textUmodificacion.setHorizontalAlignment(SwingConstants.CENTER);
		textUmodificacion.setForeground(new Color(240, 248, 255));
		textUmodificacion.setFont(new Font("Arial", Font.BOLD, 16));
		textUmodificacion.setColumns(10);
		textUmodificacion.setBounds(new Rectangle(20, 70, 210, 0));
		textUmodificacion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textUmodificacion.setBackground(new Color(70, 130, 180));
		textUmodificacion.setAlignmentX(1.0f);
		textUmodificacion.setBounds(10, 380, 210, 22);
		contentPane.add(textUmodificacion);
		
		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setText((String) null);
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setForeground(new Color(240, 248, 255));
		textFecha.setFont(new Font("Arial", Font.BOLD, 16));
		textFecha.setColumns(10);
		textFecha.setBounds(new Rectangle(20, 70, 210, 0));
		textFecha.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFecha.setBackground(new Color(70, 130, 180));
		textFecha.setAlignmentX(1.0f);
		textFecha.setBounds(320, 80, 179, 22);
		contentPane.add(textFecha);
		
		Cbox_TipoEquipo = new JComboBox();
		Cbox_TipoEquipo.setModel(new DefaultComboBoxModel(new String[] {"Laptop", "Desktop", "Impresora", "Multifuncional"}));
		Cbox_TipoEquipo.setBounds(10, 140, 135, 22);
		contentPane.add(Cbox_TipoEquipo);
		
		Cbox_Marcas = new JComboBox();
		Cbox_Marcas.setModel(new DefaultComboBoxModel(new String[] {"Acer", "Alenware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo", "Samsumg", "Toshiba"}));
		Cbox_Marcas.setBounds(10, 200, 135, 22);
		contentPane.add(Cbox_Marcas);
		
		Cbox_Estatus = new JComboBox<>(); 
		Cbox_Estatus.setModel(new DefaultComboBoxModel(new String[] {"Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado"}));
		Cbox_Estatus.setBounds(530, 82, 111, 22);
		contentPane.add(Cbox_Estatus);
		
		JButton Btn_Actualizar = new JButton("Actualizar equipo");
		Btn_Actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarEquipo();
			}
		});
		Btn_Actualizar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		Btn_Actualizar.setBorder(null);
		Btn_Actualizar.setBounds(440, 402, 210, 35);
		contentPane.add(Btn_Actualizar);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1_5_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1_5_1.setBounds(479, 480, 190, 14);
		contentPane.add(lblNewLabel_1_5_1);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFondo.setBounds(0, 0, 656, 494);
		lblFondo.setIcon(new ImageIcon(
				imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	
	traerTodoEquipos();
	
	}
	// OBTIENE EL NOMBRE DEL CLIENTE 
	// ENVÍA EL VALOR DEL ID DEL CLIENTE Y OBTIENE SU NOMBRE
	// TRAE EL NOMBRE DEL CLIENTE 
	public String obtenerNombreCliente() {

			String nombreCliente = this.clienteControlador.obtenerNombreCliente(idCliente);
			return nombreCliente;
		}
	
	//TRAE DE LA BASE DE DATOS LA INFORMACIÓN QUE SERÁ ALMACENADA EN LOS TEXFIELD
	//TRAE LA INFORMACIÓN DE EQUIPOS Y LO ESTABLECE EN LOS TEXTFIELD
	public void traerTodoEquipos() {
	
			equiposE =  this.equiposControlador.traerTodoEquipos(this.idEquipos);
			
			String dia = equiposE.getDiaIngreso();
			String mes = equiposE.getMesIngreso();
			String annio = equiposE.getAnnioIngreso();
		
			textNombreCliente.setText(this.nombreCliente);
			Cbox_TipoEquipo.setSelectedItem(equiposE.getTipoEquipo());
			Cbox_Marcas.setSelectedItem(equiposE.getMarca());
			textModelo.setText(equiposE.getModelo());
			textNSerie.setText(equiposE.getNumSerie());
			textUmodificacion.setText(equiposE.getUltimaModificacion());
			textFecha.setText(annio + " / " + mes +" / "+ dia );
			Cbox_Estatus.setSelectedItem(equiposE.getEstatus());
			textPane_Observaciones.setText(equiposE.getObservaciones());

	
	}
	
	
	//TRAE EL NOMBRE DEL USUARIO DUEÑO DE LA SESIÓN PARA INGRESARLO AL TITULO DE LA VENTANA
	public String obtenerNombre() {

		String nombreuser = this.loginControlador.obtenerNombre(usernameUsuario);
		return nombreuser;
	}
	
	//ACTUALIZAR EQUIPOS
	public void actualizarEquipo() {
		
		if(textModelo.getText().isBlank() || textNSerie.getText().isBlank()) {
			
			JOptionPane.showMessageDialog(this, "DEBES LLENAR LOS CAMPOS ");
				
		}else {
			
				 int idEquipo = idEquipos;
				String tipoEquipo = Cbox_TipoEquipo.getSelectedItem().toString();
				String marcaEquipo = Cbox_Marcas.getSelectedItem().toString();
				String modelo = textModelo.getText();
				String nSerie = textNSerie.getText();
				String uModificacion = this.nombreUsuario;
				String fIngreso = textFecha.getText();
				String estatus = Cbox_Estatus.getSelectedItem().toString();
				String observaciones = textPane_Observaciones.getText();
				
				if(observaciones.isEmpty()) {
					textPane_Observaciones.setText("sin observaciones");
				}
				
				Equipos equipos = new Equipos(idEquipo,tipoEquipo,marcaEquipo,modelo,nSerie,observaciones,estatus,uModificacion);
		
				this.equiposControlador.actualizarEquipos(equipos);
				
				JOptionPane.showMessageDialog(this, "EQUIPO ACTUALIZADO CON ÉXITO");
		}
		
	}
}
