"use strict";

let b = document.getElementById("Button");

let day = document.getElementsByClassName('days-output')[0];
let month = document.getElementsByClassName('months-output')[0];
let year = document.getElementsByClassName('year-output')[0];

let inputDay = document.getElementsByClassName('day-field')[0];
let inputMonth = document.getElementsByClassName('month-field')[0];
let inputYear = document.getElementsByClassName('year-field')[0];

b.onclick = calculateAge;

function calculateAge() {
    // Ensure the input values are not empty
    if (!inputDay.value || !inputMonth.value || !inputYear.value) {
        alert("Please enter valid day, month, and year!");
        return;
    }

    // Log the raw input values for debugging
    console.log("Input Day: ", inputDay.value);
    console.log("Input Month: ", inputMonth.value);
    console.log("Input Year: ", inputYear.value);

    // Parse the input values to numbers
    let inputDayValue = Number(inputDay.value);
    let inputMonthValue = Number(inputMonth.value);
    let inputYearValue = Number(inputYear.value);

    // Validate if the inputs are actually numbers
    if (isNaN(inputDayValue) || isNaN(inputMonthValue) || isNaN(inputYearValue)) {
        alert("Invalid input: Please ensure all values are numbers.");
        return;
    }

    // Input date
    let inputDate = new Date();
    inputDate.setFullYear(inputYearValue);
    inputDate.setMonth(inputMonthValue - 1);  // Months are 0-indexed
    inputDate.setDate(inputDayValue);

    // Fetch the updated year, month, and day from the Date object
    let finalYear = inputDate.getFullYear();
    let finalMonth = inputDate.getMonth() + 1;  // Months are 0-indexed, so we add 1
    let finalDay = inputDate.getDate();

    // Output the input date values using alerts (optional, for debugging)
    alert("Input Date:");
    alert("Year: " + finalYear);
    alert("Month: " + finalMonth);
    alert("Day: " + finalDay);

    // Display the input date in the output fields
    year.textContent = finalYear;
    month.textContent = finalMonth;
    day.textContent = finalDay;
}
