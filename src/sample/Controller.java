package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Controller {
    private static final int MAX_FILES = 0;
    public Button Create;
    private Object File;
    public  ListView ListView;
    public TreeView TreeView;




    public  void  s(){
       File listFile = new File("c:/");
       File exportFiles[] = listFile.listFiles();
       String[] names = new String[exportFiles.length];
       for(int i = 0; i < names.length; i++){
           names[i] = exportFiles[i].getName();
       }
   }
    int filesCount = 0;
    double folderSize = 0;
    public void getFilesDetails(String location) throws NoSuchAlgorithmException, IOException {
        File directory = new File(location);
        File[] files = directory.listFiles();
        if (files!=null) {
            for (File f : files) {
                if (f.isFile()) {
                    filesCount++;
                    folderSize += f.length();
                } else if (f.isDirectory()) {
                    getFilesDetails(f.getAbsolutePath());
                }
            }
        }
    }

    public static int getFilesCount() throws IOException, NotDirectoryException {
        Path dir = Paths.get("D:\\MY_FOLDER");
        int c = 0;
        if(Files.isDirectory(dir)) {
            try(DirectoryStream<Path> files = Files.newDirectoryStream(dir)) {
                for(Path file : files) {
                    if(Files.isRegularFile(file) || Files.isSymbolicLink(file)) {
                        c++;
                    }
                }
            }
        }
        else
            throw new NotDirectoryException(dir + " is not directory");

        return c;
    }



    public static int noOfFilesInDirectory(File directory) {

        int noOfFiles = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                noOfFiles++;
            }
            if (file.isDirectory()) {
                noOfFiles += noOfFilesInDirectory(file);
            }
        }
        return noOfFiles;
    }


    public boolean isOverMax(){
        Path dir = Paths.get("E:\\MY_FOLDER");
        int i = 1;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path p : stream) {
                //larger than max files, exit
                if (++i > MAX_FILES) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    public void onCreate(ActionEvent actionEvent) throws NoSuchAlgorithmException, IOException {

        File file = new File("D:\\MY_FOLDER");
        String a = String.valueOf(String.format(file.getName()));
        String a1 = String.valueOf(String.format(file.getPath()));
        String a2 = String.valueOf(String.format(String.valueOf(file.length())));
        Path p = file.toPath();
        BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
        long list = new File("D:\\MY_FOLDER").listFiles().length;

        //new File(String.valueOf(file)).list();
        // определяем объект для каталога
        File dir = new File("D:\\");
        // если объект представляет каталог
        if(dir.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : dir.listFiles()){

                if(item.isDirectory()){


                //    String s = item.getName() + "  \t folder";
                 //  ObservableList<String> langs = FXCollections.observableArrayList(s);
                //   ListView<String> langsListView = new ListView<String>(langs);
                //   listview.setItems(langs);

                }
                else{


                    int count = 0;
                    File exportFiles[] = dir.listFiles();
                    String[] names = new String[exportFiles.length];
                    for(int i = 0; i < names.length; i++){
                        count++;
                        names[i] = exportFiles[i].getName();

                    }
                    System.out.println("sdfs" + count);

                 //   System.out.println(item.getName() + "\t file");
                  //  String s1 = item.getName() + "\t file";
                 //   ObservableList<String> langs = FXCollections.observableArrayList(s1);
                //    ListView<String> langsListView = new ListView<String>(langs);
                //    listview.setItems(langs);
                //    listview.setOrientation(Orientation.VERTICAL);
                }
                System.out.println(item.getName() );
              //  String s1 = item.getName()  ;
                String s1 = String.valueOf(String.format(item.getName()));
                ObservableList<String> names = FXCollections.observableArrayList("sdfsfs", "1");
                ListView<String> listView = new ListView<String>(names);
                 ListView.setItems(names);
             //   ListView.setOrientation(Orientation.VERTICAL);

                // Определение директории
             //   File dirs = new File(".");
                // Чтение полного списка файлов каталога
              //  File[] lst1 = dirs.listFiles();
                // Чтение списка файлов каталога
                // с расширениями "png" и "jpg"

               // System.out.println ("lst1.length = " + lst1.length);



            }
        }


        //Path dir = null;
        JOptionPane.showMessageDialog(null,"\nНазвание: " + a
                + "\nПуть: " + a1
                + "\nРазмер: " + a2 + " байт"
                + "\nДата создания: " + attr.creationTime()
                        + "\nОБщее количество: " + list
                +"\n00" + getFilesCount()
            //    + "\ncount  " + filesCount
             //   + "\nsize  " + folderSize
           //     + getFilesCount(dir)
          //      + noOfFilesInDirectory((java.io.File) File)


        );
        /*
        File file = new File("E:\\MY_LOLFOLDER\\notes.txt");
        String a = String.valueOf(String.format(file.getName()));
        String a1 = String.valueOf(String.format(file.getPath()));
        Path p = file.toPath();
        BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
        String a2 = String.valueOf(String.format(String.valueOf(file.length())));
        String a3 = String.valueOf(String.format(String.valueOf(file.lastModified())));
        JOptionPane.showMessageDialog(null,"\nНазвание файла " + a
                + "\nПуть к  файлу " + a1
                + "\nРазмер файла " + a2 + " байт"
                + "\nДата создания " + attr.creationTime()
                + "\nПоследние изменения " + a3
                + "\nВремя последней модификации " + attr.lastModifiedTime()
                + "\nВремя последнего доступа " + attr.lastAccessTime()

        );

         */

    }





    /*
    public static void recursiveDelete(File file) {
        // до конца рекурсивного цикла
        if (!file.exists())
            return;

        //если это папка, то идем внутрь этой папки и вызываем рекурсивное удаление всего, что там есть
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                // рекурсивный вызов
                recursiveDelete(f);
            }
        }
        // вызываем метод delete() для удаления файлов и пустых(!) папок
        file.delete();
        System.out.println("Удаленный файл или папка: " + file.getAbsolutePath());
    }
     */
    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onNew(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Новая вкладка");
        stage.setScene(new Scene(root, 450, 450));
        stage.showAndWait();
    }

    public void onExplore(ActionEvent actionEvent) throws IOException {
        try {
           Desktop.getDesktop().open(new File("C:\\Program Files\\Internet Explorer\\iexplore.exe"));
          //  Desktop.getDesktop().open(new File("C:\\Users\\Vlads\\Desktop\\2.txt"));
        }
        catch (Exception ee) {
            JOptionPane.showMessageDialog(null,"Файл не найден");
        }

    }

    public void onBack(ActionEvent actionEvent) {

    }

    public void onForward(ActionEvent actionEvent) {

    }
    public void onUp(ActionEvent actionEvent) {

    }

    public void onCreateFolders(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample2.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("");
        stage.setScene(new Scene(root, 200, 120));
        stage.showAndWait();
    }
    public void onCreateFiles(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample3.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("");
        stage.setScene(new Scene(root, 250, 130));
        stage.showAndWait();
    }

    public void onRenameFolders(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample4.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("");
        stage.setScene(new Scene(root, 250, 130));
        stage.showAndWait();
    }
    public void onRenameFiles(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample5.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("");
        stage.setScene(new Scene(root, 250, 130));
        stage.showAndWait();
    }

    public void onFolderInformation(ActionEvent actionEvent) {

    }
    //метод определения расширения файла
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".")+1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

    public void onFileInfo(ActionEvent actionEvent) throws IOException {
        File file = new File("E:\\MY_FOLDERS\\notes.txt");
        String name = String.valueOf(String.format(file.getName()));
        String path = String.valueOf(String.format(file.getPath()));
        Path p = file.toPath();
        BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
     //   String length = String.valueOf(String.format(String.valueOf(file.length())));
       // String a3 = String.valueOf(String.format(String.valueOf(file.lastModified())));
        long length = file.length();
        long timestamp = file.lastModified();

        JOptionPane.showMessageDialog(null,"\nНазвание файла " + name
                + "\nПуть к  файлу " + path
                + "\nРазмер файла " + length + " байт"
                + "\nДата создания " + attr.creationTime()
                + "\nПоследние изменения " + new Date(timestamp)
                + "\nВремя последней модификации " + attr.lastModifiedTime()
                + "\nВремя последнего доступа " + attr.lastAccessTime()
                + "\nРасширение файла: " + getFileExtension(file)

        );

    }

    public void onCopy(ActionEvent actionEvent) {

    }

    public void onEmbed(ActionEvent actionEvent) {

    }



    public void onDeleteFolder(ActionEvent actionEvent) {
        File file = new File("E:\\MY_FOLDER\\");
        deleteDirectory(file);
    }
    public static void deleteDirectory(File dir) {
        //если это папка, то идем внутрь этой папки
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                File f = new File(dir, children[i]);
                deleteDirectory(f);
            }
            dir.delete();
        } else dir.delete();
    }
    public void onDeleteFile(ActionEvent actionEvent) {
        File newDir = new File("E:\\MY_LOLFOLDER\\Hello.txt");
        newDir.delete();

    }

    public void onRefresh(ActionEvent actionEvent) {

    }

    public void onListView(ListView.EditEvent editEvent) {


    }
}
