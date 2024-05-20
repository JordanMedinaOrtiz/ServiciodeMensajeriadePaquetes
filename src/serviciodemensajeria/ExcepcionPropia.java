/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package serviciodemensajeria;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 * Clase Excepcion Propia extendida de Exception.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class ExcepcionPropia extends Exception {
    /**
     * Variable de instancia.
     */
    private final String userLogin;
    /**
     * Variable de instancia.
     */
    private final String userPassword;
    /**
     * Variable de instancia.
     */
    private final Date fecha, hora;
    /**
     * Variable de instancia.
     */
    private final DateFormat formatoF, formatoH;
    /**
     * Variable de instancia.
     */
    private final String filename;
    /**
     * Variable de instancia.
     */
    ArrayList<String[]> registros = new ArrayList<>();

    /**
     * Constuctor.
     * @param userLogin
     * @param userPassword
     * @param filename
     * @throws FileNotFoundException 
     */
    public ExcepcionPropia(String userLogin, String userPassword, String filename) throws FileNotFoundException {
        fecha = new Date();
        hora = new Date();
        formatoF = DateFormat.getDateInstance(DateFormat.FULL);
        formatoH = new SimpleDateFormat("HH:mm:ss");
        this.filename = filename;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        agregarArchivo();
        crearPDF();
    }
    
    /**
     * Crea un archivo Excel con el encabezado correspondiente.
     *
     * @throws FileNotFoundException si no se encuentra el archivo
     */
    public void crearArchivo() throws FileNotFoundException {
        PrintStream alumnoFile = new PrintStream("src/archivos/" + this.filename + ".xls");
        alumnoFile.println("""
                           Intentos ingreso al sistema\nUsuario\tContraseña\tFecha\tHora""");
    }
    
    /**
     * Agrega un registro al archivo Excel.
     *
     * @throws FileNotFoundException si no se encuentra el archivo
     */
    public void agregarArchivo() throws FileNotFoundException {
        try {
            File archivo = new File("src/archivos/" + this.filename +".xls");
            if(!archivo.exists()) {
                System.out.println(System.getProperty("src/archivos/logueos.xls"));
                crearArchivo();
            }
            try(
                FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(userLogin + "\t" + userPassword + "\t" + formatoF.format(fecha) + "\t" + formatoH.format(hora) + "\n");
                }
        }catch(IOException err) {
            System.out.println(err);
        }
    }
    
    /**
     * Crea un archivo PDF con la información de los registros de inicio de sesión.
     */
    public void crearPDF(){
        cargarUsuarios();
        Document document = new Document();
        File path = new File("src/archivos/"+ this.filename + ".pdf");
        
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

            ImageIcon logo2 = new ImageIcon(getClass().getResource("/img/fondoLogin.png"));
            g.drawImage(logo2.getImage(), 30, 0, 50, 90, null);

            Font font7 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font7);
            g.setColor(Color.RED);
            g.drawString("Servicio de Mensajería", 130, 10);

            Font font4 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 20);
            g.setFont(font4);
            g.setColor(Color.BLACK);
            g.drawString("Registro de Inicio de Sesion " + filename, 100, 60);

            Font font3 = new Font("Tahoma", Font.ROMAN_BASELINE + Font.ITALIC, 15);
            g.setFont(font3);
            g.setColor(Color.black);
            int y = 140;
            int x = 100;
            int cont = 0;
            for(String[] registro : registros) {
                g.drawString("Usuario: " + registro[0], x, y);
                y += 20;
                g.drawString("Contraseña: " + registro[1], x, y);
                y += 20;
                g.drawString("Fecha: " + registro[2], x, y);
                y += 20;
                g.drawString("Hora: " + registro[3], x, y);
                y += 50;
                cont++;
                if(cont == 5){
                    document.newPage();
                    g.drawImage(logo2.getImage(), 30, 0, 50, 90, null);

                    g.setFont(font7);
                    g.setColor(Color.RED);
                    g.drawString("Servicio de Mensajería", 130, 10);

                    g.setFont(font4);
                    g.setColor(Color.BLACK);
                    g.drawString("Registro de Inicio de Sesion " + filename, 100, 60);

                    g.setFont(font3);
                    g.setColor(Color.black);
                    
                    cont = 0;
                    y = 140;
                    x = 100;
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
     * Carga los usuarios desde el archivo Excel y los guarda en la lista de registros.
     */
    public void cargarUsuarios() {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/archivos/" + this.filename + ".xls"))) {
            String linea;
            while((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\t");
                if(partes.length == 4) {
                    String[] registro = {partes[0], partes[1], partes[2], partes[3]};
                    registros.add(registro);
                }
            }
        }catch(IOException | NumberFormatException ex) {
            System.out.println("Error al cargar usuarios: " + ex.getMessage());
        }
    }
}