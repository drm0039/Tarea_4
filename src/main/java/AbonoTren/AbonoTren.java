package AbonoTren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AbonoTren {
    private JPanel VentanaPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JCheckBox aceptarTérminosYCondicionesCheckBox;
    private JButton recargarAbonoButton;
    private JButton cancelarButton;
    private JComboBox comboBox1;
    private JLabel Titulo;
    private JLabel NombreTitular;
    private JLabel NumeroDNI;
    private JLabel MesRecarga;
    private JLabel CantidadDinero;
    private JLabel MetodoPago;

    public AbonoTren() {
        recargarAbonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || !aceptarTérminosYCondicionesCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Completa todos los campos y acepta los términos.");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Recarga realizada con éxito para " + textField1.getText() + ".");
            }
        });

        ImageIcon icono = new ImageIcon(AbonoTren.class.getResource("/icono_tren.png"));
        Image imagen = icono.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        Titulo.setIcon(new ImageIcon(imagen));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AbonoTren");




        AbonoTren ventana = new AbonoTren();
        frame.setContentPane(ventana.VentanaPrincipal);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Confirmación al cerrar
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "¿Estás seguro de que quieres salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            }
        });
    }
}

