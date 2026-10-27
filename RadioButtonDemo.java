import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RadioButtonDemo extends JFrame {
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;

    public RadioButtonDemo() {
        setTitle("Pet Selection Demo - RadioButtonDemo");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        add(radioPanel, BorderLayout.WEST);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setBorder(BorderFactory.createTitledBorder("Pet Display Area"));
        
        pigButton.setSelected(true);
        updatePetDisplay("Pig", "Pig.jpg");

        add(imageLabel, BorderLayout.CENTER);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String petName = "";
                String fileName = "";

                if (birdButton.isSelected()) {
                    petName = "Bird";
                    fileName = "Bird.jpg";
                } else if (catButton.isSelected()) {
                    petName = "Cat";
                    fileName = "Cat.jpg";
                } else if (dogButton.isSelected()) {
                    petName = "Dog";
                    fileName = "Dog.jpg";
                } else if (rabbitButton.isSelected()) {
                    petName = "Rabbit";
                    fileName = "Rabbit.jpg";
                } else if (pigButton.isSelected()) {
                    petName = "Pig";
                    fileName = "Pig.jpg";
                }

                updatePetDisplay(petName, fileName);
                
                JOptionPane.showMessageDialog(RadioButtonDemo.this, 
                        "You selected: " + petName, 
                        "Selection Notice", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        };

        birdButton.addActionListener(listener);
        catButton.addActionListener(listener);
        dogButton.addActionListener(listener);
        rabbitButton.addActionListener(listener);
        pigButton.addActionListener(listener);
    }

    private void updatePetDisplay(String petName, String fileName) {
        String path = "images/" + fileName;
        File imageFile = new File(path);

        if (imageFile.exists()) {
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
            imageLabel.setText(""); 
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("Missing image: " + fileName);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RadioButtonDemo().setVisible(true);
            }
        });
    }
}