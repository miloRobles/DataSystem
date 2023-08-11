package ventanas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.List;
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

public class GraficarMarcas extends JFrame {

	private JPanel contentPane;
	private LoginControlador loginControlador; 
	private String nombreUsuario, usernameUsuario ;
	private int nuevoIngreso = 0, noReparado = 0, enRevision = 0, reparado = 0, entregado = 0;
	private  EquiposControlador equiposControlador;
	private Estatus estatus;
	private int[] cantidadMarcas;
	private int  acer, alenware, hp, lenovo,dell,toshiba,brother,samsumg, apple ,asus;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficarMarcas frame = new GraficarMarcas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GraficarMarcas() {
		
		estatus = new Estatus();
		cantidadMarcas = new int[10];
		equiposControlador = new EquiposControlador();
		loginControlador = new LoginControlador();
		usernameUsuario = Login.usu;
		nombreUsuario = obtenerNombre();
		
		
		setTitle("Gráfica de Marcas - Session de "+ nombreUsuario);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficarEstatus.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 452);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GRAFICA DE MARCAS");
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
	
		marcaDeEquipos();
		
		System.out.println(acer);
		System.out.println(alenware);
		System.out.println(hp);
		System.out.println(lenovo);
		System.out.println(dell);
		System.out.println(toshiba);
		System.out.println(brother);
		System.out.println(samsumg);
		System.out.println(apple);
		System.out.println(asus);
		
			repaint();
	}
	
		//TRAE EL NOMBRE DEL USUARIO DUEÑO DE LA SESIÓN PARA INGRESARLO AL TITULO DE LA VENTANA
		public String obtenerNombre() {

			String nombreuser = this.loginControlador.obtenerNombre(usernameUsuario);
			return nombreuser;
		}
		
		
		public void marcaDeEquipos() {
			
		   cantidadMarcas = this.equiposControlador.marcaDeEquipos();
			   
			   for (int i = 0; i < cantidadMarcas.length; i++) {
		           
		            if (i == 0) {
		                acer = cantidadMarcas[i];
		            } else if (i == 1) {
		            	alenware = cantidadMarcas[i];
		            } else if (i == 2) {
		            	hp = cantidadMarcas[i];
		            } else if (i == 3) {
		            	lenovo = cantidadMarcas[i];
		            } else if (i == 4) {
		            	dell = cantidadMarcas[i];
		            } else if (i == 5) {
		            	toshiba = cantidadMarcas[i];
		            } else if (i == 6) {
		            	brother = cantidadMarcas[i];
		            } else if (i == 7) {
		            	samsumg = cantidadMarcas[i];
		            } else if (i == 8) {
		            	apple = cantidadMarcas[i];
		            } else if (i == 9) {
		            	asus = cantidadMarcas[i];
		            }
		          
		        }
			   
		   }
		

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			
			int total_marcas =  acer + alenware + hp + lenovo + dell + toshiba + brother + samsumg + apple  + asus;
			int grados_acer = acer * 360 / total_marcas;
			int grados_alenware = alenware * 360 / total_marcas;
			int grados_hp = hp * 360 / total_marcas;
			int grados_lenovo = lenovo * 360 / total_marcas;
			int grados_dell = dell * 360 / total_marcas;
			int grados_toshiba = toshiba * 360 / total_marcas;
			int grados_brother = brother * 360 / total_marcas;
			int grados_samsumg = samsumg * 360 / total_marcas;
			int grados_apple = apple * 360 / total_marcas;
			int grados_asus = asus * 360 / total_marcas;
			
			
			g.setColor(new Color(175,122,197));
			//comienza agraficar desde cero 
			g.fillArc(25, 100, 270, 270,0, grados_acer);
			g.fillRect(310, 120, 20, 20);
			g.drawString( acer+ " de Acer" , 340, 135);
			
			g.setColor(new Color(0,255,0));
			//COMIENZA A GRAFICAR DESDE GRADOS_HACER HASTA GRADOS_ALEWARE
			g.fillArc(25, 100, 270, 270,grados_acer, grados_alenware);
			g.fillRect(310, 150, 20, 20);
			g.drawString( alenware+ " de Alienware" , 340, 165);
			
			g.setColor(new Color(0,255,255));
			g.fillArc(25, 100, 270, 270,grados_acer + grados_alenware, grados_hp);
			g.fillRect(310, 180, 20, 20);
			g.drawString( hp+ " de HP" , 340, 195);
			
			g.setColor(new Color(55,0,255));
			g.fillArc(25, 100, 270, 270,grados_acer + grados_alenware + grados_hp, grados_lenovo);
			g.fillRect(310, 210, 20, 20);
			g.drawString( lenovo+ " de Lenovo" , 340, 225);
			
			g.setColor(new Color(255,255,255));
			g.fillArc(25, 100, 270, 270, grados_acer + grados_alenware + grados_hp+ grados_lenovo,grados_dell);
			g.fillRect(310, 240, 20, 20);
			g.drawString( dell+ " de Dell" , 340, 255);
			
			g.setColor(new Color(247,220,111));
			g.fillArc(25, 100, 270, 270, grados_acer + grados_alenware + grados_hp+ grados_lenovo+grados_dell, grados_toshiba);
			g.fillRect(310, 270, 20, 20);
			g.drawString( toshiba+ " de Toshiba" , 340, 285);
			
			g.setColor(new Color(21,42,160));
			g.fillArc(25, 100, 270, 270,grados_acer + grados_alenware + grados_hp+ grados_lenovo+grados_dell+
					grados_toshiba, grados_brother);
			g.fillRect(310, 300, 20, 20);
			g.drawString( brother+ " de Brother" , 340, 315);
			
			g.setColor(new Color(215,96,0));
			g.fillArc(25, 100, 270, 270,grados_acer + grados_alenware + grados_hp+ grados_lenovo+grados_dell+
					grados_toshiba+ grados_brother, grados_samsumg);
			g.fillRect(310, 330, 20, 20);
			g.drawString( samsumg+ " de Samsung" , 340, 345);
			
			g.setColor(new Color(215,96,140));
			g.fillArc(25, 100, 270, 270,grados_acer + grados_alenware + grados_hp+ grados_lenovo+grados_dell+
					grados_toshiba+ grados_brother+ grados_samsumg, grados_apple);
			g.fillRect(310, 360, 20, 20);
			g.drawString( apple+ " de Apple" , 340, 375);
			
			g.setColor(new Color(215,196,25));
			g.fillArc(25, 100, 270, 270,grados_acer + grados_alenware + grados_hp+ grados_lenovo+grados_dell+
					grados_toshiba+ grados_brother+ grados_samsumg+ grados_apple, grados_asus);
			g.fillRect(430, 120, 20, 20);
			g.drawString( asus+ " de Asus" , 460, 135);
		
			
			
			
		}
}