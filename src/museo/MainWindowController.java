package museo;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tabInventaire;

    @FXML
    private AnchorPane tabPaneInventory;

    @FXML
    private TableView<Items> tableViewInventory;

    @FXML
    private TableColumn<Items, String> tableColumnNom;

    @FXML
    private TableColumn<Items, String> tableColumnExpo;

    @FXML
    private TableColumn<Items, String> tableColumnEtat;

    @FXML
    private Button buttonSearch;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField textFieldInventory;

    @FXML
    private ImageView ImageViewInventory;

    @FXML
    private TabPane tabPaneDetail;

    @FXML
    private Tab tabDescription;

    @FXML
    private Tab tabBibliographie;

    @FXML
    private Tab tabHistorique;

    @FXML
    private Tab tabAchats;

    @FXML
    private Tab tabVentes;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void handleButtonAdd(ActionEvent event) {
    }

    @FXML
    void handleButtonSearch(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tabInventaire != null : "fx:id=\"tabInventaire\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tabPaneInventory != null : "fx:id=\"tabPaneInventory\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tableViewInventory != null : "fx:id=\"tableViewInventory\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tableColumnNom != null : "fx:id=\"tableColumnNom\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tableColumnExpo != null : "fx:id=\"tableColumnExpo\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tableColumnEtat != null : "fx:id=\"tableColumnEtat\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert buttonSearch != null : "fx:id=\"buttonSearch\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert textFieldInventory != null : "fx:id=\"textFieldInventory\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert ImageViewInventory != null : "fx:id=\"ImageViewInventory\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tabPaneDetail != null : "fx:id=\"tabPaneDetail\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tabDescription != null : "fx:id=\"tabDescription\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tabBibliographie != null : "fx:id=\"tabBibliographie\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tabHistorique != null : "fx:id=\"tabHistorique\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tabAchats != null : "fx:id=\"tabAchats\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert tabVentes != null : "fx:id=\"tabVentes\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'MainWindowSave.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'MainWindowSave.fxml'.";

    }

    public Connection getConnection(){
        Connection conn;
        try{

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
