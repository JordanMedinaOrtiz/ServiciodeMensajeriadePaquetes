/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.mapa;

import com.github.kevinsawicki.http.HttpRequest;
import gui.clases.EventLocationSelected;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;
import org.json.JSONException;
import org.json.JSONObject;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;

/**
 * Clase Mapa Custom extendida de JXMapViewer.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class MapaCustom extends JXMapViewer {
    /**
     * Variable de instancia.
     */
    private final Image image;
    /**
     * Variable de instancia.
     */
    private EventLocationSelected event;
    
    /**
     * Constructor.
     */
    public MapaCustom(){
       image = new ImageIcon(getClass().getResource("/img/pin.png")).getImage();
    }
    
    /**
     * Inicializa el mapa con configuraciones predeterminadas.
     */
    public void init(){
        setTileFactory(new DefaultTileFactory(new OSMTileFactoryInfo("", "https://b.tile.openstreetmap.fr/hot/")));
        setAddressLocation(new GeoPosition(22.122576215599352, -100.98416757279958));
        setZoom(5);
        MouseInputListener mm = new PanMouseInputListener(this);
        addMouseListener(mm);
        addMouseMotionListener(mm);
        addMouseWheelListener(new ZoomMouseWheelListenerCenter(this));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mostrarUbicacion();
            }
        });
    }
    
    /**
    * Muestra la ubicación de la dirección correspondiente a la posición central del mapa.
    */
    private void mostrarUbicacion() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    event.oneSelected(getLocation(getCenterPosition()));
                }catch(Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }
    
    /**
     * Obtiene la ubicación de la dirección a partir de la GeoPosición proporcionada.
     * 
     * @param pos La GeoPosición que contiene información de latitud y longitud.
     * @return La ubicación de la dirección como una cadena.
     * @throws JSONException si hay un error al analizar los datos JSON.
     */
    public String getLocation(GeoPosition pos) throws JSONException {
        String body = HttpRequest.get("https://nominatim.openstreetmap.org/reverse?lat=" + pos.getLatitude() + "&lon=" + pos.getLongitude() + "&format=json").body();
        JSONObject json = new JSONObject(body);
        return json.getString("display_name");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = getWidth()/2-12;
        int y = getHeight()/2-24;
        g2.drawImage(image, x, y, null);
        Area area = new Area(new Rectangle.Double(0, 0, getWidth(), getHeight()));
        area.subtract(new Area(new RoundRectangle2D.Double(5, 5, getWidth()-10, getHeight()-10, 20, 20)));
        g2.setColor(new Color(255, 255, 255));
        g2.fill(area);
        g2.dispose();
    }

    /**
     * Obtiene el manejador de eventos para la selección de ubicación.
     * 
     * @return El manejador de eventos para la selección de ubicación.
     */
    public EventLocationSelected getEvent() {
        return event;
    }

    /**
     * Establece el manejador de eventos para la selección de ubicación.
     * 
     * @param event El manejador de eventos para la selección de ubicación que se va a establecer.
     */
    public void setEvent(EventLocationSelected event) {
        this.event = event;
    }
    
}