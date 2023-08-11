package ventanas;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.ClienteControlador;
import controlador.LoginControlador;
import referencia.Clientes;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.util.List;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionarClientes extends JFrame {

	private JPanel contentPane;
	private JTable tableClientes;
	private DefaultTableModel model;
	private String usuario = "";
	private LoginControlador loginControlador;
	private ClienteControlador clienteControlador;
	private InformacionClientes informacionClientes;
	protected static int id; 
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarClientes frame = new GestionarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GestionarClientes() {
		informacionClientes = new InformacionClientes();
		clienteControlador = new ClienteControlador();
		loginControlador = new LoginControlador();
		
		//OBTENER EL USERNAME 
		usuario = Login.usu;
		String nombre = obtenerNombre();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarClientes.class.getResource("/images/icon.png")));
		setTitle("Clientes registrados Session de - "+ nombre);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 330);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 68, 614, 189);
		contentPane.add(scrollPane);
		
		tableClientes = new JTable();
		tableClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionandoFila();
			}
		});
		tableClientes.setShowVerticalLines(false);
		tableClientes.setShowHorizontalLines(false);
		tableClientes.setFillsViewportHeight(true);
		
		model = (DefaultTableModel)tableClientes.getModel();
		
		model.addColumn("");
		model.addColumn("Nombre cliente");
		model.addColumn("Em@il");
		model.addColumn("Telefono");
		model.addColumn("Registrado por");
		
		recuperarCliente();
		
		scrollPane.setViewportView(tableClientes);
		
		JLabel lblClientesRegistrados = new JLabel("CLIENTES REGISTRADOS");
		lblClientesRegistrados.setForeground(new Color(240, 248, 255));
		lblClientesRegistrados.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblClientesRegistrados.setBounds(164, 11, 276, 29);
		contentPane.add(lblClientesRegistrados);
		
		JLabel lblNewLabel_1 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_1.setBounds(366, 277, 276, 14);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 614, 291);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}
	
	//TRAE EL NOMBRE DEL USUARIO lOGEADO PARA INGRESARLO AL TITULO DE LA VENTANA
	public String obtenerNombre() {

		String nombreuser = this.loginControlador.obtenerNombre(usuario);
		return nombreuser;
	}
	
	//MÉTODO PARA LLENAR LA TABLA CON VALORES OBTENIDOS DE LA BASE DE DATOS
	public void recuperarCliente() {
		
		List<Clientes> lista = this.clienteControlador.traerCliente();
		
		for(Clientes listas : lista) {
			model.addRow(new Object[] { listas.getIdCliente(), listas.getNombreCliente(), listas.getMailCliente(), listas.getTelefonoCliente(), listas.getRegistradoPor()});
		}
		
	}
	
	//PERMITE SELECCIONAR UNA FILA EN LA TABLA, OBTENER SU ID Y ABRE UNA VENTANA DE INFORMACION-CLIENTE 
	//METODO PERMITE OBTENER EL VALOR DEL ID PARA GUARDARLO EN LA VARIABLE id  
	public void seleccionandoFila() {
		
	      if(tableClientes.getSelectedRow() >= 0 ) {
	        	   //TRAE EL VALOR DE LA PRIMERA COLUMNA (0) QUE ES EL ID
	        id = Integer.parseInt((tableClientes.getValueAt(tableClientes.getSelectedRow(), 0)).toString());
	      	       
	       InformacionClientes info = new InformacionClientes();
	       info.setVisible(true);
	           }
	      
	}

}
