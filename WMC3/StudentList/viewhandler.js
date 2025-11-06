"use strict"

import {Student} from './student.js';
import {ObjectList} from './objectList.js';
import { Facade } from './Facade.js';
import { StudentDAO } from './StudentDAO.js';

export function ViewHandler(facade, fN, lN, e, output, clButton, addButton)
{
    this.facade = facade;
    this.firstName = document.getElementById(fN);
    this.lastName = document.getElementById(lN);
    this.email = document.getElementById(e);
    this.outputlist = document.getElementById(output);
    this.clear = document.getElementById(clButton);
    this.add = document.getElementById(addButton);
}

ViewHandler.prototype.renderStudents = function(){
    this.outputlist.innerHTML = "";
    console.log(this.facade.getLength());
    console.log(this.facade);

    for(let i= 0; i < this.facade.getLength(); i++)
    {
        let currentStudent = this.facade.getByIndex(i);
        console.log("current: " + currentStudent);
        let p = document.createElement('p');
        p.innerHTML = currentStudent.getfirstname() + " " + currentStudent.getlastname() + " - " + currentStudent.getemail();
        let dB = document.createElement('button');
        dB.innerHTML = "DELETE";
        dB.onclick = this.deleteStudent.bind(this, i);
        this.outputlist.append(p);
        this.outputlist.append(dB);   
    }
}

ViewHandler.prototype.reloadStudents = function() {
    this.facade.loadStudents(() => {
      this.renderStudents();
    });
}


ViewHandler.prototype.bind = function() {
    
    this.add.onclick = this.addStudent.bind(this);
    this.clear.onclick = this.clearForm.bind(this);
}

ViewHandler.prototype.validateInput = function() {

}

ViewHandler.prototype.clearForm = function() {
    
    this.firstName.value = " ";
    this.lastName.value = " ";
    this.email.value = " ";
}

ViewHandler.prototype.deleteStudent = function(index) {
    this.facade.deleteStudent(() => {this.reloadStudents();},index);
    ;
}

ViewHandler.prototype.addStudent = function() {
    
    let firstName = this.firstName.value;
    let lastName = this.lastName.value;
    let email = this.email.value;

    let student = new Student(firstName, lastName, email);

    this.facade.addStudent(() => {
        this.reloadStudents();
        this.clearForm();
    },student);
    
    
}

ViewHandler.prototype.init = function() {
    this.reloadStudents();
}

function start() {
    let dao = new StudentDAO("http://localhost:3000/students/");
    let facade = new Facade(dao);
    let view = new ViewHandler(facade, "firstName", "lastName", "email", "outputlist", "clear", "add");
    view.bind();
    view.init(); //loading students
 }
 start();
