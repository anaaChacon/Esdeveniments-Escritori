import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Login extends JFrame implements ActionListener {

private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private JButton btnNewButton;

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
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 546, 320);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 153, 204));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblValnciaEvents = new JLabel("VAL\u00C8NCIA EVENTS");
lblValnciaEvents.setBounds(0, 5, 530, 39);
lblValnciaEvents.setFont(new Font("Bebas Neue", Font.PLAIN, 39));
lblValnciaEvents.setForeground(Color.WHITE);
lblValnciaEvents.setHorizontalAlignment(SwingConstants.CENTER);
contentPane.add(lblValnciaEvents);
JPanel panel = new JPanel();
panel.setBounds(144, 55, 245, 180);
contentPane.add(panel);
panel.setLayout(null);
JLabel lblNewLabel = new JLabel("Accedir");
lblNewLabel.setForeground(SystemColor.desktop);
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
lblNewLabel.setBounds(57, 0, 115, 35);
panel.add(lblNewLabel);
textField = new JTextField();
textField.setBounds(22, 40, 202, 20);
panel.add(textField);
textField.setColumns(10);
textField_1 = new JTextField();
textField_1.setBounds(22, 71, 202, 20);
panel.add(textField_1);
textField_1.setColumns(10);
btnNewButton = new JButton("ENTRAR");
btnNewButton.addActionListener(this);
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
btnNewButton.setForeground(Color.WHITE);
btnNewButton.setBackground(new Color(51, 153, 204));
btnNewButton.setBounds(64, 109, 108, 29);
panel.add(btnNewButton);
JLabel lblVolsAfecgirEls = new JLabel("Vols afegir els teus events? Registrat!");
lblVolsAfecgirEls.setForeground(SystemColor.windowBorder);
lblVolsAfecgirEls.setHorizontalAlignment(SwingConstants.CENTER);
lblVolsAfecgirEls.setBounds(22, 155, 202, 14);
panel.add(lblVolsAfecgirEls);
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if (e.getSource() == btnNewButton) {

setVisible(false);
Panel panel = new Panel();
panel.setVisible(true);
}

}
}
