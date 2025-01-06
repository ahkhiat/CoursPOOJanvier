import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

    private JTextField tfNom, tfPrenom, tfAge;
    private String majorityStatus;
    private JFrame parent;

    public ButtonActionListener( JTextField tfNom, JTextField tfPrenom) {
        this.tfPrenom = tfPrenom;
        this.tfNom = tfNom;
    }

    public ButtonActionListener(JFrame parentFrame, JTextField tfNom, JTextField tfPrenom, JTextField tfAge) {
        this.tfPrenom = tfPrenom;
        this.tfNom = tfNom;
        this.tfAge = tfAge;
        this.parent = parentFrame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message;
        boolean isWarning;

        if(tfNom.getText().trim().isEmpty() || tfPrenom.getText().trim().isEmpty() || tfAge.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez rentrer tous les champs", "", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int age = Integer.parseInt(tfAge.getText().trim());
                this.majorityStatus = (age >= 18) ? "majeur" : "mineur";
                isWarning = false;
                message = "Bonjour " + tfPrenom.getText() + " " + tfNom.getText() +
                          ", tu es " + majorityStatus + " et tu as " + tfAge.getText() + " ans.";

            } catch (NumberFormatException nfe) {
                isWarning = true;
                message = "Veuillez entrer un age valide";
            }
            // Exercice 1
            // System.out.println("Bonjour " + tfPrenom.getText() + " " + tfNom.getText() + ", tu es " + tfMajorite + " , et tu as " + tfAge.getText() + " ans." );

            // Exercice 2 JOptionPane
//            JOptionPane.showMessageDialog(null, message, "", isWarning ? JOptionPane.WARNING_MESSAGE
//                                                                                            : JOptionPane.INFORMATION_MESSAGE);
            new MyCustomOptionPane(parent, "Bonjour " + tfPrenom.getText() + " " + tfNom.getText() + ", tu es " + majorityStatus + " , et tu as " + tfAge.getText() + " ans." );
        }

    }
}
