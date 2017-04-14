import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class PanelAfegirEvent extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PanelAfegirEvent frame = new PanelAfegirEvent();
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
    public PanelAfegirEvent() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1366, 768);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(65, 129, 190));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.setLayout(null);
	
	JLabel lblValenciaeventsnet = new JLabel("www.valenciaevents.net");
	lblValenciaeventsnet.setFont(new Font("Roboto Th", Font.PLAIN, 66));
	lblValenciaeventsnet.setForeground(Color.WHITE);
	lblValenciaeventsnet.setBounds(586, 628, 754, 90);
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
	
	JLabel label = new JLabel("");
	label.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label.setForeground(Color.WHITE);
	label.setBounds(99, 26, 210, 14);
	contentPane.add(label);
	
	JButton btnNewButton = new JButton("AFEGIR EVENT");
	btnNewButton.setBackground(Color.LIGHT_GRAY);
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnNewButton.setBounds(977, 34, 143, 43);
	contentPane.add(btnNewButton);
	
	JButton btnModificar = new JButton("MODIFICAR");
	btnModificar.setBackground(Color.LIGHT_GRAY);
	btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnModificar.setBounds(1144, 34, 134, 43);
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
	lblElsTeusEvents.setForeground(Color.WHITE);
	lblElsTeusEvents.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblElsTeusEvents.setBounds(82, 135, 134, 26);
	contentPane.add(lblElsTeusEvents);
	
	table = new JTable();
	table.setBounds(45, 172, 245, 436);
	contentPane.add(table);
	
	JLabel lblNomDelEvent = new JLabel("NOM DEL EVENT");
	lblNomDelEvent.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNomDelEvent.setForeground(Color.WHITE);
	lblNomDelEvent.setBounds(350, 170, 134, 14);
	contentPane.add(lblNomDelEvent);
	
	textField = new JTextField();
	textField.setBounds(350, 195, 180, 26);
	contentPane.add(textField);
	textField.setColumns(10);
	
	JLabel lblLlocDelEvent = new JLabel("LLOC DEL EVENT");
	lblLlocDelEvent.setForeground(Color.WHITE);
	lblLlocDelEvent.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblLlocDelEvent.setBounds(350, 244, 134, 14);
	contentPane.add(lblLlocDelEvent);
	
	textField_1 = new JTextField();
	textField_1.setBounds(350, 269, 180, 26);
	contentPane.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblData = new JLabel("DATA");
	lblData.setForeground(Color.WHITE);
	lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblData.setBounds(350, 316, 46, 14);
	contentPane.add(lblData);
	
	textField_2 = new JTextField();
	textField_2.setBounds(350, 341, 155, 34);
	contentPane.add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblHora = new JLabel("HORA");
	lblHora.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblHora.setForeground(Color.WHITE);
	lblHora.setBounds(533, 316, 46, 14);
	contentPane.add(lblHora);
	
	textField_3 = new JTextField();
	textField_3.setBounds(533, 341, 36, 34);
	contentPane.add(textField_3);
	textField_3.setColumns(10);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(586, 341, 36, 34);
	contentPane.add(textField_4);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.WHITE);
	separator_1.setBounds(574, 348, 5, 7);
	contentPane.add(separator_1);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setForeground(Color.WHITE);
	separator_2.setBounds(574, 366, 5, 7);
	contentPane.add(separator_2);
	
	JLabel lblCategoria = new JLabel("CATEGORIA");
	lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblCategoria.setForeground(Color.WHITE);
	lblCategoria.setBounds(350, 396, 96, 19);
	contentPane.add(lblCategoria);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(350, 426, 272, 34);
	contentPane.add(comboBox);
	
	JLabel lblDescripciPrincipal = new JLabel("DESCRIPCI\u00D3 PRINCIPAL");
	lblDescripciPrincipal.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblDescripciPrincipal.setForeground(Color.WHITE);
	lblDescripciPrincipal.setBounds(702, 170, 193, 14);
	contentPane.add(lblDescripciPrincipal);
	
	JTextArea textArea = new JTextArea();
	textArea.setBounds(702, 196, 261, 191);
	contentPane.add(textArea);
	
	JLabel lblInformaciSecundaria = new JLabel("INFORMACI\u00D3 SECUNDARIA");
	lblInformaciSecundaria.setForeground(Color.WHITE);
	lblInformaciSecundaria.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblInformaciSecundaria.setBounds(702, 398, 216, 14);
	contentPane.add(lblInformaciSecundaria);
	
	textField_5 = new JTextField();
	textField_5.setBounds(702, 426, 245, 34);
	contentPane.add(textField_5);
	textField_5.setColumns(10);
	
	JLabel lblMiniatura = new JLabel("MINIATURA");
	lblMiniatura.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblMiniatura.setForeground(Color.WHITE);
	lblMiniatura.setBounds(1074, 170, 90, 14);
	contentPane.add(lblMiniatura);
	
	JLabel lblImatgePrincipal = new JLabel("IMATGE PRINCIPAL");
	lblImatgePrincipal.setForeground(Color.WHITE);
	lblImatgePrincipal.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblImatgePrincipal.setBounds(1074, 272, 155, 14);
	contentPane.add(lblImatgePrincipal);
	
	JButton btnAfegirEvent = new JButton("AFEGIR EVENT");
	btnAfegirEvent.setBackground(Color.LIGHT_GRAY);
	btnAfegirEvent.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnAfegirEvent.setBounds(513, 532, 203, 57);
	contentPane.add(btnAfegirEvent);
	
	JButton btnEliminarEvent = new JButton("ELIMINAR EVENT");
	btnEliminarEvent.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnEliminarEvent.setBackground(Color.LIGHT_GRAY);
	btnEliminarEvent.setBounds(763, 532, 238, 57);
	contentPane.add(btnEliminarEvent);
    }
}
