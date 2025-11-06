"use strict"

start();

function start()
{
    let b = document.querySelector("#calc")
    let b2 = document.querySelector("#calc2")
    b.onclick= sendRequest;
    b2.onclick= sendRequest2;
}

function calc(operand1, operand2, operator){
    let functionList = {};
    functionList["+"] = (a, b) => a + b;
    functionList["-"] = (a, b) => a - b;
    functionList["*"] = (a, b) => a * b;
    functionList["/"] = (a, b) => a / b;
    let num1 = Number(document.getElementById("number1").value)
    let num2 = Number(document.getElementById("number2").value)
    
    let op = getOper();

    //res(functionList[op](num1,num2))
    res(functionList[operator](operand1,operand2));

}

function getOper(){
    let op = document.querySelector("#operators").value
    return op
}

function res(val){
    let res = document.getElementById("result")
    res.value = val;
}

function serverRequest(operand1, operand2, operator, callback)
{
    setTimeout(function(){    // this function is called after 5 secs
        let result = calc(operand1, operand2, operator);
        callback(result);
      },100);
}

function sendRequest()
{
    let op1 = Number(document.getElementById("number1").value);
    let op2 = Number(document.getElementById("number2").value);
    let op = document.querySelector("#operators").value;
    
    let a = (result) => {
        let answer = document.getElementById("result");
        answer.textContent = result;
    }

    serverRequest(op1, op2, op, a);
}

function sendRequest2()
{
    let op1 = Number(document.getElementById("number1").value);
    let op2 = Number(document.getElementById("number2").value);
    let op = String(document.querySelector("#operators").value);
    
    let a = (result) => {
        let answer = document.getElementById("result");
        answer.value = result;
    }

    calcRemote(op1, op2, op, a);
}

function calcRemote(op1, op2, op, callback) 
{
    let xhr = new XMLHttpRequest();
    let url = new URL("https://faas-fra1-afec6ce7.doserverless.co/api/v1/web/fn-a2df8e50-3266-47e2-819b-8c46de65fb73/wmcdemos/Calculator");
    url.searchParams.set("operand1", op1);
    url.searchParams.set("operand2", op2);
    url.searchParams.set("operator", op);
    xhr.onload = () => callback(xhr.response);
    xhr.open('GET', url);
    xhr.send();
}
