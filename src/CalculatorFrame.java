import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener{

    private JPanel mainPanel, screenPanel, interPanel;

    // ne pas faire d'instanciation dans les variables d'instance
    private JTextField screenField = new JTextField();

    private StringBuilder calcul = new StringBuilder();

    private String x = "";
    private String y = "";
    private String operator;
    private double result;


    public CalculatorFrame(String title) {
        super(title);
        initializeComponents();
        screenPanel.setSize(350, 100);
        createInterPanel();
        configureMainPanel();
        configureFrame();
    }

    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        screenPanel = new JPanel(new BorderLayout());
        interPanel = new MyCustomGreyPanel(Color.GRAY);
        interPanel.setLayout(new GridLayout(4, 4));

        screenField.setPreferredSize(new Dimension(300, 50));
        screenField.setHorizontalAlignment(JTextField.RIGHT);
//        screenField.setEditable(false);

        screenPanel.add(screenField, BorderLayout.CENTER);
    }

    private void createInterPanel() {
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn0 = new JButton("0");
        JButton btnSom = new JButton("+");
        JButton btnSous = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");
        JButton btnClear = new JButton("C");
        JButton btnEgal = new JButton("=");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnSom.addActionListener(this);
        btnSous.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnEgal.addActionListener(this);
        btnClear.addActionListener(this);

        interPanel.add(btn1);
        interPanel.add(btn2);
        interPanel.add(btn3);
        interPanel.add(btnSom);

        interPanel.add(btn4);
        interPanel.add(btn5);
        interPanel.add(btn6);
        interPanel.add(btnSous);

        interPanel.add(btn7);
        interPanel.add(btn8);
        interPanel.add(btn9);
        interPanel.add(btnMul);

        interPanel.add(btnClear);
        interPanel.add(btn0);
        interPanel.add(btnEgal);
        interPanel.add(btnDiv);
    }

    private void configureMainPanel() {
        mainPanel.add(interPanel, BorderLayout.CENTER);
        mainPanel.add(screenPanel, BorderLayout.NORTH);
        setContentPane(mainPanel);
    }

    public void configureFrame() {
        setSize(350, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String currentScreen = screenField.getText();

        screenField.setText(currentScreen + command);

        if(command.matches("\\d")) {
            calcul.append(command);
            if (operator == null) {
                x += command;
            } else {
                y += command;
            }
            System.out.println("x : " + x + ", y : " + y);
        } else if (command.matches("[+\\-*/]")){
            if (!x.isEmpty()) {
                calcul.append(command);
                operator = command;
            } else {
                System.out.println("Veuillez saisir un nombre avant l'opérateur.");
            }
        } else if (command.equals("=")) {
            screenField.setText("");
            System.out.println("calcul 1 : " + calcul);
            System.out.println("operateur : " + operator);

            try {
                double result = calculate(Double.parseDouble(x), Double.parseDouble(y), operator);
                resetCalculator();
                if (result == (long) result) {
                    screenField.setText(String.valueOf((long) result));
                } else {
                    screenField.setText(String.format("%.2f", result));
                }
            } catch (IllegalArgumentException iae) {
                screenField.setText("∞");
            }

        } else if (command.equals("C")) {
            resetCalculator();
        }

    }

    private void resetCalculator() {
        screenField.setText("");
        calcul.setLength(0);
        x = "";
        y = "";
        operator = null;
    }

    private double calculate(double x, double y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                if (y != 0) {
                    return x / y;
                } else {
                    throw new IllegalArgumentException("Division par zéro n'est pas autorisée.");
                }
            default:
                throw new IllegalArgumentException("Opérateur inconnu : " + operator);
        }
    }

}

