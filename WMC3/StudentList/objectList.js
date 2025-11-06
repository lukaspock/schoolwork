"use strict"

export function ObjectList()
{
    this.list = [];
}

ObjectList.prototype.add = function(object) {
    this.list.push(object);
}

ObjectList.prototype.getByIndex = function(idx) {
    return this.list[idx];
}

ObjectList.prototype.getLength = function(){
    return this.list.length;
}

ObjectList.prototype.deleteByIndex = function(idx){
    this.list.splice(idx,1);
}

ObjectList.prototype.createStudent = function(idx){
    let div = document.createElement(div);
    let p = document.createElement(p);

    p.innerHTML = this.list[idx].get
}


