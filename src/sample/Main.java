package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    public  ListView ListView;
    public TreeView TreeView;
    @Override
    public void start(Stage primaryStage) throws Exception{

        File dir = new File("D:\\");
        TreeItem rootItem = new TreeItem("Tutorials");

        TreeItem webItem = new TreeItem(dir);
        webItem.setExpanded(true);

        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {

                } else {

                }
                TreeItem<String> items = new TreeItem<String>("" + item);
                webItem.getChildren().addAll(items);
            }
        }

        TreeView<String> tree = new TreeView<String>(webItem);
        rootItem.getChildren().add(webItem);
        TreeView treeView = new TreeView();
        treeView.setRoot(rootItem);
        treeView.setShowRoot(false);
        VBox vbox = new VBox(treeView);
        Scene scene = new Scene(vbox);
         primaryStage.setScene(scene);
          primaryStage.show();




        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Easy Manager");




       // primaryStage.setScene(new Scene(root, 500, 500));
       // primaryStage.show();
// primaryStage.show();
       // MenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        File file = new File("D:\\");

        // check if the specified pathname is directory first
        if(file.isDirectory()){
            //list all files on directory
            File[] files = file.listFiles();
            for(File f:files){
                try {
                    System.out.println(f.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        File[] paths;
        paths = File.listRoots();

          try {
              for(File path:paths)  {
                  System.out.println(path.getAbsolutePath());
              }
          }
          catch(Exception e) {
              // if any error occurs
              e.printStackTrace();
          }





    }

    public  void  ss() {


    }

    public static void main(String[] args) {
        launch(args);
    }
}
