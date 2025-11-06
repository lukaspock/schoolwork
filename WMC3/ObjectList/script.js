"use strict"

let out = document.getElementById('price').innerHTML;
let output = document.getElementById('shipment').innerHTML;

let shipmentModeList = new Array();

shipmentModeList["none"] = () => alert("select  a shipment mode!");
shipmentModeList["std"] = (amount, inEU) => 
{
    let sum = amount;

    if(inEU == "false")
    {
        sum += 5;
    }
    if(amount <= 100)
    {
        sum += 6;
    }

    return sum;
}
shipmentModeList["cac"] = (amount, inEU) => 
{
    let sum = amount;

    if(inEU == "false")
    {
        return "Shipment not possible"
    }
    if(amount <= 50)
    {
        sum += 5;
    }

    return sum;
}

shipmentModeList["gw"] = (amount, inEU) => 
{
    let sum = amount;

    if(inEU == "false")
        {
            sum += 8;
        }
        else
        {
            sum += 3;
        }
        if(amount <= 100)
        {
            sum += 4;
        }

        return sum;
}

let rbutton = document.getElementById('right');
let lbutton = document.getElementById('left');
let cbutton = document.getElementById('calculate');

let available = document.getElementById('available');
let selection = document.getElementById('selection');
let country = document.getElementById('country');
let mode = document.getElementById('modes');

rbutton.onclick = right;
lbutton.onclick = left;
cbutton.onclick = calculate;

country.addEventListener('change',shipment );
mode.addEventListener('change',shipment );


function right()
{
    let index = available.selectedIndex;
    let options = available.querySelectorAll('option');
    let selection = document.getElementById('selection');

    selection.append(options[index]);

    
}

function left()
{
    
    let index = selection.selectedIndex;
    let options = selection.querySelectorAll('option');

    available.append(options[index]);

    display();
}

function calculate()
{
    let options = selection.querySelectorAll('option');
    let output = document.getElementById('price');
    let sum = 0;

    for(let i = 0; i < options.length; i++)
    {
        sum += Number(options[i].dataset.price);
    }

    output.innerHTML = out + sum;

    return sum;
}

function display()
{
    let options = selection.querySelectorAll('option');
    let output = document.getElementById('price');
    
    if(options.length == 1)
        {
            output.setAttribute("class", "Displayed");
            cbutton.setAttribute("class", "Displayed");  
        }
    
    if(options.length == 0)
        {
            output.setAttribute("class", "notDisplayed");
            cbutton.setAttribute("class", "notDisplayed");  
        }
}

    

function show(sum)
{
    let output2 = document.getElementById('shipment');
    output2.innerHTML = output + sum;
}

function calculateShipment(price)
{
   let option = country.querySelectorAll('option');
   let index = country.selectedIndex;
   let ineu = option[index].dataset.ineu;
   console.log("is in eu: " + ineu);

    let index2 = mode.selectedIndex;
    let options2 = mode.querySelectorAll('option');
    let value = options2[index2].value;
    console.log("value: " + value);

    let costs = shipmentModeList[value](price, ineu);

    show(costs);

}  

function shipment()
{
    let price = calculate();
    calculateShipment(price);
}


