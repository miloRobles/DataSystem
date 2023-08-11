package ventanas;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.EquiposControlador;
import controlador.LoginControlador;
import referencia.Equipos;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.util.List;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarEquipos extends JFrame {

	private JPanel contentPane;
	private JTable tableEquipos;
	private DefaultTableModel model;
	private String usuario = "";
	private LoginControlador loginControlador;
	private EquiposControlador equiposControlador;
	private JComboBox Cboxestatus;
	protected static int idEquipos; 
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarEquipos frame = new GestionarEquipos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GestionarEquipos() {
		
		equiposControlador = new EquiposControlador(); 
		
		loginControlador = new LoginControlador();
		
		usuario = Login.usu;
		String nombre = obtenerNombre();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarClientes.class.getResource("/images/icon.png")));
		setTitle("Equipos registrados Session de - "+ nombre);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 330);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Btn_Mostrar = new JButton("Mostrar");
		Btn_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtros();
				
			}
		});
		Btn_Mostrar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		Btn_Mostrar.setBorder(null);
		Btn_Mostrar.setBounds(404, 231, 210, 35);
		contentPane.add(Btn_Mostrar);
		
		Cboxestatus = new JComboBox();
		Cboxestatus.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado"}));
		Cboxestatus.setBounds(471, 35, 143, 22);
		contentPane.add(Cboxestatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 68, 614, 162);
		contentPane.add(scrollPane);
		
		tableEquipos = new JTable();
		tableEquipos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionandoFila();
			}
		});
		tableEquipos.setShowVerticalLines(false);
		tableEquipos.setShowHorizontalLines(false);
		tableEquipos.setFillsViewportHeight(true);
		
		model = (DefaultTableModel)tableEquipos.getModel();
		
		model.addColumn("id");
		model.addColumn("Tipo");
		model.addColumn("Marca");
		model.addColumn("Estatus");
		
		
		recuperarEquipos();		
		scrollPane.setViewportView(tableEquipos);
		
		JLabel lblClientesRegistrados = new JLabel("EQUIPOS REGISTRADOS");
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
	public void recuperarEquipos() {
		
	List<Equipos>  listaEquipos = this.equiposControlador.recuperarTodoEquipos();

	for(Equipos equipos: listaEquipos) {
		 
		 model.addRow(new Object[] { equipos.getIdEquipo(), equipos.getTipoEquipo(), equipos.getMarca(), equipos.getEstatus()});
			}
	}
	
	//METODO PERMITE OBTENER EL VALOR DEL ID PARA GUARDARLO EN LA VARIABLE id  
	public void seleccionarEquipos() {
		
	      if(tableEquipos.getSelectedRow() >= 0 ) {
	        	   //TRAE EL VALOR DE LA PRIMERA COLUMNA (0) QUE ES EL ID
	        idEquipos = Integer.parseInt((tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0)).toString());
	      	       
	   
	           }
	      
	}

	//TRAE DE LA BASE DE DATOS DONDE EL ESTATUS ES = A EL SELECCIONADO EN EL JCOMBOBOX
	public void filtros() {
		
		if(Cboxestatus.getSelectedItem().equals("Todos")) {
			 model.setRowCount(0);
			recuperarEquipos();
			
		}else {
		String estatus = Cboxestatus.getSelectedItem().toString();
		
		List<Equipos>  listaNI = this.equiposControlador.filtros(estatus);
		model.setRowCount(0);

		for(Equipos equipos: listaNI) {
			 
			 model.addRow(new Object[] { equipos.getIdEquipo(), equipos.getTipoEquipo(), equipos.getMarca(), equipos.getEstatus()});
				}
		}
	}
	
	//PERMITE SELECCIONAR UNA FILA EN LA TABLA, OBTENER SU ID Y ABRE UNA VENTANA DE INFORMACION-EQUIPOS 
	//METODO PERMITE OBTENER EL VALOR DEL ID PARA GUARDARLO EN LA VARIABLE idEquipos  
	public void seleccionandoFila() {
		
	      if(tableEquipos.getSelectedRow() >= 0 ) {
	        	   //TRAE EL VALOR DE LA PRIMERA COLUMNA (0) QUE ES EL ID
	        idEquipos = Integer.parseInt((tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0)).toString());
	      	       
	       InformacionEquipoTecnico info = new InformacionEquipoTecnico();
	       info.setVisible(true);
	           }
	      
	}
}






















