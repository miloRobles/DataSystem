package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import referencia.Equipos;
import referencia.Estatus;



public class EquiposDao {

	Connection con;

	public EquiposDao(Connection con) {
		this.con = con;
	}

	public void registrarEquipo(Equipos equipos) {

		try {
			String consulta = "INSERT INTO equipos (id_cliente,tipo_equipo,marca,modelo,num_serie,dia_ingreso,mes_ingreso,annio_ingreso,observaciones,estatus,ultima_modificacion,"
					+ "comentarios_tecnicos,revision_tecnica_de )VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement pstm = con.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS)) {
				pstm.setInt(1, equipos.getIdCliente());
				pstm.setString(2, equipos.getTipoEquipo());
				pstm.setString(3, equipos.getMarca());
				pstm.setString(4, equipos.getModelo());
				pstm.setString(5, equipos.getNumSerie());
				pstm.setString(6, equipos.getDiaIngreso());
				pstm.setString(7, equipos.getMesIngreso());
				pstm.setString(8, equipos.getAnnioIngreso());
				pstm.setString(9, equipos.getObservaciones());
				pstm.setString(10, equipos.getEstatus());
				pstm.setString(11, equipos.getUltimaModificacion());
				pstm.setString(12, equipos.getComentarios());
				pstm.setString(13, equipos.getRevisionDe());
				pstm.executeUpdate();
			}

		} catch (Exception e) {

			System.out.println("Error en la consulta " + e.getMessage());
		}

	}

	public List<Equipos> informacionEquipos(int id) {

		List<Equipos> equipos = new ArrayList<>();

		try {
			String consulta = "SELECT id, tipo_equipo , marca, estatus FROM equipos WHERE id_cliente = ?";
			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setInt(1, id);
				try (ResultSet rst = pstm.executeQuery()) {
					while (rst.next()) {

						Equipos equipos2 = new Equipos();
						equipos2.setIdEquipo(rst.getInt(id));
						equipos2.setTipoEquipo(rst.getString("tipo_equipo"));
						equipos2.setMarca(rst.getString("marca"));
						equipos2.setEstatus(rst.getString("estatus"));

						equipos.add(equipos2);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta 'Equipos'" + e.getMessage());
		}
		return equipos;
	}

	public Equipos traerTodoEquipos(int idEquipos) {
		
		Equipos equipos = new Equipos();
		try {
			String consulta = "SELECT * FROM equipos WHERE id = ?";
			try(PreparedStatement pstm = con.prepareStatement(consulta)){
					pstm.setInt(1, idEquipos);
					
					try(ResultSet rst = pstm.executeQuery()){

						while(rst.next()) {
							
							
						equipos.setIdCliente(rst.getInt("id_cliente"));
						equipos.setTipoEquipo(rst.getString("tipo_equipo")); 
						equipos.setMarca(rst.getString("marca")); 
						equipos.setModelo(rst.getString("modelo")); 
						equipos.setNumSerie(rst.getString("num_serie")); 
						equipos.setDiaIngreso(rst.getString("dia_ingreso")); 
						equipos.setMesIngreso(rst.getString("mes_ingreso")); 
						equipos.setAnnioIngreso(rst.getString("annio_ingreso")); 
						equipos.setObservaciones(rst.getString("observaciones")); 
						equipos.setEstatus(rst.getString("estatus")); 
						equipos.setUltimaModificacion(rst.getString("ultima_modificacion")); 
						equipos.setComentarios(rst.getString("comentarios_tecnicos"));
						equipos.setRevisionDe(rst.getString("revision_tecnica_de"));
						
						return equipos;
						}
					}
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en la consulta traerTodoEquipos"+e.getMessage());
		}
		return equipos;
	}

	public void actualizarEquipos(Equipos equipos) {
			
		try {
			String consulta = "UPDATE equipos SET tipo_equipo = ?, marca=?, modelo=?,num_serie=?, observaciones=?,estatus=?,ultima_modificacion =? WHERE id = ? ";
			
			try(PreparedStatement pstm = con.prepareStatement(consulta)){
				pstm.setString(1, equipos.getTipoEquipo());
				pstm.setString(2, equipos.getMarca());
				pstm.setString(3, equipos.getModelo());
				pstm.setString(4, equipos.getNumSerie());
				pstm.setString(5, equipos.getObservaciones());
				pstm.setString(6, equipos.getEstatus());
				pstm.setString(7,equipos.getUltimaModificacion());
				pstm.setInt(8, equipos.getIdEquipo());
				
				pstm.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta "+e.getMessage());
		}
		
	}
	
	public List<Equipos> recuperTodoEquipos() {
		
		List<Equipos> ListaEquipos = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM equipos";
			try(PreparedStatement pstm = con.prepareStatement(consulta)){
					
					
					try(ResultSet rst = pstm.executeQuery()){

						while(rst.next()) {
							
						Equipos equipos = new Equipos();	
						equipos.setIdEquipo(rst.getInt("id"));	
						equipos.setIdCliente(rst.getInt("id_cliente"));
						equipos.setTipoEquipo(rst.getString("tipo_equipo")); 
						equipos.setMarca(rst.getString("marca")); 
						equipos.setModelo(rst.getString("modelo")); 
						equipos.setNumSerie(rst.getString("num_serie")); 
						equipos.setDiaIngreso(rst.getString("dia_ingreso")); 
						equipos.setMesIngreso(rst.getString("mes_ingreso")); 
						equipos.setAnnioIngreso(rst.getString("annio_ingreso")); 
						equipos.setObservaciones(rst.getString("observaciones")); 
						equipos.setEstatus(rst.getString("estatus")); 
						equipos.setUltimaModificacion(rst.getString("ultima_modificacion")); 
						equipos.setComentarios(rst.getString("comentarios_tecnicos"));
						equipos.setRevisionDe(rst.getString("revision_tecnica_de"));
						
						ListaEquipos.add(equipos);
						}
					}
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en la consulta recuperarTodoEquipos"+e.getMessage());
		}
		return ListaEquipos;
	}

	public List<Equipos> filtros(String estatus) {
	
			List<Equipos> ListaNI = new ArrayList<>();
			try {
				String consulta = "SELECT id , tipo_equipo, marca, estatus FROM equipos WHERE estatus = ?";
				try(PreparedStatement pstm = con.prepareStatement(consulta)){
						pstm.setString(1, estatus);
						
						try(ResultSet rst = pstm.executeQuery()){

							while(rst.next()) {
								
							Equipos equipos = new Equipos();	
							
							equipos.setIdEquipo(rst.getInt("id"));	
							equipos.setTipoEquipo(rst.getString("tipo_equipo")); 
							equipos.setMarca(rst.getString("marca")); 
							equipos.setEstatus(rst.getString("estatus")); 

							ListaNI.add(equipos);
							}
						}
				}
			} catch (Exception e) {
				System.out.println("Error en la consulta recuperarTodoEquipos"+e.getMessage());
			}
			return ListaNI;
		}

	
	public void actualizarEquiposTecnico(Equipos equipos) {
		try {
			String consulta = "UPDATE equipos SET estatus = ?, comentarios_tecnicos = ?, revision_tecnica_de = ? WHERE id = ?";
			try(PreparedStatement pstm = con.prepareStatement(consulta)){
				pstm.setString(1, equipos.getEstatus());
				pstm.setString(2, equipos.getComentarios());
				pstm.setString(3, equipos.getRevisionDe());
				pstm.setInt(4, equipos.getIdEquipo());
				pstm.executeUpdate();
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en la consulta ActualizarEquiposTecnico"+e.getMessage());
		}
	}

	
	public String[] obtenerEstatus() {
	        String[] estatusArray = new String[5];
	        
	        try {
	            String consulta = "SELECT estatus, COUNT(estatus) as Cantidad FROM equipos GROUP BY estatus";
	            
	            try (PreparedStatement pstm = con.prepareStatement(consulta)) {
	                try (ResultSet rst = pstm.executeQuery()) {
	                    int index = 0;
	                    while (rst.next() && index < estatusArray.length) {
	                        estatusArray[index] = rst.getString("estatus");
	                        index++;
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return estatusArray;
	    }

	public Estatus obtenerCantidadPorEstatus() {
	    	
	    	Estatus estatus = new Estatus();
	    	String[] estatusArray = new String [5];
	    	int[] cuentaArray = new int[5];
	    	int enRevision = 0, entregado = 0,noReparado = 0,nuevoingreso = 0,reparado = 0;
	        try {
	            String consulta = "SELECT estatus, COUNT(estatus) as Cantidad FROM equipos GROUP BY estatus";
	            
	            try(PreparedStatement pstm = con.prepareStatement(consulta)) {
	                try (ResultSet rst = pstm.executeQuery()) {
	                  
	                	if(rst.next()) {
	                	int index = 0;
	                    do {
	                    	cuentaArray[index] = rst.getInt(2);
	                    	estatusArray[index] = rst.getString(1);
	                     	
	                    	
	                    	if(estatusArray[index].equalsIgnoreCase("En revision")) {
	                    		enRevision = cuentaArray[index];
	                    	}else if(estatusArray[index].equalsIgnoreCase("Entregado")) {
	                    		entregado = cuentaArray[index];
	                    	}else if(estatusArray[index].equalsIgnoreCase("No reparado")) {
	                    		noReparado = cuentaArray[index];
	                    	}else if(estatusArray[index].equalsIgnoreCase("Nuevo Ingreso")) {
	                    		nuevoingreso = cuentaArray[index];
	                    	}else if(estatusArray[index].equalsIgnoreCase("Reparado")) {
	                    		reparado =  cuentaArray[index];;
	                    	}
	                    	
	           
	                    	index++;
	                    }while (rst.next()) ;
	                    	 
	                    }
	                    
	                }
	            }
	        } catch (SQLException e) {
	           System.out.println("Error en la consulta Obtener Cantidad Equipos" + e.getMessage());
	        }
	      
	        estatus = new Estatus();
	        estatus.setEnRevision(enRevision);
	        estatus.setEntregado(entregado);
	        estatus.setNoReparado(noReparado);
	        estatus.setNuevoingreso(nuevoingreso);
	        estatus.setReparado(reparado);
	        return estatus;
	    }

	public int[] marcaDeEquipos() {
		int acer = 0, alenware = 0, hp = 0, lenovo = 0,dell = 0,toshiba = 0,brother = 0,samsumg = 0, apple = 0,asus = 0;
		int[] cantidadMarcas = new int[10];
		int[] listaRetorno = new int[10];
 		String[] listaMarcas = new String[10];
		
		try {
			String consulta = "SELECT marca, count(marca) as Marcas FROM equipos GROUP BY marca ";
			
			try(PreparedStatement pstm = con.prepareStatement(consulta)){
				
				try(ResultSet rst= pstm.executeQuery()){
					
						int index = 0;
						
						while (rst.next()) {
							listaMarcas[index] = rst.getString(1);
							cantidadMarcas[index] = rst.getInt(2);

							if (listaMarcas[index].equalsIgnoreCase("Acer")) {
								acer = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("alenware")) {
								alenware = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("hp")) {
								hp = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("lenovo")) {
								lenovo = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("dell")) {
								dell = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("toshiba")) {
								toshiba = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("brother")) {
								brother = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("samsumg")) {
								samsumg = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("apple")) {
								apple = cantidadMarcas[index];
							} else if (listaMarcas[index].equalsIgnoreCase("asus")) {
								asus = cantidadMarcas[index];
							}

							index++;

						}
					}
				}

			} catch (SQLException e) {
				System.err.println("Error en la consulta " + e.getMessage());
			}

			listaRetorno[0] = acer;
			listaRetorno[1] = alenware;
			listaRetorno[2] = hp;
			listaRetorno[3] = lenovo;
			listaRetorno[4] = dell;
			listaRetorno[5] = toshiba;
			listaRetorno[6] = brother;
			listaRetorno[7] = samsumg;
			listaRetorno[8] = apple;
			listaRetorno[9] = asus;

			return listaRetorno;
		}

	}


