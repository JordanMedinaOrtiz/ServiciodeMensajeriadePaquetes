/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package archivos;

import java.sql.Connection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Clase Archivos
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Archivos {
    /**
     * Variable de instancia.
     */
    private Connection con;
    
    /**
     * Constructor.
     * @param con 
     */
    public Archivos(Connection con) {
        this.con = con;
    }

    /**
    * Crea un archivo de empleados en formato XLS.
    *
    * Este método realiza una consulta a la base de datos para obtener la información
    * de los empleados y la escribe en un archivo Excel.
    *
    * @throws FileNotFoundException Si no se puede encontrar o crear el archivo.
    * @throws SQLException Si ocurre un error al interactuar con la base de datos.
    */
    public void crearArchivo() throws FileNotFoundException, SQLException{
        PrintStream empleadoFile = new PrintStream("src/archivos/Empleados.xls");
        Statement sts = con.createStatement();
        sts.execute("SELECT * FROM empleado");
        ResultSet rs = sts.getResultSet();
        while(rs.next()){
            String rol = null;
            if(!(rs.getString("admin").equals("0"))){
                rol = "Administrador";
            }else if(!(rs.getString("rolRegistra").equals("0"))){
                    rol = "Recepcionista";
                }else if(!(rs.getString("rolEntrega").equals("0"))){
                    rol = "Repartidor";
                }
            if(!(rs.getString("rolRegistra").equals("0")) && !(rs.getString("rolEntrega").equals("0"))) {
                rol = "Logistica";
            }
            empleadoFile.println(rs.getString("idEmpleado")+ "\t " + rs.getString("nombre") + "\t" + rs.getString("direccion") + "\t" + rs.getString("telefono")
                    + "\t" + rs.getString("email") + "\t" + rs.getString("contraseña") + "\t" + rol);
        }
    }
    
    /**
    * Agrega información de empleados al archivo existente en formato XLS.
    *
    * Este método realiza una consulta a la base de datos para obtener la información
    * de los empleados y la agrega al final de un archivo Excel existente.
    *
    * @throws FileNotFoundException Si no se puede encontrar el archivo de empleados.
    * @throws SQLException Si ocurre un error al interactuar con la base de datos.
    */
    public void agregarArchivos() throws FileNotFoundException, SQLException{
        try{
            File archivo = new File("src/archivos/Empleados.xls");
            if(!archivo.exists()){
                System.out.println(System.getProperty("user.dir"));
                crearArchivo();
            }
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM empleado");
            ResultSet rs = sts.getResultSet();
            FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            while(rs.next()){
                String rol = null;
                if(!(rs.getString("admin").equals("0"))){
                    rol = "Administrador";
                }else if(!(rs.getString("rolRegistra").equals("0"))){
                        rol = "Recepcionista";
                    }else if(!(rs.getString("rolEntrega").equals("0"))){
                        rol = "Repartidor";
                    }
                if(!(rs.getString("rolRegistra").equals("0")) && !(rs.getString("rolEntrega").equals("0"))) {
                    rol = "Logistica";
                }
                bw.write(rs.getString("idEmpleado")+ "\t " + rs.getString("nombre") + "\t" + rs.getString("direccion") + "\t" + rs.getString("telefono")
                        + "\t" + rs.getString("email") + "\t" + rs.getString("contraseña") + "\t" + rol);
            }
            
            System.out.println("Información Agregada!");
            bw.close();
            fw.close();
        }catch(IOException e){ }
    }
    
    /**
    * Lee y muestra el contenido del archivo de empleados en formato XLS.
    *
    * Este método lee el contenido del archivo de empleados y muestra cada línea en la consola.
    *
    * @throws FileNotFoundException Si no se puede encontrar el archivo de empleados.
    */
    public void leerArchivo() throws FileNotFoundException{
        System.out.println(System.getProperty("user.dir"));
        Scanner entraFile = new Scanner(new File("src/archivos/Empleados.xls"));
        while(entraFile.hasNextLine()){
            String regis = entraFile.nextLine();
            System.out.println(regis);
        }
   }
}
