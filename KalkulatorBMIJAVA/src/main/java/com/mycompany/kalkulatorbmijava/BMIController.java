package com.mycompany.kalkulatorbmijava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMIController implements Initializable {

    @FXML
    private TextField txtBerat;

    @FXML
    private TextField txtTinggi;

    @FXML
    private Button btnHitung;

    @FXML
    private Label lblHasilBMI;

    @FXML
    private Label lblKategori;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void hitungBMI(ActionEvent event) {
        try {
            double berat = Double.parseDouble(txtBerat.getText());
            double tinggiCm = Double.parseDouble(txtTinggi.getText());

            if (berat <= 0 || tinggiCm <= 0) {
                tampilkanAlert("Input Tidak Valid", "Berat dan tinggi badan harus lebih besar dari 0!");
                return;
            }

            double tinggiMeter = tinggiCm / 100.0;
            double bmi = berat / (tinggiMeter * tinggiMeter);

            lblHasilBMI.setText(String.format("Hasil BMI: %.2f", bmi));
            lblKategori.setText("Kategori: " + tentukanKategori(bmi));

        } catch (NumberFormatException e) {
            tampilkanAlert("Format Error", "Masukkan angka yang valid untuk berat dan tinggi!");
        }
    }

    private String tentukanKategori(double bmi) {
        if (bmi < 18.5) {
            return "Kekurangan Berat Badan (Underweight)";
        } else if (bmi < 25.0) {
            return "Normal / Ideal";
        } else if (bmi < 30.0) {
            return "Kelebihan Berat Badan (Overweight)";
        } else {
            return "Obesitas";
        }
    }

    private void tampilkanAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}