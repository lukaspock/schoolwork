

function Category(name,id,description)
{
    this.name = name;
    this.id = id;
    this.description = description;
}

Category.prototype.getName = function(){return this.name;} 
Category.prototype.getId = function(){return this.id;} 
Category.prototype.gegetDescriptiontId = function(){return this.getDescription;} 

export { Category };