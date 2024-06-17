package br.lawtrel.pdv.View;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


public class qrcodeView {
    public qrcodeView(String qrCodeFilePath, double valor) {
        Stage stage = new Stage();
        stage.setTitle("QR Code - PIX ");

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setStyle("-fx-padding: 10; -fx-alignment: center;");

        Image qrCodeIMG = new Image("file:" + qrCodeFilePath);
        ImageView imageView = new ImageView(qrCodeIMG);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);

        Label valorLabel = new Label(String.format("Valor: R$ %.2f", valor));
        valorLabel.setStyle("-fx-font-size: 16px;");
        vbox.getChildren().addAll(valorLabel, imageView);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }
}
