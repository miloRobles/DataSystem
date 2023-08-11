package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.LoginControlador;
import controlador.UsuarioControlador;
import referencia.Usuario;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionarUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable tableUsuarios;
	private String usuario = "";
	private UsuarioControlador usuarioControlador;
	private DefaultTableModel model;
	protected static int id; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarUsuarios frame = new GestionarUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 	public GestionarUsuarios() {
		
		
         usuario = Login.usu;
		//OBTENER EL NOMBRE DEL USUARIO 
		String nombre = new LoginControlador().obtenerNombre(usuario);
		
		usuarioControlador = new UsuarioControlador();
		
		
		setTitle("Usuarios regitrados - Session de "+ nombre);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarUsuarios.class.getResource("/images/icon.png")));
		setBounds(new Rectangle(0, 0, 630, 330));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 330);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_1.setBounds(170, 266, 276, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 70, 614, 180);
		contentPane.add(scrollPane);
		
		tableUsuarios = new JTable();
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionandoFila();
			}
		});
		tableUsuarios.setShowVerticalLines(false);
		tableUsuarios.setShowHorizontalLines(false);
		tableUsuarios.setFillsViewportHeight(true);
		
		model = (DefaultTableModel)tableUsuarios.getModel();
		model.addColumn("");
		model.addColumn("Nombre");
		model.addColumn("Username");
		model.addColumn("Tipo_nivel");
		model.addColumn("Estatus");
		
		recuperarUsuario();
		
		scrollPane.setViewportView(tableUsuarios);
		
		JLabel lblNewLabel = new JLabel("USUARIOS REGISTRADOS");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(170, 10, 276, 29);
		contentPane.add(lblNewLabel);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 614, 291);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	}
	
	//MÉTODO PARA LLENAR LA TABLA CON VALORES OBTENIDOS DE LA BASE DE DATOS
	public void recuperarUsuario() {
			
		List<Usuario> lista = this.usuarioControlador.traerUsuario();
		
		for(Usuario listas : lista) {
			model.addRow(new Object[] { listas.getId(), listas.getNombre(), listas.getUsername(), listas.getRol(), listas.getActivo()});
		}
		
	}
	
	//METODO PERMITE SELECCIONAR Y OBTENER VALORES DE LA FILA 
	public void seleccionandoFila() {
		
	      if(tableUsuarios.getSelectedRow() >= 0 ) {
	        	   //TRAE EL VALOR DE LA PRIMERA COLUMNA (0) QUE ES EL ID
	        id = Integer.parseInt((tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(), 0)).toString());
	      	       
	       InformacionUsuario info = new InformacionUsuario();
	       info.setVisible(true);
	           }
	}
	
}
