package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JCalendar;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
//import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Label;
import com.toedter.calendar.JDayChooser;

import controlador.MetodosBaseDeDatos;
import modelo.Evento;

import com.toedter.calendar.JDateChooser;

public class PanelGestionarEvent extends JFrame implements ActionListener {

    private JPanel contentPane;
    private static JTextField campoNombreEvento;
    private static JTextField campoLlocEvento;
    private static JTextField campoHoraInici;
    private static JTextField campoMinutoInici;
    private static JTextField campoInformacioSecundaria;
    private JButton btnModificar, btnAnyadir, btnEliminar, botonBuscar, botonBuscar2, botonListo, botonListo2;
    private static JTextField campoHoraFin;
    private static JTextField campoMinutoFin;
    private static JTextField campoImagenUri;
    private static JTextField campoImagenUri2;
    private static JLabel imagenMiniatura;
    private static JLabel imagenPrincipal;
    public JLabel etiquetaOrganizador;
    private static JDateChooser campoFechaInici;
    private static JDateChooser campoFechaFin;
    private static JTextArea campoDescripcion;
    private static JComboBox<String> comboCategoria;
    private static DefaultTableModel modelo;
    private JScrollPane scroll;
    private static JTable table_1;
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PanelGestionarEvent frame = new PanelGestionarEvent();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    @SuppressWarnings("null")
    public PanelGestionarEvent() {
    	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1366, 768);
	setTitle("València Events");
	ImageIcon logoV = new ImageIcon("./imagenes/login.png");
	Image logo = logoV.getImage();
	setIconImage(logo);
	//setBounds(100, 100, 1280, 720);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(65, 129, 190));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);	
	setLocationRelativeTo(null);
	
	JLabel lblValenciaeventsnet = new JLabel("www.valenciaevents.net");
	lblValenciaeventsnet.setToolTipText("Haga clic para visitar la web oficial.");
	lblValenciaeventsnet.setFont(new Font("Roboto Th", Font.PLAIN, 66));
	lblValenciaeventsnet.setForeground(Color.WHITE);
	lblValenciaeventsnet.setBounds(596, 638, 754, 90);
	lblValenciaeventsnet.addMouseListener(new MouseAdapter()
		{
	    	public void mouseClicked(MouseEvent ex){
	    		try {
	    		    Desktop.getDesktop().browse(new URI("http://valenciaevents.net/"));
	    		} catch (IOException e1) {
	    		    
	    		    e1.printStackTrace();
	    		} catch (URISyntaxException e) {
	    		    
	    		    e.printStackTrace();
	    		
	    		}
	    	}
	    
		});
	contentPane.add(lblValenciaeventsnet);
	
	JLabel lblUsuari = new JLabel("Usuari:");
	lblUsuari.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblUsuari.setForeground(Color.WHITE);
	lblUsuari.setBounds(45, 22, 63, 19);
	contentPane.add(lblUsuari);
	
	JLabel lblVersiValncia = new JLabel("Versi\u00F3 0.1.1 Val\u00E8ncia Events");
	lblVersiValncia.setForeground(Color.WHITE);
	lblVersiValncia.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblVersiValncia.setBounds(45, 52, 193, 14);
	contentPane.add(lblVersiValncia);
	
	etiquetaOrganizador = new JLabel(Login.nombre);
	etiquetaOrganizador.setHorizontalAlignment(SwingConstants.LEFT);
	etiquetaOrganizador.setFont(new Font("Tahoma", Font.PLAIN, 15));
	etiquetaOrganizador.setForeground(Color.WHITE);
	etiquetaOrganizador.setBounds(99, 22, 603, 19);
	contentPane.add(etiquetaOrganizador);
	
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	btnAnyadir = new JButton("AFEGIR EVENT");
	btnAnyadir.setBackground(Color.LIGHT_GRAY);
	btnAnyadir.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnAnyadir.addActionListener(this); 
	btnAnyadir.setFocusable(false);
	btnAnyadir.setBorder(emptyBorder);
	btnAnyadir.setBounds(712, 22, 164, 43);
	contentPane.add(btnAnyadir);
	
