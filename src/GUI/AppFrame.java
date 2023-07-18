package GUI;

import comp_decomp.compressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import comp_decomp.decompressor;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        setTitle("Compressor and Decompressor");
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f1=new Font(Font.SERIF,Font.BOLD,15);

        compressButton =new JButton("Select file to compress");
        compressButton.setFont(f1);
        compressButton.setBounds(300,100,200,30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setFont(f1);
        decompressButton.setBounds(300,150,200,30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setFont(f1);
        this.setSize(640,340);
       // this.getContentPane().setBackground(Color.CYAN);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
       JLabel background=new JLabel(new ImageIcon("C:\\Users\\91720\\Downloads\\tree-3358468_640.jpg"));
       this.add(background);
     background.setLayout(new FlowLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response= fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }

        if(e.getSource()==decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response= fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
