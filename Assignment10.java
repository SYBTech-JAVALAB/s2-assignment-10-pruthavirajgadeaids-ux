import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ArithmeticFX extends Application {

    @Override
    public void start(Stage stage) {

        TextField num1 = new TextField();
        TextField num2 = new TextField();
        TextField result = new TextField();
        result.setEditable(false);

        Label l1 = new Label("Number 1:");
        Label l2 = new Label("Number 2:");
        Label l3 = new Label("Result:");

        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");

        add.setOnAction(e -> calculate(num1, num2, result, "+"));
        sub.setOnAction(e -> calculate(num1, num2, result, "-"));
        mul.setOnAction(e -> calculate(num1, num2, result, "*"));
        div.setOnAction(e -> calculate(num1, num2, result, "/"));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(l1, 0, 0);
        grid.add(num1, 1, 0);
        grid.add(l2, 0, 1);
        grid.add(num2, 1, 1);
        grid.add(l3, 0, 2);
        grid.add(result, 1, 2);

        grid.add(add, 0, 3);
        grid.add(sub, 1, 3);
        grid.add(mul, 0, 4);
        grid.add(div, 1, 4);

        Scene scene = new Scene(grid, 300, 250);
        stage.setTitle("Arithmetic Operations");
        stage.setScene(scene);
        stage.show();
    }

    private void calculate(TextField n1, TextField n2, TextField res, String op) {
        try {
            int a = Integer.parseInt(n1.getText());
            int b = Integer.parseInt(n2.getText());
            int r = 0;

            switch (op) {
                case "+": r = a + b; break;
                case "-": r = a - b; break;
                case "*": r = a * b; break;
                case "/": r = a / b; break;
            }

            res.setText(String.valueOf(r));
        } catch (Exception e) {
            res.setText("Error");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
