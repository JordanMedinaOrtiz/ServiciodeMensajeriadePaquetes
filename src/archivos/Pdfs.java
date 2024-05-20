/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package archivos;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtils;

/**
 * Clase Pdfs
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Pdfs {
    /**
     * Variable de instancia.
     */
    private int i;
    /**
     * Variable de instancia.
     */
    private Connection con;
    
    /**
     * Constructor.
     * @param con 
     */
    public Pdfs(Connection con) {
        this.con = con;
        this.i = 0;
    }
    
    /**
    * Genera un documento PDF con la información de los empleados.
    *
    * Este método crea un archivo PDF que contiene la información de los empleados obtenida desde la base de datos.
    *
    * @param nombre El nombre del archivo PDF que se generará.
    * @throws SQLException Si ocurre un error al interactuar con la base de datos.
    */
    public void pdfEmpleado(String nombre) throws SQLException{
        Document document = new Document();
        File path = new File("src/archivos/", nombre + ".pdf");
        
        try{
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
            
            ImageIcon logo = new ImageIcon(getClass().getResource("/img/fondoLogin.png"));
            g.drawImage(logo.getImage(), 30, 0, 50, 90, null);
            
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);
            g.setColor(Color.RED);
            g.drawString("ENVÍOMEX", 130, 60);
            
            ImageIcon img1 = new ImageIcon(getClass().getResource("/img/fondoLogin.png"));
            g.drawImage(img1.getImage(), 50, 100, 500, 300, null);
            
            Font fontFinal = new Font("Tahoma", Font.BOLD + Font.ITALIC, 10);
            g.setFont(fontFinal);
            g.setColor(Color.BLACK);
            g.drawString("Jordan Medina Ortiz", 150, 750);
            
            document.newPage();
            
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM empleado");
            ResultSet rs = sts.getResultSet();
            int cont = 0;
            ImageIcon logo2 = new ImageIcon(getClass().getResource("/img/fondoLogin.png"));
            g.drawImage(logo2.getImage(), 30, 0, 50, 90, null);

            Font font7 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font7);
            g.setColor(Color.RED);
            g.drawString("Servicio de Mensajería", 130, 10);

            Font font4 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 20);
            g.setFont(font4);
            g.setColor(Color.BLACK);
            g.drawString("Empleados Registrados en el Sistema", 100, 60);

            Font font3 = new Font("Tahoma", Font.ROMAN_BASELINE + Font.ITALIC, 15);
            g.setFont(font3);
            g.setColor(Color.black);
            int y = 140;
            int x = 20;
            while(rs.next()) {
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
                
                g.drawString("ID del Empleado: " + rs.getString("idEmpleado"), x, y);
                y += 20;
                g.drawString("Nombre del Empleado: " + rs.getString("nombre"), x, y);
                y += 20;
                g.drawString("Dirección del Empleado: " + rs.getString("direccion"), x, y);
                y += 20;
                g.drawString("Teléfono del Empleado: " + rs.getString("telefono"), x, y);
                y += 20;
                g.drawString("Email del Empleado: " + rs.getString("email"), x, y);
                y += 20;
                g.drawString("Contraseña del Empleado: " + rs.getString("contraseña"), x, y);
                y += 20;
                g.drawString("Rol del Empleado: " + rol, x, y);
                y += 50;
                cont++;
                if(cont == 3){
                    document.newPage();
                    g.drawImage(logo2.getImage(), 30, 0, 50, 90, null);

                    g.setFont(font7);
                    g.setColor(Color.RED);
                    g.drawString("Servicio de Mensajería", 130, 10);

                    g.setFont(font4);
                    g.setColor(Color.BLACK);
                    g.drawString("Empleados Registrados en el Sistema", 100, 60);

                    g.setFont(font3);
                    g.setColor(Color.black);
                    
                    cont = 0;
                    y = 140;
                    x = 20;
                }
            }
            Font fontFinal2 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 10);
            g.setFont(fontFinal2);
            g.setColor(Color.BLACK);
            g.drawString("Jodan Medina Ortiz 179913@upslp.edu.mx", x, y);
            
        }catch(DocumentException | FileNotFoundException ex){
            System.err.println(ex.getMessage());
       }
        
        document.close();
    }
    
    /**
    * Genera un documento PDF que contiene una gráfica de barras mostrando la cantidad de usuarios por rol.
    *
    * Este método consulta la base de datos para obtener la cantidad de usuarios por rol, crea una gráfica de barras con los datos obtenidos
    * y guarda la gráfica como una imagen PNG. Luego, crea un documento PDF que contiene la gráfica y otra información adicional.
    *
    * @param nombre El nombre del archivo PDF que se generará.
    * @throws IOException Si ocurre un error al guardar la gráfica como una imagen PNG.
    * @throws SQLException Si ocurre un error al interactuar con la base de datos.
    */
    public void pdfGrafica(String nombre) throws IOException, SQLException{
        Statement sts = con.createStatement();
        sts.execute("SELECT * FROM empleado");
        ResultSet rs = sts.getResultSet();
        
        Document document = new Document();
        File path = new File("src/archivos/", nombre + ".pdf");
        
        int administrador = 0, recepcionista = 0, repartidor = 0, logistica = 0;
        int i = 0;
        while(rs.next()) {
            if(rs.getString("rolRegistra").equals("1") && rs.getString("rolEntrega").equals("1")) {
                logistica += 1;
            }else if(rs.getString("rolRegistra").equals("1")) {
                recepcionista += 1;
            }else if(rs.getString("rolEntrega").equals("1")) {
                repartidor += 1;
            }else if(rs.getString("admin").equals("1")) {
                administrador += 1;
            }
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(administrador, "Administradores", "0");
        dataset.addValue(recepcionista, "Recepcionistas", "1");
        dataset.addValue(repartidor, "Repartidores", "0");
        dataset.addValue(logistica, "Logisticas", "1");

        JFreeChart barChart = ChartFactory.createBarChart(
            "Cantidad de Usuarios por Rol",
            "Rol", "Cantidad",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);

        int width = 560;
        int height = 367;
        File barChartFile = new File("BarChart.png");

        ChartUtils.saveChartAsPNG(barChartFile, barChart, width, height);
        ImageIcon chartImage = new ImageIcon("BarChart.png");

        try{
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
            
            ImageIcon logo = new ImageIcon(getClass().getResource("/img/fondoLogin.png"));
            g.drawImage(logo.getImage(), 30, 0, 50, 90, null);
            
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);
            g.setColor(Color.RED);
            g.drawString("Servicio de Mensajería", 130, 60);
            
            ImageIcon img1 = new ImageIcon(getClass().getResource("/img/fondoLogin.png"));
            g.drawImage(img1.getImage(), 50, 100, 500, 300, null);
            
            Font fontFinal = new Font("Tahoma", Font.BOLD + Font.ITALIC, 10);
            g.setFont(fontFinal);
            g.setColor(Color.BLACK);
            g.drawString("Jordan Medina Ortiz", 150, 750);
            
            document.newPage();

            ImageIcon logo2 = new ImageIcon(getClass().getResource("/img/fondoLogin.png"));
            g.drawImage(logo2.getImage(), 30, 0, 50, 90, null);

            Font font8 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font8);
            g.setColor(Color.RED);
            g.drawString("Servicio de Mensajería", 130, 60);

            Font font3 = new Font("Tahoma", Font.ROMAN_BASELINE + Font.ITALIC, 15);
            g.setFont(font3);
            g.setColor(Color.black);

            int y = 140;
            int x = 35;

            g.drawImage(chartImage.getImage(), x, y, 500, 300, null);

            Font fontFinal2 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 10);
            g.setFont(fontFinal2);
            g.setColor(Color.BLACK);
            g.drawString("Jodan Medina Ortiz 179913@upslp.edu.mx", x, y);
            i++;
            
        }catch(DocumentException | FileNotFoundException ex){
            System.err.println(ex.getMessage());
       }
        
        document.close();
    }
}