package lulu.gui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lulu.model.types.LuluType;

/**
 *
 * @author mdsinalpha
 */
public class LuluSymbolTableTreeRevealer extends Application {
    
    public static final String TITLE = "Symbol Table Tree Revealer";
    public static final String FXML_PATH = "LuluSymbolTableTreeRevealer.fxml";
    
    @FXML
    private TreeView tree;
    
    @FXML
    private TableView table;
    
    @Override
    public void start(Stage stage) throws Exception { 
        Parent root = FXMLLoader.load(getClass().getResource(FXML_PATH)); 
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(TITLE);
        stage.show();
    }
    
    private final ObservableList<LuluType> data =
            FXCollections.observableArrayList();
    
    public void reveal(ActionEvent e){
        
        TreeItem rootItem = new TreeItem("Vehicles");
        ArrayList<TreeItem> nest = new ArrayList<>();
        nest.add(new TreeItem("NEST"));
        ArrayList<TreeItem> products = new ArrayList<>();
        products.add(new TreeItem("My Car"));
        products.get(0).getChildren().addAll(nest);
        rootItem.getChildren().addAll(products);
        tree.setRoot(rootItem);
        
        
        TableColumn isConstCol = new TableColumn("Constant");
        isConstCol.setCellValueFactory(
                new PropertyValueFactory<>("isConst"));
        TableColumn offsetCol = new TableColumn("Offset");
        offsetCol.setCellValueFactory(
                new PropertyValueFactory<>("offset"));
        table.setItems(data);
        table.getColumns().clear();
        table.getColumns().addAll(isConstCol, offsetCol);
        
        
        
    }
   
    
    public static void main(String [] args){
        launch(args);
    }
    
}
