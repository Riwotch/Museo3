package museo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainWindowController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonModify.setDisable(true);
        showItems();
    }

    @FXML
    void handleButtonAdd(ActionEvent event) {
    }

    @FXML
    void handleButtonSearch(ActionEvent event) {
        showItems();
    }

    @FXML
    void handleButtonModify(ActionEvent event) {

    }

    @FXML
    void handleButtonCancelSearch(ActionEvent event) {
        textFieldInventory.setText("");
        showItems();
    }

    public ObservableList<Items> getItemsList(String keyword){

        ObservableList<Items> itemsList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        String query = "SELECT " +
                "item.id, item.name, item.description, item.image, item.price, item.acquired_at, item.modified_at, " +
                "item.is_active, era.name AS eraName, bibliography.title AS biblioTitle , bibliography.link AS biblioLink, " +
                "tag.name AS tagName, substate.name AS substateName " +
                "FROM ((((item " +
                "INNER JOIN era ON item.id_era = era.id) " +
                "INNER JOIN bibliography ON item.id_bibliography = bibliography.id) " +
                "INNER JOIN tag ON item.id_tag = tag.id) " +
                "INNER JOIN substate " +
                "ON item.id_substate = substate.id)" +
                "WHERE item.name LIKE '%"+ keyword +"%'";

        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()){
                Items items = new Items(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getFloat("price"),
                        rs.getString("eraName"),
                        rs.getString("biblioTitle"),
                        rs.getString("biblioLink"),
                        rs.getString("tagName"),
                        rs.getString("subStateName")
                );
                itemsList.add(items);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return itemsList;
    }

    // Recupère les données filtrer par la valeur du textfield si vide affiche toute la base
    public void showItems(){
        ObservableList<Items> itemsList = getItemsList(textFieldInventory.getText());

        tableColumnNom.setCellValueFactory(new PropertyValueFactory<Items, String>("name"));
        tableColumnTag.setCellValueFactory(new PropertyValueFactory<Items, String>("tagName"));
        tableColumnStatus.setCellValueFactory(new PropertyValueFactory<Items, String>("subStateName"));

        tableViewInventory.setItems(itemsList);
    }

    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/museo", "root", "");
            return conn;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @FXML
    public void clickItem(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
            buttonModify.setDisable(false);
            textAreaDescription.setText(tableViewInventory.getSelectionModel().getSelectedItem().getDescription());
        }
    }

    @FXML
    void initialize() {
        assert tabInventaire != null : "fx:id=\"tabInventaire\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tabPaneInventory != null : "fx:id=\"tabPaneInventory\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tableViewInventory != null : "fx:id=\"tableViewInventory\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tableColumnNom != null : "fx:id=\"tableColumnNom\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tableColumnStatus != null : "fx:id=\"tableColumnStatus\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tableColumnTag != null : "fx:id=\"tableColumnTag\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldInventory != null : "fx:id=\"textFieldInventory\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert buttonModify != null : "fx:id=\"buttonModify\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert buttonSearch != null : "fx:id=\"buttonSearch\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert buttonCancelSearch != null : "fx:id=\"buttonCancelSearch\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert ImageViewInventory != null : "fx:id=\"ImageViewInventory\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tabPaneDetail != null : "fx:id=\"tabPaneDetail\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tabDescription != null : "fx:id=\"tabDescription\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tabBibliographie != null : "fx:id=\"tabBibliographie\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tabHistorique != null : "fx:id=\"tabHistorique\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tabTransactions != null : "fx:id=\"tabTransactions\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tabPretsEmprunts != null : "fx:id=\"tabPretsEmprunts\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textAreaDescription != null : "fx:id=\"textAreaDescription\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }

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
    private TableColumn<Items, String> tableColumnStatus;
    @FXML
    private TableColumn<Items, String> tableColumnTag;
    @FXML
    private Button buttonSearch;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonModify;
    @FXML
    private Button buttonCancelSearch;
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
    private Tab tabTransactions;
    @FXML
    private Tab tabPretsEmprunts;
    @FXML
    private TextArea textAreaDescription;
    @FXML
    private Font x3;
    @FXML
    private Color x4;


    //methode pour popup ajout
    /*
    @FXML
    private void handleButtonSave(ActionEvent event){
        if(event.getSource() == buttonSave){
            insertRecord();
        }
    }

    private void insertRecord() {
        String query = "INSERT INTO items VALUES (" + textFieldInventory.getText()... +","+ ... + ")"
        executeQuery(query);
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception e){

        }
    }

    */
}
