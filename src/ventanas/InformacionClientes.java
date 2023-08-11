package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.itextpdf.text.xml.simpleparser.NewLineHandler;

import controlador.ClienteControlador;
import controlador.EquiposControlador;
import controlador.LoginControlador;
import referencia.Clientes;
import referencia.Equipos;

import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class InformacionClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTextField textModificadoPor;
	private JTable tableEquipos;
	private DefaultTableModel model;
	private String usuario = "";
	private LoginControlador loginControlador;
	private ClienteControlador clienteControlador;
	private Clientes clientes;
	private EquiposControlador equiposControlador;
	private String nombreUsuario;
	private List<Equipos> equipos;
	private int idCliente;
	protected static int idEquipos; 

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionClientes frame = new InformacionClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InformacionClientes() {
		equipos = new ArrayList<>();
		clientes = new Clientes();
		equiposControlador = new EquiposControlador();
		clienteControlador = new ClienteControlador();
		loginControlador = new LoginControlador();

		// ID PERTENECIENTE AL CLIENTE
		idCliente = GestionarClientes.id;
		String cliente = obtenerNombreCliente();

		// USERNAME Y NOMBRE DEl DUEÑO DE LA SESIÓN ACTUAL
		usuario = Login.usu;
		nombreUsuario = obtenerNombre();

		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionClientes.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 450);
		setTitle("Informacion de " + cliente + " - Session de " + nombreUsuario);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_5 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1_5.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1_5.setBounds(424, 397, 190, 14);
		contentPane.add(lblNewLabel_1_5);

		JButton btnImprimirReporte = new JButton("");
		btnImprimirReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creandoPdf();
			}
		});
		btnImprimirReporte.setIcon(new ImageIcon(InformacionClientes.class.getResource("/images/impresora.png")));
		btnImprimirReporte.setBounds(new Rectangle(40, 70, 120, 100));
		btnImprimirReporte.setBounds(494, 250, 120, 100);
		contentPane.add(btnImprimirReporte);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 70, 374, 180);
		contentPane.add(scrollPane_1);
		tableEquipos = new JTable();
		tableEquipos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionandoFila();
			}
		});
		model = (DefaultTableModel) tableEquipos.getModel();

		model.addColumn("ID equipo");
		model.addColumn("Tipo de equipo");
		model.addColumn("Marca");
		model.addColumn("Estatus");

		informacionEquipos();
		scrollPane_1.setViewportView(tableEquipos);

		JLabel lblInformacinDelCliente = new JLabel("Información del cliente " + cliente);
		lblInformacinDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacinDelCliente.setForeground(new Color(240, 248, 255));
		lblInformacinDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblInformacinDelCliente.setBackground(new Color(0, 0, 139));
		lblInformacinDelCliente.setBounds(0, 0, 614, 29);
		contentPane.add(lblInformacinDelCliente);

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

		JLabel lblNewLabel_1_4 = new JLabel("Ultima modificación por:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBackground(new Color(0, 0, 128));
		lblNewLabel_1_4.setBounds(20, 290, 153, 14);
		contentPane.add(lblNewLabel_1_4);

		textEmail = new JTextField();
		textEmail.setText((String) null);
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setForeground(new Color(240, 248, 255));
		textEmail.setFont(new Font("Arial", Font.BOLD, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(new Rectangle(20, 70, 210, 0));
		textEmail.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textEmail.setBackground(new Color(70, 130, 180));
		textEmail.setAlignmentX(1.0f);
		textEmail.setBounds(20, 130, 210, 22);
		contentPane.add(textEmail);

		textNombre = new JTextField();
		textNombre.setText((String) null);
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setForeground(new Color(240, 248, 255));
		textNombre.setFont(new Font("Arial", Font.BOLD, 16));
		textNombre.setColumns(10);
		textNombre.setBounds(new Rectangle(20, 70, 210, 0));
		textNombre.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textNombre.setBackground(new Color(70, 130, 180));
		textNombre.setAlignmentX(1.0f);
		textNombre.setBounds(20, 70, 210, 22);
		contentPane.add(textNombre);

		textTelefono = new JTextField();
		textTelefono.setText((String) null);
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

		textDireccion = new JTextField();
		textDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		textDireccion.setForeground(new Color(240, 248, 255));
		textDireccion.setFont(new Font("Arial", Font.BOLD, 16));
		textDireccion.setColumns(10);
		textDireccion.setBounds(new Rectangle(20, 70, 210, 0));
		textDireccion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDireccion.setBackground(new Color(70, 130, 180));
		textDireccion.setAlignmentX(1.0f);
		textDireccion.setBounds(20, 250, 210, 22);
		contentPane.add(textDireccion);

		textModificadoPor = new JTextField();
		textModificadoPor.setText((String) null);
		textModificadoPor.setHorizontalAlignment(SwingConstants.CENTER);
		textModificadoPor.setForeground(new Color(240, 248, 255));
		textModificadoPor.setFont(new Font("Arial", Font.BOLD, 16));
		textModificadoPor.setEnabled(false);
		textModificadoPor.setColumns(10);
		textModificadoPor.setBounds(new Rectangle(20, 70, 210, 0));
		textModificadoPor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textModificadoPor.setBackground(new Color(70, 130, 180));
		textModificadoPor.setAlignmentX(1.0f);
		textModificadoPor.setBounds(20, 310, 210, 22);
		contentPane.add(textModificadoPor);

		JButton Btn_Registrar = new JButton("Registrar equipo");
		Btn_Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistrarEquipos().setVisible(true);
			}
		});
		Btn_Registrar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		Btn_Registrar.setBorder(null);
		Btn_Registrar.setBounds(280, 260, 210, 35);
		contentPane.add(Btn_Registrar);

		JButton Btn_Actualizar = new JButton("Actualizar cliente");
		Btn_Actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCliente();
			}
		});
		Btn_Actualizar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		Btn_Actualizar.setBorder(null);
		Btn_Actualizar.setBounds(280, 310, 210, 35);
		contentPane.add(Btn_Actualizar);

		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFondo.setBounds(0, 0, 614, 411);
		lblFondo.setIcon(new ImageIcon(
				imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);

		obtenerClientesConId();

	}

	// TRAE EL NOMBRE DEL USUARIO lOGEADO PARA INGRESARLO AL TITULO DE LA VENTANA
	// TRAE EL NOMBRE DEL USUARIO QUE INICIÓ SESIÓN PARA MOSTRARLO EN EL TITULO DE
	// LA VENTANA
	public String obtenerNombre() {

		String nombreuser = this.loginControlador.obtenerNombre(usuario);
		return nombreuser;
	}

	// ENVÍA EL VALOR DEL ID DEL CLIENTE Y OBTIENE SU NOMBRE
	// TRAE EL NOMBRE DEL CLIENTE PARA INGRESARLO A LOS TITULOS
	public String obtenerNombreCliente() {

		String nombreCliente = this.clienteControlador.obtenerNombreCliente(idCliente);
		return nombreCliente;
	}

	// OBTIENE DATOS DEL CLIENTE
	// POR MEDIO DEL ID RECUPERAMOS LA INFORMACIÓN DE LA BASE DE DATOS Y LLENAMOS
	// LOS TEXTFILED
	public void obtenerClientesConId() {

		clientes = this.clienteControlador.traerClienteConId(idCliente);

		textNombre.setText(clientes.getNombreCliente());
		textEmail.setText(clientes.getMailCliente());
		textTelefono.setText(clientes.getTelefonoCliente());
		textDireccion.setText(clientes.getDireccionCliente());
		textModificadoPor.setText(clientes.getRegistradoPor());

	}

	// OBTIENE DATOS DE LOS EQUIPOS QUE PERTENECEN A UN CLIENTE (id) Y LLENA LA
	// TABLA (tableEquipos)
	// MÉTODO PARA LLENAR LA TABLA CON VALORES OBTENIDOS DE LA BASE DE DATOS
	public void informacionEquipos() {

		equipos = this.equiposControlador.informacionEquipos(idCliente);

		for (Equipos equipo : equipos) {
			model.addRow(new Object[] { equipo.getIdEquipo(), equipo.getTipoEquipo(), equipo.getMarca(),
					equipo.getEstatus() });
		}

	}

	// ACTULIZA LA INFORMACION DE LOS CLIENTES
	// ACTUALIZACIÓN DE CLIENTES
	public void actualizarCliente() {

		if (textNombre.getText().isBlank() || textEmail.getText().isBlank() || textTelefono.getText().isBlank()
				|| textDireccion.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "TODOS LOS CAMPOS DEBEN ESTAR LLENOS");
		} else {

			int id = this.idCliente;
			String nombre = textNombre.getText();
			String email = textEmail.getText();
			String telefono = textTelefono.getText();
			String direccion = textDireccion.getText();
			String actualizadoPor = this.nombreUsuario;

			clientes = new Clientes(id, nombre, email, telefono, direccion, actualizadoPor);

			this.clienteControlador.actualizarCliente(clientes);
			JOptionPane.showMessageDialog(this, "ACTUALIZACIÓN EXITOSA!");

		}

	}

	// CREA EL REPORTE PDF
	public void creandoPdf() {

		Document documento = new Document();
		try {

			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(documento,
					new FileOutputStream(ruta + "/Desktop/" + textNombre.getText().trim() + ".pdf"));

			com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
			header.scaleToFit(650, 1000);
			header.setAlignment(Chunk.ALIGN_CENTER);

			Paragraph parrafo = new Paragraph();
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.add("informacion del cliente. \n\n");
			parrafo.setFont(FontFactory.getFont("Arial", 14, Font.BOLD, BaseColor.DARK_GRAY));

			documento.open();
			documento.add(header);
			documento.add(parrafo);

			PdfPTable tablaCliente = new PdfPTable(5);
			tablaCliente.addCell("ID");
			tablaCliente.addCell("Nombre");
			tablaCliente.addCell("Email");
			tablaCliente.addCell("Teléfono");
			tablaCliente.addCell("Dirección");

			try {

				obtenerClientesConId();

				tablaCliente.addCell(clientes.getNombreCliente());
				tablaCliente.addCell(clientes.getMailCliente());
				tablaCliente.addCell(clientes.getTelefonoCliente());
				tablaCliente.addCell(clientes.getDireccionCliente());
				tablaCliente.addCell(clientes.getRegistradoPor());

				documento.add(tablaCliente);
			} catch (Exception e) {
				System.out.println("Error al obtener datos del cliente" + e.getMessage());
			}

			Paragraph parrafo2 = new Paragraph();
			parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo2.add("\n \n Equipos registrados. \n\n");
			parrafo2.setFont(FontFactory.getFont("Arial", 14, Font.BOLD, BaseColor.DARK_GRAY));

			documento.add(parrafo2);

			PdfPTable tablaEquipos = new PdfPTable(4);
			tablaEquipos.addCell("ID_equipo");
			tablaEquipos.addCell("Tipo");
			tablaEquipos.addCell("Marca");
			tablaEquipos.addCell("Estatus");

			try {

				informacionEquipos();

				for (Equipos equipo : equipos) {

					String idEquipo = String.valueOf(equipo.getIdEquipo());

					tablaEquipos.addCell(idEquipo);
					tablaEquipos.addCell(equipo.getTipoEquipo());
					tablaEquipos.addCell(equipo.getMarca());
					tablaEquipos.addCell(equipo.getEstatus());

				}

				documento.add(tablaEquipos);

			} catch (Exception e) {
				System.out.println("Error al cargar equipos " + e.getMessage());
			}

			documento.close();
			JOptionPane.showMessageDialog(this, "Reporte creado con exito");
		} catch (DocumentException | IOException e) {

			System.err.println("Error en PDF ó ruta de imagen");
			JOptionPane.showMessageDialog(this, "Error al crear PDF contacte con e administrador");
		}

	}

	//PERMITE SELECCIONAR UNA FILA EN LA TABLA, OBTENER SU ID Y ABRE UNA VENTANA DE INFORMACION-EQUIPO 
	//METODO PERMITE OBTENER EL VALOR DEL ID EN LA TABLA PARA GUARDARLO EN LA VARIABLE idEquipos  
	public void seleccionandoFila() {
		
	      if(tableEquipos.getSelectedRow() >= 0 ) {
	        	   //TRAE EL VALOR DE LA PRIMERA COLUMNA (0) QUE ES EL ID
	        idEquipos = Integer.parseInt((tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0)).toString());
	      	       
	       InformacionEquipo info = new InformacionEquipo();
	       info.setVisible(true);
	           }
	      
	}
	
}
