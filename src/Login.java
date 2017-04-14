import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.LoginActivity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuari;
	private JTextField txtContrasenya;
	private JButton btnNewButton;
	public static String nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		//setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 129, 190));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblValnciaEvents = new JLabel("VAL\u00C8NCIA EVENTS");
		lblValnciaEvents.setBounds(0, 47, 1360, 99);
		lblValnciaEvents.setFont(new Font("Bebas Neue", Font.PLAIN, 77));
		lblValnciaEvents.setForeground(Color.WHITE);
		lblValnciaEvents.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblValnciaEvents);
		JPanel panel = new JPanel();
		panel.setBounds(485, 157, 384, 354);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Accedir");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Th", Font.PLAIN, 72));
		lblNewLabel.setBounds(0, 21, 384, 63);
		panel.add(lblNewLabel);
		txtUsuari = new JTextField();
		txtUsuari.setForeground(SystemColor.activeCaptionBorder);
		txtUsuari.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuari.setFont(new Font("Roboto Lt", Font.ITALIC, 22));
		txtUsuari.setBounds(50, 113, 289, 41);
		panel.add(txtUsuari);
		txtUsuari.setColumns(10);
		txtContrasenya = new JTextField();
		txtContrasenya.setForeground(SystemColor.activeCaptionBorder);
		txtContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasenya.setFont(new Font("Roboto Lt", Font.ITALIC, 20));
		txtContrasenya.setBounds(50, 165, 289, 41);
		panel.add(txtContrasenya);
		txtContrasenya.setColumns(10);
		btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Roboto Bk", Font.PLAIN, 24));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(63, 127, 188));
		btnNewButton.setBounds(126, 227, 135, 48);
		panel.add(btnNewButton);
		JLabel lblVolsAfecgirEls = new JLabel("Vols afegir els teus esdeveniments? Registrat!");
		lblVolsAfecgirEls.setFont(new Font("Roboto Lt", Font.PLAIN, 15));
		lblVolsAfecgirEls.setForeground(Color.BLACK);
		lblVolsAfecgirEls.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolsAfecgirEls.setBounds(0, 313, 384, 30);
		panel.add(lblVolsAfecgirEls);
		
		JLabel lblValenciaeventsnet = new JLabel("www.valenciaevents.net");
		lblValenciaeventsnet.setFont(new Font("Roboto Th", Font.PLAIN, 66));
		lblValenciaeventsnet.setForeground(Color.WHITE);
		lblValenciaeventsnet.setBounds(572, 628, 778, 90);
		contentPane.add(lblValenciaeventsnet);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) {

		    nombre = LoginActivity.comprarLogin(txtUsuari.getText().toString(), txtContrasenya.getText().toString());
		    if(nombre != null){
			setVisible(false);
			
			PanelAfegirEvent panel = new PanelAfegirEvent();
			panel.setVisible(true);
		    }
		    else{
			setVisible(true);
		    }
		}

	}
}
