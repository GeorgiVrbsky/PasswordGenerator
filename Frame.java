import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.swing.text.Caret;
import javax.swing.text.Highlighter;

public class Frame implements ActionListener {

    JFrame frame;

    JTextField textField;

    JCheckBox checkBoxUpper, checkBoxLower, checkBoxNumbers, checkBoxCharacters;

    JButton generate, copy;

    JPanel panel;

    JLabel label;

    Font myFont = new Font("Monospaced", Font.BOLD,17);
    Font buttonFont = new Font("Monospaced", Font.BOLD,25);


    Frame(){

        frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380,450);
        frame.setBackground(Color.gray);
        frame.setResizable(false);
        frame.setLayout(null);

        ImageIcon img = new ImageIcon("Icon.png");
        frame.setIconImage(img.getImage());

        textField = new RoundJTextField(15);
        textField.setBounds(25,25,300,60);
        textField.setEditable(false);
        textField.setCaretColor(Color.WHITE);
        textField.setCaretColor(Color.blue);

        checkBoxUpper = new JCheckBox("UpperCase");
        checkBoxLower = new JCheckBox("LowerCase");
        checkBoxNumbers = new JCheckBox("Numbers");
        checkBoxCharacters = new JCheckBox("Characters");

        checkBoxUpper.setFont(myFont);
        checkBoxLower.setFont(myFont);
        checkBoxNumbers.setFont(myFont);
        checkBoxCharacters.setFont(myFont);

        checkBoxUpper.addActionListener(this);
        checkBoxLower.addActionListener(this);
        checkBoxNumbers.addActionListener(this);
        checkBoxCharacters.addActionListener(this);

        checkBoxUpper.setBounds(115,100,130,35);
        checkBoxLower.setBounds(115,140,130,35);
        checkBoxNumbers.setBounds(115,180,130,35);
        checkBoxCharacters.setBounds(115,220,130,35);

        label = new JLabel();
        label.setLocation(25,25);
        label.setText("50");

        Slider slider = new Slider(this,0,100,50);

        panel = new JPanel();
        panel.add(slider);
        panel.setBounds(75,265,200,55);
        panel.add(label);

        copy = new JButton(new ImageIcon("C:\\Users\\gogov\\IdeaProjects\\PasswordGenerator\\src\\coppy.png"));
        copy.setBounds(330,25,30,60);

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        copy.addActionListener(ae -> {
            StringSelection selection = new StringSelection(textField.getText());
            clipboard.setContents(selection, null);
        });


        generate = new JButton("Generate");
        generate.setFont(buttonFont);
        generate.setBackground(Color.white);
        generate.addActionListener(this);
        generate.setFocusable(false);
        generate.setBounds(90,320,167,55);


        frame.add(checkBoxUpper);
        frame.add(checkBoxLower);
        frame.add(checkBoxNumbers);
        frame.add(checkBoxCharacters);
        frame.add(textField);
        frame.add(panel);
        frame.add(generate);
        frame.add(copy);
        frame.setVisible(true);

    }

    public void updateSliderValue(int sliderValue) {
        label.setText(String.valueOf(sliderValue));
    }

    public void actionPerformed(ActionEvent e) {
        random random = new random();
        if(checkBoxUpper.isSelected() || checkBoxLower.isSelected() || checkBoxNumbers.isSelected() || checkBoxCharacters.isSelected()) {
            if (e.getSource() == generate) {
                int n = Integer.parseInt(label.getText());
                textField.setText(random.Password_Generator(n, checkBoxUpper.isSelected(), checkBoxLower.isSelected(), checkBoxNumbers.isSelected(), checkBoxCharacters.isSelected()));
            }
        }

    }
}
