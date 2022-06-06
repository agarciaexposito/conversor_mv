package vista;

import Helpers.Auxiliar;
import modelo.ConversorEuros;
import modelo.ConversorEurosPesetas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FEurosPesetas extends JFrame {
    private ConversorEuros conversor=new ConversorEurosPesetas();
    private JTextField eCantidad = new JTextField("0",8);{
        eCantidad.setHorizontalAlignment(JTextField.RIGHT);
    }
    private JPanel pNorte = new JPanel(new GridLayout());{
        pNorte.setBorder(new EmptyBorder(10,10,10,10));
        pNorte.add(eCantidad);
    }
    private JTextField eResultado = new JTextField("Indique una cantidad y pulse uno de los botones");{
        eResultado.setEnabled(false);
        eResultado.setHorizontalAlignment(JTextField.CENTER);
    }
    private JPanel pCentro = new JPanel(new GridLayout());{
        pCentro.setBorder(new EmptyBorder(10,10,10,10));
        pCentro.add(eResultado);
    }

    private JButton convertirApesetas = new JButton("A Pesetas");{
        convertirApesetas.setMnemonic('P');
        convertirApesetas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Auxiliar.isDouble(eCantidad.getText())) {
                    double cantidad = Double.parseDouble(eCantidad.getText());
                    eResultado.setText(String.format("%.2f euros son %.2f pesetas",
                            cantidad,
                            conversor.eurosAmoneda(cantidad)));
                }
                else eResultado.setText("Error, formato del número (99.99)");
            }
        });
    }

    private JButton convertirAeuros = new JButton("A Euros");{
        convertirAeuros.setMnemonic('E');
        convertirAeuros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Auxiliar.isDouble(eCantidad.getText())) {
                    double cantidad = Double.parseDouble(eCantidad.getText());
                    eResultado.setText(String.format("%f pesetas son %.2f euros",
                        cantidad,
                        conversor.monedaAeuros(cantidad) ));
                }
                else eResultado.setText("Error, formato del número (99.99)");
            }
        });
    }
    private JPanel pSur = new JPanel();{
        pSur.add(convertirApesetas);
        pSur.add(convertirAeuros);
    }
    private JPanel pMain = new JPanel(new BorderLayout(10, 10));{
        pMain.add(pNorte, BorderLayout.NORTH);
        pMain.add(pCentro, BorderLayout.CENTER);
        pMain.add(pSur, BorderLayout.SOUTH);
    }
    public FEurosPesetas() {
        super("Conversor de Euros y Pesetas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().add(pMain);
        pack();// coloca los componentes
        setLocationRelativeTo(null);
    }
}
