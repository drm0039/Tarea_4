package AbonoBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class abonoBus extends JFrame {

    private JButton btnRecargar;
    private JComboBox<String> comboMeses;
    private JTextField txtImporte;

    private final String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    public abonoBus() {
        setTitle("Recarga de Abono Bus");
        setSize(400, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Color de fondo verde pastel
        Color fondoVerdePastel = new Color(204, 255, 204);
        getContentPane().setBackground(fondoVerdePastel);

        // ---------------- PANEL SUPERIOR: TÍTULO + LOGO ----------------
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBackground(fondoVerdePastel);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título (encima del logo)
        JLabel lblTitulo = new JLabel("Abono de Autobús");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setForeground(new Color(0, 100, 0)); // verde más oscuro para contraste
        panelSuperior.add(lblTitulo);

        // Espacio entre título y logo
        panelSuperior.add(Box.createRigidArea(new Dimension(0, 8)));

        // Logo con proporción mantenida
        JLabel lblLogo = new JLabel();
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        String rutaLogo = "C:\\Users\\Usuario1\\IdeaProjects\\Tarea_4\\src\\main\\resources\\autocares-casal.png";
        ImageIcon iconoOriginal = new ImageIcon(rutaLogo);

        int anchoOriginal = iconoOriginal.getIconWidth();  // 1200
        int altoOriginal = iconoOriginal.getIconHeight();  // 630

        int maxAncho = 300;
        int maxAlto = 160;

        double ratio = Math.min((double) maxAncho / anchoOriginal, (double) maxAlto / altoOriginal);
        int nuevoAncho = (int) (anchoOriginal * ratio);
        int nuevoAlto = (int) (altoOriginal * ratio);

        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(imagenEscalada));
        panelSuperior.add(lblLogo);

        add(panelSuperior, BorderLayout.NORTH);

        // ---------------- PANEL CENTRAL ----------------
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(fondoVerdePastel);
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblInstruccion = new JLabel("Seleccione el mes para recargar su abono:");
        lblInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
        lblInstruccion.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelCentral.add(lblInstruccion, gbc);

        comboMeses = new JComboBox<>(meses);
        gbc.gridy = 1;
        panelCentral.add(comboMeses, gbc);

        JLabel lblImporte = new JLabel("Ingrese el importe a abonar:");
        lblImporte.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelCentral.add(lblImporte, gbc);

        txtImporte = new JTextField();
        gbc.gridx = 1;
        panelCentral.add(txtImporte, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // ---------------- BOTÓN ----------------
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(fondoVerdePastel);
        btnRecargar = new JButton("Recargar Abono");
        btnRecargar.setPreferredSize(new Dimension(150, 35));
        panelBoton.add(btnRecargar);
        add(panelBoton, BorderLayout.SOUTH);

        // ---------------- ACCIONES ----------------
        btnRecargar.addActionListener(e -> {
            String mesSeleccionado = (String) comboMeses.getSelectedItem();
            String importe = txtImporte.getText().trim();

            if (importe.isEmpty()) {
                JOptionPane.showMessageDialog(abonoBus.this,
                        "Por favor, ingrese un importe válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(abonoBus.this,
                    "Su abono de transporte ha sido recargado para el mes de: " + mesSeleccionado +
                            "\nImporte abonado: " + importe,
                    "Recarga Exitosa", JOptionPane.INFORMATION_MESSAGE);
        });

        // Confirmación al cerrar ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        abonoBus.this,
                        "¿Está seguro de que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (opcion == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(abonoBus::new);
    }
}
