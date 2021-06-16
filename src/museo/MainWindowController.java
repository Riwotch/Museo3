package museo;
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
        private Tab tabInventaire;

        @FXML
        private AnchorPane tabPaneInventory;

        @FXML
        private TableView<?> tableViewInventory;

        @FXML
        private TableColumn<?, ?> tableColumnNom;

        @FXML
        private TableColumn<?, ?> tableColumnExpo;

        @FXML
        private TableColumn<?, ?> tableColumnEtat;

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

    }

