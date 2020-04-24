package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.File;

public class Controller2 {

    @FXML
    public TextField txtlabel;

    public void onCreateFolder(ActionEvent actionEvent) {
        String a = String.valueOf(String.format(txtlabel.getText()));
        File file = new File("C:", a );
        String text = txtlabel.getText();
        if(text.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Введите название папки");
        }
        else
        {
            if (!file.isDirectory())
            {
                file.mkdir();
                JOptionPane.showMessageDialog(null,"Папка " + a + " создана");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Папка " + a + " уже существует");
            }

        }

    }
}







