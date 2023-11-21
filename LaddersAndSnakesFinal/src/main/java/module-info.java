module com.example.laddersandsnakesfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.laddersandsnakesfinal to javafx.fxml;
    exports com.example.laddersandsnakesfinal;
    exports com.example.laddersandsnakesfinal.Controller;
    opens com.example.laddersandsnakesfinal.Controller to javafx.fxml;
}