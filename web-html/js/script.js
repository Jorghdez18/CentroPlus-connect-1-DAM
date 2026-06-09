// DATOS SIMULADOS (SIN API)

let actividades = [
    { id: 1, nombre: "Fútbol", tipo: "Deporte", plazas: "10/20" },
    { id: 2, nombre: "Programación Java", tipo: "Académica", plazas: "5/15" },
    { id: 3, nombre: "Natación", tipo: "Deporte", plazas: "8/12" }
];

let reservas = [
    { usuario: "Juan", actividad: "Fútbol", fecha: "2026-05-10" },
    { usuario: "Ana", actividad: "Java", fecha: "2026-05-12" }
];

let incidencias = [];

// CAMBIAR SECCIONES
function mostrarSeccion(id) {
    document.querySelectorAll(".panel").forEach(p => p.classList.add("oculto"));
    document.getElementById(id).classList.remove("oculto");
}

// ACTIVIDADES
function cargarActividades() {
    const cont = document.getElementById("listaActividades");
    cont.innerHTML = "";

    actividades.forEach(a => {
        cont.innerHTML += `
      <div class="card">
        <h3>${a.nombre}</h3>
        <p>Tipo: ${a.tipo}</p>
        <p>Plazas: ${a.plazas}</p>
      </div>
    `;
    });
}

// RESERVAS
function cargarReservas() {
    const cont = document.getElementById("listaReservas");
    cont.innerHTML = "";

    reservas.forEach(r => {
        cont.innerHTML += `
      <div class="card">
        <p>Usuario: ${r.usuario}</p>
        <p>Actividad: ${r.actividad}</p>
        <p>Fecha: ${r.fecha}</p>
      </div>
    `;
    });
}

// INCIDENCIAS
document.getElementById("formIncidencia").addEventListener("submit", function (e) {
    e.preventDefault();

    const nueva = {
        usuario: document.getElementById("usuario").value,
        asunto: document.getElementById("asunto").value,
        descripcion: document.getElementById("descripcion").value
    };

    incidencias.push(nueva);

    document.getElementById("msg").innerText = "Incidencia guardada ✔";

    renderIncidencias();

    this.reset();
});

function renderIncidencias() {
    const cont = document.getElementById("listaIncidencias");
    cont.innerHTML = "";

    incidencias.forEach(i => {
        cont.innerHTML += `
      <div class="card">
        <p><b>${i.asunto}</b></p>
        <p>${i.descripcion}</p>
        <small>${i.usuario}</small>
      </div>
    `;
    });
}

// INICIO
cargarActividades();
cargarReservas();
renderIncidencias();