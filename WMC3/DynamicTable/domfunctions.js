"use strict";

document.getElementById('addTableBtn').addEventListener('click', createNewTable);

function readString() {
    return prompt("Bitte Text eingeben, durch Kommas getrennt:");
}

function readNumber() {
    let rowCount = prompt("Bitte Anzahl der Zeilen eingeben:");
    return parseInt(rowCount, 10); 
}

function addHeading(table, headings) {
    let headersArray = headings.split(',');
    let theadElement = document.createElement('thead');
    let headerRow = document.createElement('tr');

    for (let i = 0; i < headersArray.length; i++) {
        let thElement = document.createElement('th');
        thElement.textContent = headersArray[i];
        headerRow.appendChild(thElement);
    }

    theadElement.appendChild(headerRow);
    table.appendChild(theadElement);
}

function addRow(table) {
    let rowText = readString();
    let rowArray = rowText.split(',');

    let rowElement = document.createElement('tr');

    for (let i = 0; i < rowArray.length; i++) {
        let tdElement = document.createElement('td');
        tdElement.textContent = rowArray[i];
        rowElement.appendChild(tdElement);
    }

    table.querySelector('tbody').appendChild(rowElement);
}

function createTable() {
    let headerText = prompt("Bitte die Spaltenüberschriften eingeben, durch Kommas getrennt:");
    let numberOfRows = readNumber();

    let tableContainer = document.createElement('div');
    tableContainer.className = 'table-container';

    let addRowBtn = document.createElement('button');
    addRowBtn.textContent = 'Add Row';
    
    let table = document.createElement('table');
    let tbody = document.createElement('tbody');
    table.appendChild(tbody);

    addHeading(table, headerText);

    for (let i = 0; i < numberOfRows; i++) {
        addRow(table);
    }

    addRowBtn.addEventListener('click', () => addRow(table));

    tableContainer.appendChild(addRowBtn);
    tableContainer.appendChild(table);

    document.getElementById('tablesContainer').appendChild(tableContainer);
}

function createNewTable() {
    createTable();
}
