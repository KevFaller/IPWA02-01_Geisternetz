// Initialisierung der Karte
function initMap() {
    // Koordinaten für den Mittelpunkt der Karte
    var center = [0, 0];

    // Optionen für die Karte
    var mapOptions = {
        zoom: 2,
        center: center
    };

    // Erzeugung der Karte
    var map = L.map('map').setView(center, mapOptions.zoom);

    // Hinzufügen der Kacheln (Tile Layer) von OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Kartenmaterial &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
        maxZoom: 18,
    }).addTo(map);
}

// Funktion zum Laden der Karte beim Start der Seite
window.onload = function() {
    initMap();
};
