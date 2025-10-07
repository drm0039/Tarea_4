package AbonoTren;

import javax.swing.*;

public class AbonoTren {
    private JPanel VentanaPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JCheckBox aceptarTérminosYCondicionesCheckBox;
    private JButton recargarAbonoButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AbonoTren");
        frame.setContentPane(new AbonoTren().VentanaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);

    }
}
