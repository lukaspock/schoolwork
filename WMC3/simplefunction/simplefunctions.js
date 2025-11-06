"use strict";

const PI = 3.1415;

// 1. Kreisfläche berechnen
function berechneKreisfläche(radius = 0) {
    let fläche = PI * Math.pow(radius, 2);
    alert(fläche);
    return fläche;
}

function starteKreisBerechnung() {
    let radius = prompt("Bitte gib einen Radius ein: ", 0);
    berechneKreisfläche(radius);
}

// 2. Durchschnitt berechnen
function berechneDurchschnitt(zahl1, zahl2, zahl3) {
    console.log(zahl1, zahl2, zahl3);
    let durchschnitt = (zahl1 + zahl2 + zahl3) / 3;
    return durchschnitt;
}

function starteDurchschnittBerechnung() {
    let zahl1 = prompt("Zahl 1: ", 0);
    let zahl2 = prompt("Zahl 2: ", 0);
    let zahl3 = prompt("Zahl 3: ", 0);

    alert("Durchschnitt: " + berechneDurchschnitt(zahl1, zahl2, zahl3));
}

// 3. Prüfen auf Vokale
function enthältVokale(text) {
    const vokale = "aeiouAEIOU";

    for (let i = 0; i < text.length; i++) {
        if (vokale.includes(text[i])) {
            return true;
        }
    }
    return false;
}

function starteVokalPrüfung() {
    let eingabe = prompt("Gib einen Text ein: ", "");
    if (enthältVokale(eingabe)) {
        alert("Der Text enthält Vokale.");
    } else {
        alert("Der Text enthält keine Vokale.");
    }
}

// 4. Anzahl der Vokale zählen
function istVokal(zeichen) {
    return "aeiouAEIOU".includes(zeichen);
}

function zähleVokale(text) {
    let vokalZähler = 0;

    for (let buchstabe of text) {
        if (istVokal(buchstabe)) {
            vokalZähler++;
        }
    }
    return vokalZähler;
}

function starteVokalZählung() {
    let eingabe = prompt("Gib einen Text ein: ", "");
    let vokaleAnzahl = zähleVokale(eingabe);

    if (vokaleAnzahl > 0) {
        alert("Der Text enthält " + vokaleAnzahl + " Vokal(e).");
    } else {
        alert("Der Text enthält keine Vokale.");
    }
}

starteKreisBerechnung();
starteDurchschnittBerechnung();
starteVokalPrüfung();
starteVokalZählung();
