package ventanas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import controlador.EquiposControlador;
import controlador.LoginControlador;
import referencia.Estatus;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GraficarEstatus extends JFrame {

	private JPanel contentPane;
	private LoginControlador loginControlador; 
	private String nombreUsuario, usernameUsuario ;
	private int nuevoIngreso = 0, noReparado = 0, enRevision = 0, reparado = 0, entregado = 0;
	private  EquiposControlador equiposControlador;
	private Estatus estatus;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficarEstatus frame = new GraficarEstatus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GraficarEstatus() {
		
		estatus = new Estatus();
		equiposControlador = new EquiposControlador();
		loginControlador = new LoginControlador();
		usernameUsuario = Login.usu;
		nombreUsuario = obtenerNombre();
		
		
		setTitle("Gráfica de Estatus - Session de "+ nombreUsuario);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficarEstatus.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 452);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GRAFICA DE ESTATUS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(123, 11, 276, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("creado por Camilo Martinez ®");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_1.setBounds(294, 399, 252, 14);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon imagen = new ImageIcon("src/images/wallpaperPrincipal.jpg");
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 536, 413);
		lblFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblFondo);
	
			obtenerEstatus();
			repaint();
	}
	
		//TRAE EL NOMBRE DEL USUARIO DUEÑO DE LA SESIÓN PARA INGRESARLO AL TITULO DE LA VENTANA
		public String obtenerNombre() {

			String nombreuser = this.loginControlador.obtenerNombre(usernameUsuario);
			return nombreuser;
		}
		
		//TRAE LA CANTIDAD DE EQUIPOS Y LOS GUARDA EN EL VECTOR ESTATUS-NOMBRE
		public void obtenerEstatus() {
			
			estatus = this.equiposControlador.obtenerCantidadPorEstatus();
			this.nuevoIngreso = estatus.getNuevoingreso();
			this.noReparado = estatus.getNoReparado();
			this.enRevision = estatus.getEnRevision();
			this.reparado = estatus.getReparado();
			this.entregado = estatus.getEntregado();
			
		}


		public int estatusMasRepetido(int enRevision,int entregado, int noReparado, int nuevoIngreso, int reparado   ) {
			
			if(nuevoIngreso > noReparado && nuevoIngreso > enRevision && nuevoIngreso > reparado && 
					nuevoIngreso > entregado) {

				return nuevoIngreso;
			}else if(noReparado > enRevision && noReparado > reparado && noReparado > entregado ) {
				
				return noReparado;
			}else if(enRevision > reparado && enRevision > entregado ) {
				
				return enRevision;
			}else if(reparado > entregado){
				return  reparado;
			
			}else {
				
				return  entregado;
			}
			
		}



		@Override
		public void paint(Graphics g) {
			
			super.paint(g);
			
			int estatus_mas_repetido = estatusMasRepetido(this.enRevision,this.entregado,this.noReparado, this.nuevoIngreso, this.reparado);
			
			
			//TAMAÑO DE LA BARRA 
			int largo_enRevision = enRevision * 400 / estatus_mas_repetido;
			int largo_entregado = entregado * 400 / estatus_mas_repetido;
			int largo_noReparado = noReparado * 400 / estatus_mas_repetido;
			int largo_nuevoIngreso = nuevoIngreso * 400 / estatus_mas_repetido;
			int largo_reparado = reparado * 400 / estatus_mas_repetido;
			

			
			g.setColor(new Color(255,255,255)); 
			g.fillRect(100,100 , largo_enRevision, 40);
			g.drawString("En revisión", 10, 118);
			g.drawString("Cantidad " + enRevision, 10 , 133);
			
			g.setColor(new Color(0, 85, 0));
			g.fillRect(100,150 , largo_entregado, 40);
			g.drawString("Entregado", 10, 168);
			g.drawString("Cantidad " + entregado, 10, 183);
			
			g.setColor(new Color(255, 136, 0));
			g.fillRect(100,200 , largo_noReparado, 40);
			g.drawString("No reparado", 10, 218 );
			g.drawString("Cantidad " + noReparado, 10 , 233);
			
			g.setColor(new Color(240, 248, 0));
			g.fillRect(100,250 , largo_nuevoIngreso, 40);
			g.drawString("Nuevo Ingreso", 10,268 );
			g.drawString("Cantidad " + nuevoIngreso, 10 , 283);
		
			g.setColor(new Color(0,0,0));
			g.fillRect(100,300 , largo_reparado, 40);
			g.drawString("Reparado", 10, 318);
			g.drawString("Cantidad " + reparado, 10 , 333);
			
		}



}
