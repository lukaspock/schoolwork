"use strict"

let b = document.getElementById('calc');
b.onclick = calculate;


function calculate()
{
    let list = {};
    
    list["+"] = (a,b) => Number(a) + Number(b);
    list["-"] = (a,b) => Number(a) - Number(b);
    list["*"] = (a,b) => Number(a) * Number(b);
    list["/"] = (a,b) => Number(a) / Number(b);

    let op1 = document.getElementById('num1').value;
    let op2 = document.getElementById('num2').value;
    let opperand = document.getElementById('opp').value;
    let resultField = document.getElementById('Result');
    
    let result = list[opperand](op1,op2);

    resultField.textContent = result;

}

let DomUtils = {

    dom: document,

    setValue: function sV(id, value)
    {
        this.dom.getElementById(id).value = value;
    },

    getValue: function gV(id)
    {
        return this.dom.getElementById(id).value;
    },

    elementExists: function eE(id)
    {
        if(this.dom.getElementById(id))
            return true;
        else
            return false;
    },

    setFormValues: function sFV(obj)
    {
        for(let key in obj)
        {
            if(this.elementExists(key))
            {
                this.setValue(key, obj[key]);
            }
        }
    },

    getFormValues: function gFV(obj)
    {
        for(let key in obj)
        {
            if(this.elementExists(key))
            {
                obj[key] = this.getValue(key);
            }
        }
    }
}


// <input id="num1"> <input id="num2">
console.log(DomUtils.elementExists("num1")); // true
DomUtils.setValue("num1", 5);
DomUtils.setValue("num2", 10);
let data = { num1: 0, num2: 0 }
DomUtils.getFormValues(data);
console.log(data); // { num1: 5, num2: 10 }
data.num1 = 12;
DomUtils.setFormValues(data);
console.log(DomUtils.getValue("num1")); // 12