	btnModificar = new JButton("MODIFICAR EVENT");
	btnModificar.setBackground(Color.LIGHT_GRAY);
	btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnModificar.setBounds(910, 23, 180, 43);
	btnModificar.setFocusable(false);
	btnModificar.setBorder(emptyBorder);
	btnModificar.addActionListener(this);
	contentPane.add(btnModificar);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(28, 83, 1301, 7);
	contentPane.add(separator);
	
	JLabel lblNewLabel = new JLabel("Recorda, la llengua de l'APP \u00E9s la valenci\u00E0, utilitza'l sempre que pugues");
	lblNewLabel.setBackground(SystemColor.inactiveCaption);
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setForeground(SystemColor.inactiveCaption);
	lblNewLabel.setBounds(28, 98, 1301, 26);
	contentPane.add(lblNewLabel);
	
	JLabel lblElsTeusEvents = new JLabel("ELS TEUS EVENTS");
	lblElsTeusEvents.setHorizontalAlignment(SwingConstants.CENTER);
	lblElsTeusEvents.setForeground(Color.WHITE);
	lblElsTeusEvents.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblElsTeusEvents.setBounds(45, 135, 245, 26);
	contentPane.add(lblElsTeusEvents);
	
	
	
	
	
	JLabel lblNomDelEvent = new JLabel("NOM DEL EVENT");
	lblNomDelEvent.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNomDelEvent.setForeground(Color.WHITE);
	lblNomDelEvent.setBounds(350, 170, 134, 14);
	contentPane.add(lblNomDelEvent);
	
	campoNombreEvento = new JTextField();
	campoNombreEvento.setBounds(350, 195, 180, 26);
	contentPane.add(campoNombreEvento);
	campoNombreEvento.setColumns(10);
	
	JLabel lblLlocDelEvent = new JLabel("LLOC DEL EVENT");
	lblLlocDelEvent.setForeground(Color.WHITE);
	lblLlocDelEvent.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblLlocDelEvent.setBounds(350, 244, 134, 14);
	contentPane.add(lblLlocDelEvent);
	
	campoLlocEvento = new JTextField();
	campoLlocEvento.setBounds(350, 269, 180, 26);
	contentPane.add(campoLlocEvento);
	campoLlocEvento.setColumns(10);
	
	JLabel lblData = new JLabel("DATA INICI");
	lblData.setForeground(Color.WHITE);
	lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblData.setBounds(350, 316, 96, 14);
	contentPane.add(lblData);
	
	JLabel lblHora = new JLabel("HORA INICI");
	lblHora.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblHora.setForeground(Color.WHITE);
	lblHora.setBounds(495, 316, 96, 14);
	contentPane.add(lblHora);
	
