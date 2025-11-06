"use strict"

function User(n)
{
    this.name = n,
    this.toString = function(){
        return "User(" + this.name + ")"
    }
}

function start()
{
    let ar = new Array();
    /*
    ar[0] = "Justin";
    ar[1] = "Julian";
    ar[2] = "Jannik";
    */
    ar[0] = new User("Justin");
    ar[1] = new User("Julian");
    ar[2] = new User("Jannik");

    let obj = new ObjectList(ar);

    //toString
    
    console.log("Obj nach toString: ", obj.toString());

    show(obj.toString());

    //add

    obj.add(new User("Marian"), 1);

    console.log("Obj nach add:",  obj.toString());

    show(obj.toString());

    //deleteAtIndex

    obj.deleteAtIndex(1);

    console.log("Obj nach deleteAtIndex:",  obj.toString());

    show(obj.toString());

    //reverse

    obj.reverse();

    console.log("Obj nach reverse:",  obj.toString());
    
    show(obj.toString());


    //optional tasks

    let julian = new User("Julian");

    console.log("Obj an 1. Index: ", obj.getAt(1));

    console.log("RV von contains(Julian)", obj.contains(julian));

    console.log("RV von IndexOf(Julian)", obj.indexOf(julian));

}

function show(str)
{
    let list = document.getElementById('list');
    let listElement = document.createElement('li');
    listElement.innerHTML = str;
    list.append(listElement);
}

start();

