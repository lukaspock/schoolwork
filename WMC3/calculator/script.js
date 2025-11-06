
function calculate() {
    let operand1 = parseFloat(document.getElementById('operand1').value);
    let operand2 = parseFloat(document.getElementById('operand2').value);
    let seelement = document.getElementById('selectelement').value;
    let resultElement = document.getElementById('result');

    let result;
    
    
    alert(seelement);

    let functionList ={};

    functionList['+'] = (a, b) => a + b;
    functionList['-'] = (a, b) => a - b;
    functionList['*'] = (a, b) => a * b;
    functionList['/'] = (a, b) => a / b;
    

    switch(seelement)
    {
        case '+':   alert(functionList['+'](operand1,operand2));
                    break;
        case '-':   alert(functionList['-'](operand1,operand2));
                    break;
        case '*':   alert(functionList['*'](operand1,operand2));
                    break;
        case '/':   alert(functionList['/'](operand1,operand2));
                    break;
    }

    
    

}

function addHistory(op1, op2, result, operator)
{
    let ul = document.getElementById('list');
    let li1 = document.createElement('li');
    li1.innerHTML = op1 + operator + op2 + "=" + result;

    ul.prepend(li1);
}

    
