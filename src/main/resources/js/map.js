// script.js

// Initialisierung der Karte
function initMap() {
    // Koordinaten für den Mittelpunkt der Karte
    var center = { lat: 0, lng: 0 };

    // Optionen für die Karte
    var mapOptions = {
        zoom: 2,
        center: center
    };

    // Erzeugung der Karte
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);

    // Beispielmarker hinzufügen
    var marker = new google.maps.Marker({
        position: center,
        map: map,
        title: "Mein Marker"
    });
}