	campoHoraInici = new JTextField();
	campoHoraInici.setBounds(495, 341, 36, 34);
	contentPane.add(campoHoraInici);
	campoHoraInici.setColumns(10);
	
	
	campoMinutoInici = new JTextField();
	campoMinutoInici.setColumns(10);
	campoMinutoInici.setBounds(548, 341, 36, 34);
	contentPane.add(campoMinutoInici);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.WHITE);
	separator_1.setBounds(536, 348, 5, 7);
	contentPane.add(separator_1);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setForeground(Color.WHITE);
	separator_2.setBounds(536, 366, 5, 7);
	contentPane.add(separator_2);
	
	JLabel lblCategoria = new JLabel("CATEGORIA");
	lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblCategoria.setForeground(Color.WHITE);
	lblCategoria.setBounds(350, 515, 96, 19);
	contentPane.add(lblCategoria);
	
	comboCategoria = new JComboBox<String>();
	comboCategoria.setBounds(350, 545, 272, 34);
	
	
	for(int i = 0; i < MetodosBaseDeDatos.consultarCategorias().size(); i++){
	    
	    comboCategoria.addItem(MetodosBaseDeDatos.consultarCategorias().get(i));
	}
	
	contentPane.add(comboCategoria);
	
	JLabel lblDescripciPrincipal = new JLabel("DESCRIPCI\u00D3 PRINCIPAL");
	lblDescripciPrincipal.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblDescripciPrincipal.setForeground(Color.WHITE);
	lblDescripciPrincipal.setBounds(702, 170, 193, 14);
	contentPane.add(lblDescripciPrincipal);
	
	scroll = new JScrollPane();
	scroll.setBounds(702, 196, 261, 191);
	contentPane.add(scroll);
	
	//JTextArea textArea = new JTextArea();
	
	
	campoDescripcion = new JTextArea();
	campoDescripcion.setBounds(702, 196, 261, 191);
	campoDescripcion.setWrapStyleWord(true);
	campoDescripcion.setLineWrap(true);
	scroll.setViewportView(campoDescripcion);
	
	JLabel lblInformaciSecundaria = new JLabel("INFORMACI\u00D3 SECUNDARIA");
	lblInformaciSecundaria.setForeground(Color.WHITE);
	lblInformaciSecundaria.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblInformaciSecundaria.setBounds(702, 398, 216, 14);
	contentPane.add(lblInformaciSecundaria);
	
	campoInformacioSecundaria = new JTextField();
	campoInformacioSecundaria.setBounds(702, 426, 245, 34);
	contentPane.add(campoInformacioSecundaria);
	campoInformacioSecundaria.setColumns(10);
	
	JLabel lblMiniatura = new JLabel("MINIATURA");
	lblMiniatura.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblMiniatura.setForeground(Color.WHITE);
	lblMiniatura.setBounds(1048, 170, 90, 14);
	contentPane.add(lblMiniatura);
	
	JLabel lblImatgePrincipal = new JLabel("IMATGE PRINCIPAL");
	lblImatgePrincipal.setForeground(Color.WHITE);
	lblImatgePrincipal.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblImatgePrincipal.setBounds(1048, 292, 155, 14);
	contentPane.add(lblImatgePrincipal);
	
	btnEliminar = new JButton("ELIMINAR EVENT");
	btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnEliminar.setBackground(Color.LIGHT_GRAY);
	btnEliminar.setBounds(1123, 22, 180, 43);
	btnEliminar.setFocusable(false);
	btnEliminar.setBorder(emptyBorder);
	btnEliminar.addActionListener(this);
	contentPane.add(btnEliminar);
	
	campoFechaInici = new JDateChooser();
	campoFechaInici.getCalendarButton().setBackground(new Color(25, 25, 112));
	campoFechaInici.setBounds(350, 341, 119, 34);
	campoFechaInici.setFocusable(false);
	campoFechaInici.setBorder(emptyBorder);
	contentPane.add(campoFechaInici);
	
	JLabel lblDataFin = new JLabel("DATA FIN");
	lblDataFin.setForeground(Color.WHITE);
	lblDataFin.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblDataFin.setBounds(350, 418, 96, 14);
	contentPane.add(lblDataFin);
	
	campoFechaFin = new JDateChooser();
	campoFechaFin.getCalendarButton().setBackground(new Color(25, 25, 112));
	campoFechaFin.setBounds(350, 443, 119, 34);
	campoFechaFin.setFocusable(false);
	campoFechaFin.setBorder(emptyBorder);
	contentPane.add(campoFechaFin);
	
	JLabel lblHoraFin = new JLabel("HORA FIN");
	lblHoraFin.setForeground(Color.WHITE);
	lblHoraFin.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblHoraFin.setBounds(495, 418, 96, 14);
	contentPane.add(lblHoraFin);
	
	campoHoraFin = new JTextField();
	campoHoraFin.setColumns(10);
	campoHoraFin.setBounds(495, 443, 36, 34);
	contentPane.add(campoHoraFin);
	
	campoMinutoFin = new JTextField();
	campoMinutoFin.setColumns(10);
	campoMinutoFin.setBounds(548, 443, 36, 34);
	contentPane.add(campoMinutoFin);
	
	JSeparator separator_3 = new JSeparator();
	separator_3.setForeground(Color.WHITE);
	separator_3.setBounds(536, 450, 5, 7);
	contentPane.add(separator_3);
	
	JSeparator separator_4 = new JSeparator();
	separator_4.setForeground(Color.WHITE);
	separator_4.setBounds(536, 468, 5, 7);
	contentPane.add(separator_4);
	
	campoImagenUri = new JTextField();
	campoImagenUri.setBounds(1048, 198, 255, 26);
	contentPane.add(campoImagenUri);
	campoImagenUri.setColumns(10);
	
	campoImagenUri2 = new JTextField();
	campoImagenUri2.setColumns(10);
	campoImagenUri2.setBounds(1048, 316, 255, 26);
	contentPane.add(campoImagenUri2);
	
	botonBuscar = new JButton("Buscar imagen");
	botonBuscar.setForeground(Color.WHITE);
	botonBuscar.setBackground(new Color(25, 25, 112));
	botonBuscar.setBounds(1048, 242, 139, 23);
	botonBuscar.setFocusable(false);
	botonBuscar.setBorder(emptyBorder);
	botonBuscar.addActionListener(this);
	botonBuscar.setFocusable(false);
	contentPane.add(botonBuscar);
	
	
	botonListo = new JButton("Listo");
	botonListo.setForeground(new Color(255, 255, 255));
	botonListo.setBackground(new Color(25, 25, 112));
	botonListo.setBounds(1213, 242, 90, 23);
	botonListo.setFocusable(false);
	botonListo.setBorder(emptyBorder);
	botonListo.addActionListener(this);
	botonListo.setFocusable(false);
	contentPane.add(botonListo);
	
	botonBuscar2 = new JButton("Buscar imagen");
	botonBuscar2.setForeground(new Color(255, 255, 255));
	botonBuscar2.setBackground(new Color(25, 25, 112));
	botonBuscar2.setBounds(1048, 366, 139, 23);
	botonBuscar2.addActionListener(this);
	botonBuscar2.setFocusable(false);
	botonBuscar2.setBorder(emptyBorder);
	botonBuscar2.setFocusable(false);
	contentPane.add(botonBuscar2);
	
	botonListo2 = new JButton("Listo");
	botonListo2.setForeground(new Color(255, 255, 255));
	botonListo2.setBackground(new Color(25, 25, 112));
	botonListo2.setBounds(1213, 364, 90, 23);
	botonListo2.setFocusable(false);
	botonListo2.setBorder(emptyBorder);
	botonListo2.addActionListener(this);
	botonListo2.setFocusable(false);
	contentPane.add(botonListo2);
	
	JLabel lblNewLabel_1 = new JLabel("VISTA");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
	lblNewLabel_1.setBounds(1076, 426, 153, 19);
	contentPane.add(lblNewLabel_1);
	
	imagenMiniatura = new JLabel("");
	imagenMiniatura.setBounds(1035, 468, 68, 99);
	contentPane.add(imagenMiniatura);
	
	imagenPrincipal = new JLabel("");
	imagenPrincipal.setBounds(1154, 468, 175, 99);
	contentPane.add(imagenPrincipal);
	
	JLabel lblNewLabel_4 = new JLabel("MINIATURA");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel_4.setForeground(Color.WHITE);
	lblNewLabel_4.setBounds(1035, 582, 81, 14);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("IMATGE PRINCIPAL");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel_5.setForeground(Color.WHITE);
	lblNewLabel_5.setBounds(1178, 582, 125, 14);
	contentPane.add(lblNewLabel_5);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(28, 172, 278, 407);
	contentPane.add(scrollPane);
	
	modelo = new DefaultTableModel();
	
	
	modelo.addColumn("Nombre");
	
	mostrarDatos();
	
	 
	
	table_1 = new JTable(modelo){
	        /**
	     * 
	     */
	    //Hacemos que las filas no se puedan editar
	    private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex, int vColIndex) {
		    
	            return false;
	        }};
	
	table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
	scrollPane.setViewportView(table_1);
	//System.out.println(MetodosBaseDeDatos.consultarNombreEventos());
	
	table_1.addMouseListener(new MouseAdapter(){
	    public void mousePressed(MouseEvent e){
				
		if(e.getClickCount() == 2){
		    
		    dobleClickTable();
		    
		}
	    }
	});
	
	
    }
        
   
    @Override
    public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == btnModificar){
	    
	    if(comprobarCamposVacios() == true){
		JOptionPane.showMessageDialog(null,"No ha seleccionado ningún evento.","Advertencia!", JOptionPane.WARNING_MESSAGE);
	    }
	    else{
	    
	    LocalTime horaInicio1 = LocalTime.parse(campoHoraInici.getText().toString() +":"+ campoMinutoInici.getText().toString());
	    LocalTime horaFin1 = LocalTime.parse(campoHoraFin.getText().toString() +":"+ campoMinutoFin.getText().toString());
	    
	    /*Capturar la fecha inicio y parsearla a Date*/
	    Date fechaInicio = (Date) campoFechaInici.getDate();
	    	  
	    String fechaIniciFormateada = formato.format(fechaInicio);
	    
	    /*Capturar la fecha fin y parsearla a Date*/
	    Date fechaFin = (Date) campoFechaFin.getDate();
	    	  		
	    String fechaFinFormateada = formato.format(fechaFin);
	    	    
	    //Capturar el item del combobox seleccionado
	    String itemSeleccionado = (String) comboCategoria.getSelectedItem();
	    
	  //Obtengo el nombre del evento seleccionado en la tabla
	    String nombreEvento = (String) modelo.getValueAt(table_1.getSelectedRow(), 0);
	    
	    Evento evento = new Evento();
	    
	    evento.setNombre(campoNombreEvento.getText().toString());
	    evento.setFechaInicio(fechaIniciFormateada);
	    evento.setHoraInicio(java.sql.Time.valueOf(horaInicio1));
	    evento.setFechaFin(fechaFinFormateada);
	    evento.setHoraFin(java.sql.Time.valueOf(horaFin1));
	    evento.setDescripcion(campoDescripcion.getText().toString());
	    evento.setInfoSecundaria(campoInformacioSecundaria.getText().toString());
	    evento.setFotoMiniatura(campoImagenUri.getText().toString());
	    evento.setFotoPrincipal(campoImagenUri2.getText().toString());
	    evento.setIdCategoria(MetodosBaseDeDatos.consultarIdCategorias(itemSeleccionado));
	    evento.setIdLugar(MetodosBaseDeDatos.consultarIdLugar(campoLlocEvento.getText().toString()));
	    evento.setIdOrganizador(MetodosBaseDeDatos.consultarIdOrganizador(Login.nombre));
	    
	    
	    MetodosBaseDeDatos.modificarEvento(evento, nombreEvento);
	    
	    resetearCampos();
	   //Primero eliminamos todas las filas de la tabla 
	   for(int i = modelo.getRowCount()-1; i >= 0 ; i--){
	       modelo.removeRow(i);
	   }
	   //Mostramos lo eventos y se añaden al JTable
	    mostrarDatos();
	  }
	}
	
	if(e.getSource() == btnAnyadir){
	    
	    
	    if(comprobarCamposVacios() == true){
		JOptionPane.showMessageDialog(null,"Los campos no pueden quedar vacíos. Por favor, rellenelos!","Advertencia!", JOptionPane.WARNING_MESSAGE);
	    }
	    else{
	    /*Hacemos uso del metodo insertar lugar para luego poder insertar la id del lugar*/
	    MetodosBaseDeDatos.anyadirLugar(campoLlocEvento.getText().toString()); 
	      
	    LocalTime horaInicio1 = LocalTime.parse(campoHoraInici.getText().toString() +":"+ campoMinutoInici.getText().toString());
	    LocalTime horaFin1 = LocalTime.parse(campoHoraFin.getText().toString() +":"+ campoMinutoFin.getText().toString());
	    
	    /*Capturar la fecha inicio y parsearla a Date*/
	    Date fechaInicio = (Date) campoFechaInici.getDate();
	    
	    String fechaIniciFormateada = formato.format(fechaInicio);
	    
	    /*Capturar la fecha fin y parsearla a Date*/
	    Date fechaFin = (Date) campoFechaFin.getDate();
	    String fechaFinFormateada = formato.format(fechaFin);
	    	    
	    //Capturar el item del combobox seleccionado
	    String itemSeleccionado = (String) comboCategoria.getSelectedItem();
	    
	    //Instanciar evento
	    Evento evento = new Evento();
	    
	    evento.setNombre(campoNombreEvento.getText().toString());
	    evento.setFechaInicio(fechaIniciFormateada);
	    evento.setHoraInicio(java.sql.Time.valueOf(horaInicio1));
	    evento.setFechaFin(fechaFinFormateada);
	    evento.setHoraFin(java.sql.Time.valueOf(horaFin1));
	    evento.setDescripcion(campoDescripcion.getText().toString());
	    evento.setInfoSecundaria(campoInformacioSecundaria.getText().toString());
	    evento.setFotoMiniatura(campoImagenUri.getText().toString());
	    evento.setFotoPrincipal(campoImagenUri2.getText().toString());
	    evento.setIdCategoria(MetodosBaseDeDatos.consultarIdCategorias(itemSeleccionado));
	    evento.setIdLugar(MetodosBaseDeDatos.consultarIdLugar(campoLlocEvento.getText().toString()));
	    evento.setIdOrganizador(MetodosBaseDeDatos.consultarIdOrganizador(Login.nombre));
	    
	    MetodosBaseDeDatos.anyadirEvento(evento);
	    	   
	    resetearCampos();
		   
	    modelo.addRow(new Object[]{evento.getNombre()});
	   }   
	}
	
	if(e.getSource() == btnEliminar){
	    
	    String nombreEvento = (String) modelo.getValueAt(table_1.getSelectedRow(), 0);
	    modelo.removeRow(table_1.getSelectedRow());
	   
	    MetodosBaseDeDatos.eliminarEvento(nombreEvento);
	}
	
	if(e.getSource() == botonBuscar){
	    
	    campoImagenUri.setText("");
	    campoImagenUri.setEditable(true);
	    
	    try {
		 Desktop.getDesktop().browse(new URI("https://www.google.es/imghp?hl=es&tab=wi&ei=KH37WKUSwahSxqGU0AM&ved=0EKouCBUoAQ"));
	    } catch (IOException e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace();
	    } catch (URISyntaxException e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace();
	    }
	    
	}
	
	if(e.getSource() == botonBuscar2){
	    
	    campoImagenUri2.setText("");
	    campoImagenUri2.setEditable(true);
	    
	    try {
		 Desktop.getDesktop().browse(new URI("https://www.google.es/imghp?hl=es&tab=wi&ei=KH37WKUSwahSxqGU0AM&ved=0EKouCBUoAQ"));
	    } catch (IOException e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace();
	    } catch (URISyntaxException e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace();
	    }
	}
	
	if(e.getSource() == botonListo){
	    
	    campoImagenUri.setEditable(false);
	    try {
		imagenMiniatura.setIcon(cargarImagenMiniatura(campoImagenUri.getText().toString()));
		repaint();
		//imagenMiniatura.setIcon((Icon) new ImageIcon(new URL(campoImagenUri.getText().toString())).getImage());
	    } catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    
	}
	
	if(e.getSource() == botonListo2){
	    
	    campoImagenUri2.setEditable(false);
	    try {
		imagenPrincipal.setIcon(cargarImagenPrincipal(campoImagenUri2.getText().toString()));
				
		repaint();
		
	    } catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	}
	
    }
    
    public static ImageIcon cargarImagenMiniatura(String uriMiniatura) throws MalformedURLException{
	
	URL url = new URL(uriMiniatura);
	ImageIcon imagen = new ImageIcon(url);
	Image img = imagen.getImage().getScaledInstance(68, 99, Image.SCALE_AREA_AVERAGING);
	ImageIcon iconImage = new ImageIcon(img);
	
	return iconImage;
	
    }
    
    public static ImageIcon cargarImagenPrincipal(String uriPrincipal) throws MalformedURLException{
	
	URL url = new URL(uriPrincipal);
	ImageIcon imagen = new ImageIcon(url);
	Image img = imagen.getImage().getScaledInstance(175, 99, Image.SCALE_AREA_AVERAGING);
	ImageIcon iconImage = new ImageIcon(img);
	
	return iconImage;
    }
    
    public static Boolean comprobarCamposVacios(){
	
	Boolean camposVacios = true;
	
	if(campoNombreEvento.getText().toString().isEmpty() || campoLlocEvento.getText().toString().isEmpty()
		|| campoFechaInici.getDate().toString().isEmpty() || campoFechaFin.getDate().toString().isEmpty()
		|| campoHoraFin.getText().toString().isEmpty() || campoHoraInici.getText().toString().isEmpty()
		|| campoMinutoInici.getText().toString().isEmpty() || campoMinutoFin.getText().toString().isEmpty()
		|| comboCategoria.getSelectedItem().toString().isEmpty() || campoDescripcion.getText().toString().isEmpty()
		|| campoInformacioSecundaria.getText().toString().isEmpty() || campoImagenUri.getText().toString().isEmpty()
		|| campoImagenUri2.getText().toString().isEmpty() || imagenMiniatura.getIcon() == null || imagenPrincipal.getIcon() == null){
	    
	    camposVacios = true;
	}
	else{
	    camposVacios = false;
	}
	
	
	return camposVacios;
    }
    
    public static void resetearCampos(){
	
	    campoNombreEvento.setText("");
	    campoLlocEvento.setText("");
	    campoFechaInici.setDate(null);
	    campoFechaFin.setDate(null);
	    campoHoraInici.setText("");
	    campoMinutoInici.setText("");
	    campoHoraFin.setText("");
	    campoMinutoFin.setText("");
	    comboCategoria.setSelectedIndex(0);
	    campoDescripcion.setText("");
	    campoInformacioSecundaria.setText("");
	    campoImagenUri.setText("");
	    campoImagenUri2.setText("");
	    imagenMiniatura.setIcon(null);
	    imagenPrincipal.setIcon(null);
    }
    
    public static void dobleClickTable(){
	
	//Instancio un objeto de la clase Evento
	    Evento recuperarDatosEvento = new Evento();
	    
	    //Obtengo el nombre del evento seleccionado en la tabla
	    String nombreEvento = (String) modelo.getValueAt(table_1.getSelectedRow(), 0);
	    
	    //Invoco al método para obtener los campos de ese evento que selecciono
	    recuperarDatosEvento = MetodosBaseDeDatos.consultarEventoMarcado(nombreEvento);
	    
	    /*hora inici*/
	    StringTokenizer token = new StringTokenizer(String.valueOf(recuperarDatosEvento.getHoraInicio()), ":");
	    
	    String[]horaInici = new String[3];
	    while(token.hasMoreTokens()){
		horaInici[0] = token.nextToken();
		horaInici[1] = token.nextToken();
		horaInici[2] = token.nextToken();
	    }
	    
	    /*hora fin*/
	    StringTokenizer token2 = new StringTokenizer(String.valueOf(recuperarDatosEvento.getHoraFin()), ":");
	    
	    String[]horaFin = new String[3];
	    while(token2.hasMoreTokens()){
		horaFin[0] = token2.nextToken();
		horaFin[1] = token2.nextToken();
		horaFin[2] = token2.nextToken();
	    }
	    
	    Date fechaInici = null;
	    try {
		fechaInici = formato.parse(recuperarDatosEvento.getFechaInicio());
	    } catch (ParseException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	    }
	    
	    Date fechaFin = null;
	    try {
		fechaFin = formato.parse(recuperarDatosEvento.getFechaFin());
	    } catch (ParseException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	    }
	    
	    
	    campoNombreEvento.setText(recuperarDatosEvento.getNombre());
	    campoLlocEvento.setText(MetodosBaseDeDatos.consultarNombreLugar(recuperarDatosEvento.getIdLugar()));
	    campoFechaInici.setDate(fechaInici);
	    campoFechaFin.setDate(fechaFin);
	    campoHoraInici.setText(horaInici[0]);
	    campoMinutoInici.setText(horaInici[1]);
	    campoHoraFin.setText(horaFin[0]);
	    campoMinutoFin.setText(horaFin[1]);
	    comboCategoria.setSelectedIndex(recuperarDatosEvento.getIdCategoria() -1);
	    campoDescripcion.setText(recuperarDatosEvento.getDescripcion());
	    campoInformacioSecundaria.setText(recuperarDatosEvento.getInfoSecundaria());
	    campoImagenUri.setText(recuperarDatosEvento.getFotoMiniatura());
	    campoImagenUri2.setText(recuperarDatosEvento.getFotoPrincipal());
	    try {
		imagenMiniatura.setIcon(cargarImagenMiniatura(recuperarDatosEvento.getFotoMiniatura()));
	    } catch (MalformedURLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	    }
	    try {
		imagenPrincipal.setIcon(cargarImagenPrincipal(recuperarDatosEvento.getFotoPrincipal()));
	    } catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
    }
    //Metodo para mostrar los datos de la tabla
    public static void mostrarDatos(){
	
	for(int i = 0; i < MetodosBaseDeDatos.consultarNombreEventos().size(); i++){
		   
		   modelo.addRow(new Object[]{MetodosBaseDeDatos.consultarNombreEventos().get(i).toString()});
		   
		}
    }
}
