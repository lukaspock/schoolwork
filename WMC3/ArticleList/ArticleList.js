"use strict"

let b = document.getElementById("button");
b.onclick = addArticle;

function addArticle(){

    let name = document.getElementById("name").value;
    let price = document.getElementById("price").value;

    if(name == 0 && price == 0)
    {
        alert("FEHLER NO IMPUT");
        return;
    }

    let li = document.createElement('li');
    let ol = document.getElementById('list');

    li.innerHTML = name +"(€"+price+")";
    ol.append(li);
}
