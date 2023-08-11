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

public class Capturista extends JFrame {

	private JPanel contentPane;
	private LoginControlador loginControlador;
	private String usuario = "";
	private Boolean closeDispose = Administrador.dispose ;
	private int idCliente; 
	private Clientes clientes;
	private ClienteControlador clienteControlador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Capturista frame = new Capturista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Capturista() {
		clienteControlador = new ClienteControlador();
		clientes = new Clientes();
		
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
		setTitle("Capturista Session de - "+ nombre);
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
		
		JButton btnRegistrarCliente = new JButton("");
		btnRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistrarClientes().setVisible(true);
			}
		});
		btnRegistrarCliente.setIcon(new ImageIcon(Capturista.class.getResource("/images/add.png")));
		btnRegistrarCliente.setBounds(new Rectangle(40, 70, 120, 100));
		btnRegistrarCliente.setBounds(30, 80, 120, 100);
		contentPane.add(btnRegistrarCliente);
		
		JButton btnGestionarClientes = new JButton("");
		btnGestionarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionarClientes().setVisible(true);
			}
		});
		btnGestionarClientes.setIcon(new ImageIcon(Capturista.class.getResource("/images/informationuser.png")));
		btnGestionarClientes.setBounds(new Rectangle(40, 70, 120, 100));
		btnGestionarClientes.setBounds(204, 80, 120, 100);
		contentPane.add(btnGestionarClientes);
		
		JButton btnImprimir = new JButton("");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearPdf();			}
		});
		btnImprimir.setIcon(new ImageIcon(Capturista.class.getResource("/images/impresora.png")));
		btnImprimir.setBounds(new Rectangle(40, 70, 120, 100));
		btnImprimir.setBounds(371, 80, 120, 100);
		contentPane.add(btnImprimir);
		
		JLabel lblRegistrarCliente = new JLabel("Registrar Clientes");
		lblRegistrarCliente.setBackground(new Color(173, 216, 230));
		lblRegistrarCliente.setForeground(new Color(240, 248, 255));
		lblRegistrarCliente.setBounds(30, 191, 120, 14);
		contentPane.add(lblRegistrarCliente);
		
		JLabel lblGestionarCliente = new JLabel("Gestionar Clientes");
		lblGestionarCliente.setBackground(new Color(173, 216, 230));
		lblGestionarCliente.setForeground(new Color(240, 248, 255));
		lblGestionarCliente.setBounds(204, 191, 120, 14);
		contentPane.add(lblGestionarCliente);
		
		JLabel lblImprimirCliente = new JLabel("Imprimir Clientes");
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
	
	//TRALE LA LISTA DE CLIENTES
	public void traerTodoClientes() {
		
	    List<Clientes> clientesTraidos = this.clienteControlador.traerCliente();
	       
	      for(Clientes cliente : clientesTraidos) {
	    	  
	    	  clientes.setIdCliente(cliente.getIdCliente());
	    	  clientes.setNombreCliente(cliente.getNombreCliente());
	    	  clientes.setMailCliente(cliente.getMailCliente());
	    	  clientes.setTelefonoCliente(cliente.getTelefonoCliente());
	    	  clientes.setDireccionCliente(cliente.getDireccionCliente());
	    	   	  
	      }
	} 

	//TIPO DE CIERRE QUE VA A HACER LA VENTANA (EXIT O DISPOSE)
	public void cierreVentana() {

		try {
			if (closeDispose != null) {
				
				System.out.println(" closeDispose es verdadero");	
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			} else {
				System.out.println(" closeDispose es falso");	
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}

		catch (NullPointerException e) {
			System.out.println("lanza exception");
		}
	}

	//CREA EL PDF DE LOS CLIENTES 
	public void crearPdf() {
		
		Document documento = new Document();
	try {
		
		String ruta = System.getProperty("user.home");
		PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/listaClientes.pdf")) ;
		
		com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
		header.scaleToFit(650,1000);
		header.setAlignment(Chunk.ALIGN_CENTER);
		
		
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		parrafo.add("Lista de clientes. \n\n ");
		parrafo.setFont(FontFactory.getFont("arial", 15, Font.BOLD, BaseColor.DARK_GRAY ));
		
		documento.open();
		documento.add(header);
		documento.add(parrafo);
		
		
		PdfPTable tabla = new PdfPTable(5);
		
		tabla.addCell("ID");
		tabla.addCell("NOMBRE");
		tabla.addCell("EMAIL");
		tabla.addCell("TELEFONO");
		tabla.addCell("DIRECCION");
		
		
		try {
			
			traerTodoClientes();
			String id = String.valueOf(clientes.getIdCliente());
			
			tabla.addCell(id);
			tabla.addCell(clientes.getNombreCliente());
			tabla.addCell(clientes.getMailCliente());
			tabla.addCell(clientes.getTelefonoCliente());
			tabla.addCell(clientes.getDireccionCliente());
			

			documento.add(tabla);
			
			
		} catch (Exception e) {
			System.out.println("Error en lista de clientes");
		}
		
		documento.close();
		
		JOptionPane.showMessageDialog(null, "Lista creada con éxito");
	} catch (Exception e) {
		System.out.println("Error al crear el documneto");
	}
		
		
	}

}
