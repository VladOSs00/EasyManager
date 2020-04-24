package sample;

import javafx.event.ActionEvent;

import java.io.File;

public class RenameFolder {
    public void onRenameFolder(ActionEvent actionEvent) {
        File file = new File("E:\\MY_LOLFOLDER");
        // переименуем каталог
        File newDir  = new File("E:\\MY_FOLDERS");
        file.renameTo(newDir );
    }
}
