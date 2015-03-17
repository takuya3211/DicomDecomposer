import javax.swing.*;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.event.*;

public class JFileChooserTest2 extends JFrame implements ActionListener{

  JLabel label;
  static String targetPath ="";
  
  public static void doit(){
    JFileChooserTest2 frame = new JFileChooserTest2();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("�^�C�g��");
    frame.setVisible(true);
  }

  JFileChooserTest2(){
    JButton button = new JButton("file select");
    button.addActionListener(this);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(button);

    label = new JLabel();

    JPanel labelPanel = new JPanel();
    labelPanel.add(label);

    getContentPane().add(labelPanel, BorderLayout.CENTER);
    getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
  }

  public void actionPerformed(ActionEvent e){
    JFileChooser filechooser = new JFileChooser();
    int selected = filechooser.showOpenDialog(this);
    if (selected == JFileChooser.APPROVE_OPTION){
      File file = filechooser.getSelectedFile();
      label.setText(file.getAbsolutePath());
      targetPath = file.getAbsolutePath().toString();
    }else if (selected == JFileChooser.CANCEL_OPTION){
      label.setText("�L�����Z������܂���");
    }else if (selected == JFileChooser.ERROR_OPTION){
      label.setText("�G���[���͎����������܂���");
    }
  }
  
  public String getPath() {
	    return targetPath;
  }
}
