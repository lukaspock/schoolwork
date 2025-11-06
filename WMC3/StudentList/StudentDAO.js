import { Student } from "./student.js";

export function StudentDAO(baseurl)
{
    this.baseurl = baseurl;
}

StudentDAO.prototype.prepareRequest = function(method, path){

    let url = new URL(this.baseurl + path);
    let xhr = new XMLHttpRequest();
    xhr.open(method,url);

    return xhr;
}

StudentDAO.prototype.loadStudents = function(callback){

    let xhr = this.prepareRequest("GET","");
    xhr.responseType = "json";
    xhr.send();
    xhr.onload = function(){
        console.log(xhr.response);
        let studentList = [];

        //callback(`${xhr.repsonse}`);

        for (let s of xhr.response) {
            studentList.push(new Student(s.id, s.firstname, s.lastname, s.email));
        }
        callback(studentList);
    }

    xhr.onerror = function(){
        console.log("ERROR - loadStudent");
    }
}

StudentDAO.prototype.addStudent = function(callback,student){
    let xhr = this.prepareRequest("POST","");
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(student));

    xhr.onload = function(){
        
        callback(xhr.response);
    }

    xhr.onerror = function(){
        console.log("ERROR - addStudent");
    }
}

StudentDAO.prototype.deleteStudent = function(callback,id){
    let xhr = this.prepareRequest("DELETE", id + 1);
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");
    
    xhr.send();
    
    xhr.onload = function(){

        console.log("Student deletete");
        callback();
    }


    xhr.onerror = function(){
        console.log("ERROR - addStudent");
    }

}

