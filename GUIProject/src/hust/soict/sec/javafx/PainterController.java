package hust.soict.sec.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton;
    @FXML
    private RadioButton eraserRadioButton;

    private Color currentColor;

    @FXML
    private ToggleGroup Tools;
    
    @FXML
    public void initialize() {
        // Set pen as the initial tool
        penRadioButton.setSelected(true);
        currentColor = Color.BLACK;
        
        // Create a ToggleGroup and assign it to the radio buttons
        Tools = new ToggleGroup();
        penRadioButton.setToggleGroup(Tools);
        eraserRadioButton.setToggleGroup(Tools);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4);
        newCircle.setStroke(null);
        
        if (eraserRadioButton.isSelected()) {
            newCircle.setFill(drawingAreaPane.getBackground().getFills()
            		.get(0).getFill());
            
        } else {
            newCircle.setFill(currentColor);
        }
        
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    
}
