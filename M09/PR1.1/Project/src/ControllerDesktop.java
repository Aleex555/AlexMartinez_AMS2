import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerDesktop implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private VBox yPane;

    @FXML
    private AnchorPane info;

    String opcions[] = { "Personatges", "Jocs", "Consoles" };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Afegeix les opcions al ChoiceBox
        choiceBox.getItems().addAll(opcions);
        // Selecciona la primera opció
        choiceBox.setValue(opcions[0]);
        // Callback que s’executa quan l’usuari escull una opció
        choiceBox.setOnAction((event) -> { loadList(); });
        // Carregar automàticament les dades de ‘Personatges’
        loadList();
    }

    public void loadList() {
        String opcio = choiceBox.getValue();
        System.out.println(opcio);
        }
        
}