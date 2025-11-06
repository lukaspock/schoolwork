

 export function Student(fN,lN,e)
{
    this.id = null;
    this.firstname = fN;
    this.lastname = lN;
    this.email = e;
}

Student.prototype.setID = function(id){this.id = id;}

Student.prototype.getfirstname = function(){return this.firstname;}

Student.prototype.getlastname = function(){return this.lastname};

Student.prototype.getemail = function(){return this.email};

