package controllers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane; // Import Pane for CircuitEditorController
import javafx.stage.Stage;
import tools.Tool;
import tools.WireTool;
import tools.InputTool; // Import the InputTool
import tools.OutputTool; // Import the OutputTool

public class Main extends Application {
    private CircuitEditorController circuitEditor;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quantum Circuit Simulator");

        // root layout with dynamic resizing capability
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        // create the MenuBar with File and Tools menus
        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-color: #5c4d80;");

        // file menu
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem loadItem = new MenuItem("Load");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(newItem, saveItem, loadItem, exitItem);

        // tools menu
        Menu toolsMenu = new Menu("Tools");
        MenuItem selectionTool = new MenuItem("Selection");
        MenuItem wireTool = new MenuItem("Wire");
        MenuItem gateTool = new MenuItem("Gate");
        MenuItem inputTool = new MenuItem("Input"); // Add Input Tool
        MenuItem outputTool = new MenuItem("Output"); // Add Output Tool
        toolsMenu.getItems().addAll(selectionTool, wireTool, gateTool, inputTool, outputTool);

        // add File and Tools menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, toolsMenu);
        root.setTop(menuBar);

        // Create a resizable pane for the circuit editor
        Pane pane = new Pane();
        circuitEditor = new CircuitEditorController(pane); // Pass the pane to the controller
        root.setCenter(pane); // Set pane to center

        // event handlers for File Menu
        saveItem.setOnAction(e -> System.out.println("Save File"));
        loadItem.setOnAction(e -> System.out.println("Load File"));
        exitItem.setOnAction(e -> System.exit(0));

        // event handlers for Tool Menu
        selectionTool.setOnAction(e -> {
            // future tool for selection
        });

        wireTool.setOnAction(e -> {
            circuitEditor.setActiveTool(new WireTool(circuitEditor));
        });

        gateTool.setOnAction(e -> {
            // future tool for gate placement
        });

        inputTool.setOnAction(e -> {
            circuitEditor.setActiveTool(new InputTool(circuitEditor)); // Switch to Input Tool
        });

        outputTool.setOnAction(e -> {
            circuitEditor.setActiveTool(new OutputTool(circuitEditor)); // Switch to Output Tool
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
