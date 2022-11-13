package vsu.cs.vega;

import javax.swing.*;

public class FrameMain extends JFrame  {
    private JTextField textField1;
    private JPanel panelMain;

    public FrameMain() {
        this.setTitle("Calc");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

//        buttonCalc.addActionListener(e -> {
//            try {
//                double a = Double.parseDouble(textFieldA.getText());
//                double b = Double.parseDouble(textFieldB.getText());
//                double c = sum(a, b);
//                textFieldC.setText(String.format("%s", c));
//            } catch (Exception err) {
//                JOptionPane.showMessageDialog(null, "Некорректные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
//            }
//        });
    }
}
