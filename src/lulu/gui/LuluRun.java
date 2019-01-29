package lulu.gui;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import lulu.LuluMiniatureCodeGenerator;
import lulu.LuluSemanticAnalyzer;
import lulu.model.LuluEntry;
import lulu.parser.LuluLexer;
import lulu.parser.LuluParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author mdsinalpha
 */
public class LuluRun extends Application {
    
    public static final String TITLE = "Symbol Table Tree Revealer";
    public static final String FXML_PATH = "LuluRun.fxml";
    
    @FXML
    private TreeView tree;
    
    @FXML
    private TableView table;
    
    @Override
    public void start(Stage stage) throws Exception{ 
        Parent root = FXMLLoader.load(getClass().getResource(FXML_PATH)); 
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(TITLE);
        stage.show();
    }
    
    public static TreeItem rootItem = new TreeItem("LULU");
    public static Map<TreeItem, MultiMap<String, LuluEntry>> scopeDataMap = new HashMap<>();
    
    public void reveal(ActionEvent e){
        
        /* This function reveals a gui tree of program scopes that each scope
           has it's symbol table shown inside a gui table. */
        
        /*
        TreeItem rootItem = new TreeItem("Street");
        ArrayList<TreeItem> nest = new ArrayList<>();
        nest.add(new TreeItem("Me"));
        ArrayList<TreeItem> products = new ArrayList<>();
        products.add(new TreeItem("Car"));
        products.get(0).getChildren().addAll(nest);
        rootItem.getChildren().addAll(products);*/
        
        tree.setRoot(rootItem);
        // Setting tree's node select event:
        tree.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> {
            TreeItem<String> selectedItem = (TreeItem<String>) newValue;
            ArrayList<LuluEntry> collector = new ArrayList<>();
            scopeDataMap.get(selectedItem).values().stream().forEach(a -> collector.addAll(a));
            table.setItems(FXCollections.observableArrayList(collector));
        });
        
        // Making table columns ready:
        TableColumn c0 = new TableColumn("ID");
        c0.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn c1 = new TableColumn("Access Modifier");
        c1.setCellValueFactory(new PropertyValueFactory<>("accessModifier"));
        TableColumn c2 = new TableColumn("Constant");
        c2.setCellValueFactory(new PropertyValueFactory<>("isConst"));
        TableColumn c3 = new TableColumn("Lulu Type");
        c3.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn c4 = new TableColumn("Data");
        c4.setCellValueFactory(new PropertyValueFactory<>("data"));
        TableColumn c5 = new TableColumn("Size");
        c5.setCellValueFactory(new PropertyValueFactory<>("size"));
        TableColumn c6 = new TableColumn("Offset");
        c6.setCellValueFactory(new PropertyValueFactory<>("offset"));
        table.getColumns().clear();
        table.getColumns().addAll(c0, c1, c2, c3, c4, c5, c6);
        
        /*
        tScopeData.add(new LuluEntry("average", LuluEntry.aModifier.public_, true, 
            new LuluArrayType(new LuluPrimitiveType(LuluParser.REAL_CONST), 5), 12, 18));*/
        
    }
    
    public static void main(String[] args){
        LuluSemanticAnalyzer analyzer = new LuluSemanticAnalyzer();
        try{
            File input = new File("luluTest/program1.lulu");
            //File input = new File(args[0]);
            StringBuilder program = new StringBuilder();
            Scanner scan = new Scanner(input);
            while(scan.hasNextLine())
                program.append(scan.nextLine()).append("\n");
            LuluLexer lexer = new LuluLexer(new ANTLRInputStream(program.toString()));
            LuluParser parser = new LuluParser(new CommonTokenStream(lexer));
            ParserRuleContext programCtx = parser.program();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(analyzer, programCtx);
        }catch(Exception e){}
        
        boolean successful = analyzer.errorList.isEmpty();
        if(successful){
            System.out.println("Compiled Successfully!");
            try{
                LuluMiniatureCodeGenerator generator = new LuluMiniatureCodeGenerator(analyzer);
                File output = new File(args[1]);
                FileWriter writer = new FileWriter(output);
                writer.write(generator.getCode());
                writer.flush();
                writer.close();
            }catch(Exception e){}
            ArrayList<String> flags = new ArrayList<>();
            for(String s:args)
                if(s.charAt(0)=='-') flags.add(s);
            if(flags.contains("-reveal")) launch(args);
            /*
            if(flags.contains("-simulate")) try{
                Runtime.getRuntime().exec("python3 assembler/assemble.py "+args[1]+" __mc.mc");
                Runtime.getRuntime().exec("python3 simulator/simulate.py __mc.mc");
            }catch(Exception e){}*/
        }
        else
            analyzer.errorList.stream().forEach(error -> 
                System.err.println(error+" {"+error.getStart()+"|"+error.getEnd()+"}"));
    }
    
}
