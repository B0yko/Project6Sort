package com.example.project6sort;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;

import static javafx.scene.chart.XYChart.Data;
import static javafx.scene.chart.XYChart.Series;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static final int
            BAR_COUNT = 14,
            MAX_BAR_HEIGHT = 50;

    private static final String
            COLOR_ACTIVE = "-fx-bar-fill: #f64",
            COLOR_INITIAL = "-fx-bar-fill: #888",
            COLOR_FINALIZED = "-fx-bar-fill: #3cf";

    private static final int
            DELAY_MILLIS = 700;


    private ObservableList<Data<String, Number>> bars;
    private BarChart<String, Number> chart;
    private FlowPane inputs;


    @Override
    public void start(Stage stage) {
        stage.setTitle("Sorting Animations");
        stage.setWidth(800);
        stage.setHeight(600);

        final BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));

        makeChart(pane);
        makeButtons(pane);

        stage.setScene(new Scene(pane));
        stage.show();

        randomizeAll();
    }

    private void makeChart(BorderPane pane) {
        chart = new BarChart<>(new CategoryAxis(), new NumberAxis(0, MAX_BAR_HEIGHT, 0));
        chart.setLegendVisible(false);
        chart.getYAxis().setTickLabelsVisible(false);
        chart.getYAxis().setOpacity(0);
        chart.getXAxis().setTickLabelsVisible(false);
        chart.getXAxis().setOpacity(0);
        chart.setHorizontalGridLinesVisible(false);
        chart.setVerticalGridLinesVisible(false);

        bars = FXCollections.observableArrayList();
        chart.getData().add(new Series<>(bars));

        for (int i = 0; i < BAR_COUNT; i++) {
            Data<String, Number> dataObject = new Data<>(Integer.toString(i + 1), 1);
            bars.add(dataObject);
            addPainting(dataObject.getNode(), COLOR_INITIAL);
        }
        pane.setCenter(chart);
    }


    private void makeButtons(BorderPane pane) {
        inputs = new FlowPane();
        inputs.setHgap(5);
        inputs.setVgap(5);
        createButton("Randomize", () -> randomizeAll());
        pane.setBottom(inputs);
    }

    private void addPainting(Node newNode, String colorInitial) {
        if (newNode != null) {
            newNode.setStyle(colorInitial);
        }
    }

    private void createButton(String label, Runnable method) {
        final Button test = new Button(label);
        test.setOnAction(event -> method.run());
        inputs.getChildren().add(test);
    }


    private void randomizeAll() {
        Random random = new Random();
        for (Data<String, Number> bar : bars) {
            bar.setYValue(random.nextInt(MAX_BAR_HEIGHT) + 1);
        }
    }
}
