let lableElement = document.createElement("label"); 
let pElem = document.body.children[0];



pElem.append(lableElement);
lableElement.id = "student";
lableElement.setAttribute("for", "student");
lableElement.innerHTML = "student";



let inputElement = document.createElement("input");
pElem.append(inputElement);
inputElement.id = "name"; 
inputElement.type = "input1";



let lableElement2 = document.createElement("label");
pElem.append(lableElement2);
lableElement2.id = "subjects";
lableElement2.innerHTML = "Subjects";



let selectElement = document.createElement("select");
pElem.append(selectElement);



let optionElement = document.createElement("option");
optionElement.innerHTML = "german";
selectElement.appendChild(optionElement);



let optionElement2 = document.createElement("option");
optionElement2.innerHTML = "math";
selectElement.appendChild(optionElement2);



let optionElement3 = document.createElement("option");
optionElement3.innerHTML = "pos";
selectElement.appendChild(optionElement3);



let buttonElement = document.createElement("button");
pElem.append(buttonElement);
buttonElement.innerHTML = "Submit";
