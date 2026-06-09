package es.ies.puerto.controllers;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.Incidencia;
import es.ies.puerto.models.Reserva;
import es.ies.puerto.services.ActividadService;
import es.ies.puerto.services.IncidenciaService;
import es.ies.puerto.services.ReservaService;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.List;

import javafx.scene.control.ListView;

public class MainController {

    private BorderPane root;

    private ActividadService actividadService = new ActividadService();
    private ReservaService reservaService = new ReservaService();
    private IncidenciaService incidenciaService = new IncidenciaService();

    private ListView<String> listAct;
    private ListView<String> listRes;
    private ListView<String> listInc;

    public MainController() {

        root = new BorderPane();
        root.setTop(menu());

        cargarDatosIniciales();
        mostrarInicio();
    }

    public BorderPane getView() {
        return root;
    }

    private VBox menu() {

        VBox v = new VBox(10);
        v.setStyle("-fx-padding:10; -fx-background-color:#1e1e2f;");

        Button b1 = btn("Inicio");
        Button b2 = btn("Actividades");
        Button b3 = btn("Reservas");
        Button b4 = btn("Incidencias");

        b1.setOnAction(e -> mostrarInicio());
        b2.setOnAction(e -> mostrarActividades());
        b3.setOnAction(e -> mostrarReservas());
        b4.setOnAction(e -> mostrarIncidencias());

        v.getChildren().addAll(b1, b2, b3, b4);

        return v;
    }

    private Button btn(String t) {
        Button b = new Button(t);
        b.setMaxWidth(Double.MAX_VALUE);
        b.setStyle("-fx-background-color:#2d89ef; -fx-text-fill:white; -fx-padding:10;");
        return b;
    }

   private void mostrarInicio() {

    VBox v = new VBox(15);
    v.setStyle("-fx-padding:20; -fx-background-color:#f2f4f8;");


    Label titulo = new Label("CENTRO PLUS CONNECT");
    titulo.setStyle(
            "-fx-font-size:22px;" +
            "-fx-font-weight:bold;" +
            "-fx-text-fill:#1e1e2f;"
    );

    Label subtitulo = new Label("Gestión de actividades deportivas y académicas");
    subtitulo.setStyle("-fx-font-size:14px; -fx-text-fill:#555;");

    VBox card = new VBox(10);
    card.setStyle(
            "-fx-background-color:white;" +
            "-fx-padding:15;" +
            "-fx-background-radius:12;" +
            "-fx-border-color:#ddd;" +
            "-fx-border-radius:12;"
    );

    Label info = new Label("Resumen del sistema");
    info.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");

    Label act = new Label("Actividades: " + actividadService.findAll().size());
    Label res = new Label("Reservas: " + reservaService.findAll().size());
    Label inc = new Label("Incidencias: " + incidenciaService.findAll().size());

    card.getChildren().addAll(info, act, res, inc);

    Label footer = new Label("Selecciona una opción en el menú");
    footer.setStyle("-fx-text-fill:#777;");

    v.getChildren().addAll(titulo, subtitulo, card, footer);

    root.setCenter(v);
}

    private void mostrarActividades() {

        VBox v = new VBox(10);
        v.setStyle("-fx-padding:15;");

        listAct = new ListView<>();

        List<Actividad> lista = actividadService.findAll();

        if (lista.isEmpty()) {
            listAct.getItems().add("No hay actividades cargadas");
        }

        for (int i = 0; i < lista.size(); i++) {

            Actividad a = lista.get(i);

            listAct.getItems().add(
                    a.getId() + " - " +
                    a.getNombre() +
                    " | plazas: " +
                    a.getPlazasDisponibles()
            );
        }

        Button reservar = btn("Reservar");

        reservar.setOnAction(e -> reservarActividad());

        v.getChildren().addAll(listAct, reservar);

        root.setCenter(v);
    }

    private void reservarActividad() {

        String sel = listAct.getSelectionModel().getSelectedItem();

        if (sel == null) {
            alerta("Selecciona actividad", Alert.AlertType.WARNING);
            return;
        }

        int id = Integer.parseInt(sel.split(" - ")[0]);

        boolean ok = actividadService.reservarPlaza(id);

        if (ok) {

            reservaService.crearReserva(
                    reservaService.findAll().size() + 1,
                    1,
                    id
            );

            alerta("Reserva creada", Alert.AlertType.INFORMATION);
            mostrarActividades();
        } else {
            alerta("Sin plazas", Alert.AlertType.ERROR);
        }
    }

    private void mostrarReservas() {

        VBox v = new VBox(10);
        v.setStyle("-fx-padding:15;");

        listRes = new ListView<>();

        List<Reserva> lista = reservaService.findAll();

        if (lista.isEmpty()) {
            listRes.getItems().add("No hay reservas");
        }

        for (int i = 0; i < lista.size(); i++) {

            Reserva r = lista.get(i);

            listRes.getItems().add(
                    r.getId() +
                    " | Usuario: " + r.getIdUsuario() +
                    " | Act: " + r.getIdActividad()
            );
        }

        Button cancelar = btn("Cancelar");

        cancelar.setOnAction(e -> cancelarReserva());

        v.getChildren().addAll(listRes, cancelar);

        root.setCenter(v);
    }

    private void cancelarReserva() {

        String sel = listRes.getSelectionModel().getSelectedItem();

        if (sel == null) {
            alerta("Selecciona reserva", Alert.AlertType.WARNING);
            return;
        }

        int id = Integer.parseInt(sel.split(" ")[0]);

        reservaService.cancelarReserva(id);

        alerta("Cancelada", Alert.AlertType.INFORMATION);
        mostrarReservas();
    }

    private void mostrarIncidencias() {

        VBox v = new VBox(10);
        v.setStyle("-fx-padding:15;");

        TextField asunto = new TextField();
        TextArea desc = new TextArea();

        Button enviar = btn("Enviar");

        listInc = new ListView<>();

        cargarIncidencias();

        enviar.setOnAction(e -> {

            incidenciaService.crearIncidencia(
                    incidenciaService.findAll().size() + 1,
                    1,
                    asunto.getText(),
                    desc.getText()
            );

            asunto.clear();
            desc.clear();

            cargarIncidencias();
        });

        v.getChildren().addAll(asunto, desc, enviar, listInc);

        root.setCenter(v);
    }

    private void cargarIncidencias() {

        listInc.getItems().clear();

        List<Incidencia> lista = incidenciaService.findAll();

        if (lista.isEmpty()) {
            listInc.getItems().add("No hay incidencias");
        }

        for (int i = 0; i < lista.size(); i++) {

            Incidencia in = lista.get(i);

            listInc.getItems().add(
                    in.getId() + " - " + in.getAsunto()
            );
        }
    }

    private void cargarDatosIniciales() {

        actividadService.save(new Actividad(1, "Fútbol", "Deporte", 60, 5.0, 10));
        actividadService.save(new Actividad(2, "Baloncesto", "Deporte", 60, 6.0, 8));
        actividadService.save(new Actividad(3, "Programación", "Academica", 90, 10.0, 5));

        reservaService.crearReserva(1, 1, 1);
    }

    private void alerta(String m, Alert.AlertType t) {
        Alert a = new Alert(t);
        a.setContentText(m);
        a.showAndWait();
    }
}