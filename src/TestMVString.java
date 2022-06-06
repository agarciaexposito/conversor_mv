
import vista.FEurosPesetas;

import javax.swing.*;

public class TestMVString {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                flatDark();
                new FEurosPesetas().setVisible(true);
            }
        });
    }

    private static void flatDark() {
        try {
            UIManager.setLookAndFeel ("com.formdev.flatlaf.FlatDarkLaf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
