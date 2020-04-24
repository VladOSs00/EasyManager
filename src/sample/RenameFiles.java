package sample;

import javafx.event.ActionEvent;

import java.io.File;

public class RenameFiles {
    public void onRenameFiles(ActionEvent actionEvent) {
        File file = new File("E:\\MY_FOLDERS\\notes.txt");
        File newDir = new File("E:\\MY_FOLDERS\\Hello.txt");
        file.renameTo(newDir );
    }
}
