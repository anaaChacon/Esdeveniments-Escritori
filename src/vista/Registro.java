package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controlador.MetodosBaseDeDatos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Registro extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JButton btnNewButton, btnCancelar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Registro frame = new Registro();
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
    public Registro() {
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1366, 768);
	ImageIcon logoV = new ImageIcon("./imagenes/login.png");
	Image logo = logoV.getImage();
	setIconImage(logo);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(null);
	contentPane.setBackground(new Color(65, 129, 190));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	textField = new JTextField();
	textField.setBounds(641, 184, 275, 36);
	textField.setForeground(SystemColor.activeCaptionBorder);
	textField.setHorizontalAlignment(SwingConstants.CENTER);
	textField.setFont(new Font("Roboto Lt", Font.ITALIC, 22));
	contentPane.add(textField);
	textField.setColumns(20);
	
	textField_1 = new JPasswordField();
	textField_1.setBounds(641, 231, 275, 36);
	textField_1.setForeground(SystemColor.activeCaptionBorder);
	textField_1.setHorizontalAlignment(SwingConstants.CENTER);
	textField_1.setFont(new Font("Roboto Lt", Font.ITALIC, 22));
	contentPane.add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setBounds(641, 278, 275, 36);
	textField_2.setForeground(SystemColor.activeCaptionBorder);
	textField_2.setHorizontalAlignment(SwingConstants.CENTER);
	textField_2.setFont(new Font("Roboto Lt", Font.ITALIC, 22));
	contentPane.add(textField_2);
	textField_2.setColumns(20);
	
	textField_3 = new JTextField();
	textField_3.setBounds(641, 325, 275, 36);
	textField_3.setForeground(SystemColor.activeCaptionBorder);
	textField_3.setHorizontalAlignment(SwingConstants.CENTER);
	textField_3.setFont(new Font("Roboto Lt", Font.ITALIC, 22));
	contentPane.add(textField_3);
	textField_3.setColumns(20);
	
	textField_4 = new JTextField();
	textField_4.setBounds(641, 372, 275, 39);
	textField_4.setForeground(SystemColor.activeCaptionBorder);
	textField_4.setHorizontalAlignment(SwingConstants.CENTER);
	textField_4.setFont(new Font("Roboto Lt", Font.ITALIC, 22));
	contentPane.add(textField_4);
	textField_4.setColumns(20);
	
	textField_5 = new JTextField();
	textField_5.setBounds(641, 422, 275, 36);
	textField_5.setForeground(SystemColor.activeCaptionBorder);
	textField_5.setHorizontalAlignment(SwingConstants.CENTER);
	textField_5.setFont(new Font("Roboto Lt", Font.ITALIC, 22));
	contentPane.add(textField_5);
	textField_5.setColumns(20);
	
	JLabel lblNewLabel = new JLabel("Usuario");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
	lblNewLabel.setBounds(447, 184, 115, 30);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
	lblNewLabel_1.setBounds(447, 231, 115, 36);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Nombre");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
	lblNewLabel_2.setBounds(447, 278, 115, 36);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("NIF");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
	lblNewLabel_3.setBounds(447, 325, 115, 36);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 19));
	lblNewLabel_4.setBounds(447, 372, 115, 39);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Email");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 19));
	lblNewLabel_5.setBounds(447, 422, 115, 36);
	contentPane.add(lblNewLabel_5);
	
	btnNewButton = new JButton("ACEPTAR");
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnNewButton.setBounds(570, 541, 146, 52);
	btnNewButton.setForeground(new Color(63, 127, 188));
	btnNewButton.addActionListener(this);
	contentPane.add(btnNewButton);
	
	JLabel lblNewLabel_6 = new JLabel("FORMULARIO DE REGISTRO");
	lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_6.setForeground(Color.WHITE);
	lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblNewLabel_6.setBounds(10, 37, 1340, 66);
	contentPane.add(lblNewLabel_6);
	
	btnCancelar = new JButton("CANCELAR");
	btnCancelar.setForeground(new Color(63, 127, 188));
	btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnCancelar.setBackground(Color.WHITE);
	btnCancelar.setBounds(823, 541, 146, 52);
	btnCancelar.addActionListener(this);
	contentPane.add(btnCancelar);
	setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource() == btnNewButton){
	    char[]arrayC = textField_1.getPassword();
	    String contra = new String(arrayC);
	    
	    if(textField.getText().toString().isEmpty() || contra.isEmpty() || textField_2.getText().toString().isEmpty() ||
		   textField_3.getText().toString().isEmpty() || textField_4.getText().toString().isEmpty() || textField_5.getText().toString().isEmpty()){
		JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    }else{
		//Comprobar con la base de datos si ya hay un usuario con esos datos
		boolean registro = MetodosBaseDeDatos.comprobarRegistro(textField.getText().toString(),contra, textField_2.getText().toString(), textField_3.getText().toString(), textField_4.getText().toString(), textField_5.getText().toString());
		
		if(registro){
		    setVisible(false);
		    Login login = new Login();
		    
		    login.txtUsuari.setText(textField.getText().toString());
		    login.txtContrasenya.setText(contra);
		    
		    login.setVisible(true);
		}
		
	    }
	}
	if(arg0.getSource() == btnCancelar){
	    setVisible(false);
	    new Login().setVisible(true);
	}
    }
}
