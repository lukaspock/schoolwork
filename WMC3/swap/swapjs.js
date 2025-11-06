"use strict"

let o1 = {
    number1: 100,
    number2: 200
};

let o2 = {
    number1: 300,
    number2: 400,
      
};



function print(o1){
    for(let key in o2)
        {
           alert(key + ": " + o1[key]);
        }
}
/*
alert("o1: ");
print(o1);

alert("o2: ");
print(o2);

swap(o1,o2);

alert("o1: ");
print(o1);

alert("o2: ");
print(o2);
*/

let obj = new User("Gernot", 16);
let obj2 = new User("Max", 32);

console.log( obj);
console.log( obj2);


function User(name, age)
{
    this.name = name;
    this.age = age;
    this.alive = true;
}

