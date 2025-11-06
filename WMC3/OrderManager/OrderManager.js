"use strict"

let add = document.getElementById("add");
let remove = document.getElementById("remove");
let calculate = document.getElementById("calculate")
let output = document.getElementById("erg");
let s1 = document.getElementById("Select1");
let s2 = document.getElementById("Select2");

remove.onclick = removeOrder;
add.onclick = addOrder;
calculate.onclick = calculateTotal;
s1.onchange = calculateShipment;

function addOrder(){
   
    let help = s1.selectedIndex;
    let se = s1.querySelectorAll("option");
    let o1 = se[help];
    s2.append(o1);

}

function removeOrder(){

    let help = s2.selectedIndex;
    let se = s2.querySelectorAll("option");
    let o1 = se[help];
    s1.append(o1);

}

function calculateTotal(){

    let price = calcPrice();

    output.textContent = price;

}

function calcPrice(){

    let price = 0;
    let se = s2.options;

    for(let i=0; i<se.length; i++)
    {
        price = price + Number(se[i].getAttribute('data-price'));
    }

    return price;
}

function functionList(price){

    let shipmentModeList = ["none", "std", "cac", "gw"];

    shipmentModeList["none"] = (option, e) => {
        return "Select a shipment mode!";
    }
    shipmentModeList["std"] = (option, price) => {
        if(option.dataset.ineu == false){
            if(price<=100){
                return price + 5;
            }
            return price + 11;
        }
        return price;
    }
    shipmentModeList["cac"] = (option, e) => {
        if(option.dataset.ineu == false){
            return "shipment mode is not possible";
        }
        if(e<=50){
            return e + 5;
        }
        return e;
    }
    shipmentModeList["gw"] = (option,e) => {
        return 1;
    }

    let SeCountry = document.getElementById("country").selected;
    let SeShipment = document.getElementById("shipmentMode").selectedOptions[0];
    let value = SeShipment.value;

    let a = shipmentModeList[value](SeShipment, price);

    alert(a);

    let ergShipment = document.getElementById("erg shipment");
    ergShipment.textContent = a;
}

function calculateShipment(){

    let price = calcPrice();
    functionList(price);
}



    
