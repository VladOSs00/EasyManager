package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Controller3 {


    public  TextField txtlabel;
    public KeyEvent e;

    public void onCreateFiles(ActionEvent actionEvent) throws IOException {

        String a = String.valueOf(String.format(txtlabel.getText()));
        File file = new File("C:\\1\\", a);
        String text = txtlabel.getText();
        if(text.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Введите название файла");
        }
        else
        {
            if (file.createNewFile()){
                JOptionPane.showMessageDialog(null,"Файл " + a + " создан");
            }else{
                JOptionPane.showMessageDialog(null,"Файл " + a + " уже существует");
            }
        }

    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() != KeyEvent.VK_ENTER)
        {
            /*
            try {
                String a = String.valueOf(String.format(txtlabel.getText()));;
                //  File file = new File("C:\\", a );
                File file = new File("C:\\1\\", a);
                if (file.createNewFile()){
                    JOptionPane.showMessageDialog(null,"File created");
                }else{
                    JOptionPane.showMessageDialog(null,"File already exists.");
                }
            }

            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
            */
            JOptionPane.showMessageDialog(null,"Hello!");

            System.out.println("ENTER pressed");

        }
    }


}
