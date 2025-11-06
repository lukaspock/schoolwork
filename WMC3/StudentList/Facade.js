
export function Facade(dao,list)
{
    this.studentDAO = dao;
}



Facade.prototype.loadStudents = function(callback)
{
    this.studentDAO.loadStudents((list)=>{
        this.studentList = list;
        callback();
    })
}

Facade.prototype.getLength = function(){return this.studentList.length;}

Facade.prototype.getByIndex = function(idx){return this.studentList[idx];}

Facade.prototype.addStudent = function(callback,student)
{
    this.studentDAO.addStudent(function(response){
        console.log("addStudent Response: " + response);
        callback();
    },student);   
}

Facade.prototype.deleteStudent = function(callback,id)
{
    this.studentDAO.deleteStudent(function(response){
        console.log("deleteStudent Response: " + response);
        callback();
    },id);
}